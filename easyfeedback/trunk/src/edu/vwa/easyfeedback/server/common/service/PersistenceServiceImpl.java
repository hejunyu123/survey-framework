package edu.vwa.easyfeedback.server.common.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

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

	/**
	 * @see PersistenceService#getSurvey(String)
	 */
	public Survey getSurvey(String name) throws SurveyNotFoundException {
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
			pm.makePersistent(user);
		} finally {
			pm.close();
		}
	}

	/**
	 * @see PersistenceService#saveSurvey(Survey)
	 */
	public void saveSurvey(Survey survey) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(survey);
		} finally {
			pm.close();
		}
	}

	/**
	 * @see PersistenceService#getSurveys()
	 */
	@SuppressWarnings("unchecked")
	public Survey[] getSurveys() throws NotAuthorizedException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
//		UserService userService = UserServiceFactory.getUserService();
		List<Survey> result = new ArrayList<Survey>();
		if (userService.isUserLoggedIn())
		{
//			SurveyUser user = pm.getObjectById(SurveyUser.class, userService.getCurrentUser().getEmail());
			SurveyUser user = getSurveyUserInternal();
			try {
				Query query = pm.newQuery(Survey.class);
				query.setFilter("user == su");
				query.declareParameters("edu.vwa.easyfeedback.client.common.model.SurveyUser su");
				try {
					result = (List<Survey>) query.execute(user);
				} catch (Exception e) {
				}
				//TODO Detach result?
			}
			finally {
				pm.close();
			}
			
		}
		Survey[] test = new Survey[result.size()];
		return (Survey[]) result.toArray(test);
	}

	public void deleteSurvey(Survey survey) {
		// TODO Auto-generated method stub
		
	}

	public Survey createSurvey(String caption, String description) throws NotAuthorizedException {
		if (userService.isUserLoggedIn())
		{
			SurveyUser user = getSurveyUserInternal();
			Survey survey = new Survey();
			survey.setCaption(caption);
			survey.setCreatedAt(new Date());
			survey.setDescription(description);
			survey.setName(UUID.randomUUID().toString());
			survey.setPublishedAt(null);
			survey.setUser(user);
			
			// Create survey in an transaction to make sure it's in in the same EntityGroup as the nested SurveyUser
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Transaction tx = pm.currentTransaction();
			try {
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
		throw new NotAuthorizedException();
	}
	
	private SurveyUser getSurveyUserInternal() throws NotAuthorizedException {
		if (userService.getCurrentUser() == null) {
			throw new NotAuthorizedException();
		}		
		
		SurveyUser user = null;
		PersistenceManager pm = PMF.get().getPersistenceManager(); 
		try {
			user = pm.getObjectById(SurveyUser.class, userService.getCurrentUser().getEmail());
		} catch (Exception e) {
			user = new SurveyUser();
			user.setEmail(userService.getCurrentUser().getEmail());
//			saveSurveyUser(user);						
		} finally {
			pm.close();
		}
		return user;
	}

}
