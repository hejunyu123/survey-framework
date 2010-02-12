package edu.vwa.easyfeedback.server.common.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.vwa.easyfeedback.client.common.model.Survey;
import edu.vwa.easyfeedback.client.common.model.SurveyUser;
import edu.vwa.easyfeedback.client.common.service.NotAuthorizedException;
import edu.vwa.easyfeedback.client.common.service.PersistenceService;
import edu.vwa.easyfeedback.client.common.service.SurveyNotFoundException;
import edu.vwa.easyfeedback.server.common.PMF;

/**
 * Server-side service implementation for saving and loading survey data to Google App Engine via JDO.
 * @author fleerkoetter
 *
 */
public class PersistenceServiceImpl extends RemoteServiceServlet implements PersistenceService {
	

	private static final long serialVersionUID = -5609326171728515316L;
	
	private static UserService userService = UserServiceFactory.getUserService();

	private PersistenceService mock = new PersistenceServiceMock();

	/**
	 * @see PersistenceService#getSurvey(String)
	 */
	public Survey getSurvey(String name) throws SurveyNotFoundException {
		if (name.equals("sample")) {
			return mock.getSurvey(name);
		}
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Survey result = null;
		try {
			try {
				result = pm.getObjectById(Survey.class, name); // throws NucleusObjectNotFoundException
			} catch (Throwable e) {
				SurveyNotFoundException se = new SurveyNotFoundException(name);
				se.initCause(e);
				throw se;
			}
			
			if (result == null) throw new SurveyNotFoundException(name);
			result  = pm.detachCopy(result);
		} finally {
			pm.close();	
		}		
		return result;
	}
	
	/**
	 * @see PersistenceService#getSurveyUser(String)
	 */
	public SurveyUser getSurveyUser(String email) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		SurveyUser result = null;
		try {
			try {
				result = pm.getObjectById(SurveyUser.class, email);
			} catch (Exception e) {

			}
			if (result == null) return null;
			result = pm.detachCopy(result);
			
		} finally {
			pm.close();
		}
		return result;
	}

	/**
	 * @see PersistenceService#saveSurveyUser(SurveyUser);
	 * @param user
	 */
	public void saveSurveyUser(SurveyUser user) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			if (user.getKey() == null) {
				user.setKey(KeyFactory.createKeyString(SurveyUser.class.getSimpleName(), user.getEmail()));
			}
			pm.makePersistent(user);
		} finally {
			pm.close();
		}
	}

	/**
	 * @throws NotAuthorizedException 
	 * @see PersistenceService#saveSurvey(Survey)
	 */
	public void saveSurvey(Survey survey) throws NotAuthorizedException {
		saveSurveyInternal(survey);

	}
	
	private Survey saveSurveyInternal(Survey survey) throws NotAuthorizedException {
		if (!userService.isUserLoggedIn()) 	throw new NotAuthorizedException();
		// Create survey in an transaction to make sure it's in in the same EntityGroup as the nested SurveyUser
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			if (survey.getKey() == null) {
				survey.setKey(KeyFactory.createKeyString(Survey.class.getSimpleName(), survey.getName()));
			}
			
			tx.begin();
			pm.makePersistent(survey);
			tx.commit();
			
			survey = pm.detachCopy(survey);
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return survey;
	}

	/**
	 * @see PersistenceService#getSurveys()
	 */
	@SuppressWarnings("unchecked")
	public Survey[] getSurveys() throws NotAuthorizedException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
//		UserService userService = UserServiceFactory.getUserService();
//		List<Survey> result = new ArrayList<Survey>();
		Survey[] result = new Survey[0];
		if (userService.isUserLoggedIn())
		{
//			SurveyUser user = getSurveyUserInternal();
			String user = userService.getCurrentUser().getEmail();
			try {
				Query query = pm.newQuery(Survey.class);
				query.setFilter("user == su");
				query.declareParameters("String su");
				try {
					List<Survey> serverResult = (List<Survey>) query.execute(user);
					
					if (serverResult.size() > 0) {
						// Detach result list
						result = new Survey[serverResult.size()+1];
						for (int i = 0; i < serverResult.size(); i++) {
							result[i] = pm.detachCopy(serverResult.get(i));
						}
						Survey demo = mock.getSurvey("sample");
						result[result.length-1] = demo;
						
					} 
//					else {
//						result =  mock.getSurveys();
//					}
				} catch (Exception e) {
				}
			}
			finally {
				pm.close();
			}
			
		}
		
		return result;
	}

	public void deleteSurvey(Survey survey) {
		
	}

	public Survey createSurvey(String caption, String description) throws NotAuthorizedException {
		if (!userService.isUserLoggedIn()) throw new NotAuthorizedException();
		
		Survey survey = new Survey();
		survey.setCaption(caption);
		survey.setCreatedAt(new Date());
		survey.setDescription(description);
		survey.setName(UUID.randomUUID().toString());
		survey.setPublishedAt(null);
//		survey.setUser(user);
		survey.setUser(userService.getCurrentUser().getEmail());

		return saveSurveyInternal(survey);
	}
	
	private SurveyUser getSurveyUserInternal() throws NotAuthorizedException {
		if (userService.getCurrentUser() == null) {
			throw new NotAuthorizedException();
		}		
		
		SurveyUser user = null;
		PersistenceManager pm = PMF.get().getPersistenceManager(); 
		try {
			Key key = KeyFactory.createKey(SurveyUser.class.getSimpleName(), userService.getCurrentUser().getEmail());
			user = pm.getObjectById(SurveyUser.class, key);
			
//			Query query = pm.newQuery(SurveyUser.class);
//			query.setFilter("email == emailParam");
//			query.declareParameters("String emailParam");
//			List<SurveyUser> results = (List<SurveyUser>) query.execute(userService.getCurrentUser().getEmail());
//			user = results.get(0);
//			
		} catch (Exception e) {
			user = new SurveyUser();
			user.setEmail(userService.getCurrentUser().getEmail());
			//saveSurveyUser(user);						
		} finally {
			pm.close();
		}
		return user;
	}

}
