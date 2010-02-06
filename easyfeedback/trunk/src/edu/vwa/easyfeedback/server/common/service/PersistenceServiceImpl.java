package edu.vwa.easyfeedback.server.common.service;

import java.util.Date;
import java.util.UUID;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.vwa.easyfeedback.client.common.model.Survey;
import edu.vwa.easyfeedback.client.common.model.SurveyUser;
import edu.vwa.easyfeedback.client.common.service.NotAuthorizedException;
import edu.vwa.easyfeedback.client.common.service.PersistenceService;
import edu.vwa.easyfeedback.server.common.PMF;

public class PersistenceServiceImpl extends RemoteServiceServlet implements PersistenceService {
	

	private static final long serialVersionUID = -5609326171728515316L;

	public Survey getSurvey(String name) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Survey result = pm.getObjectById(Survey.class, name);
		pm.close();
		return result;
	}
	
	public SurveyUser getSurveyUser(String name) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		SurveyUser result = pm.getObjectById(SurveyUser.class, name);
		pm.close();
		return result;
	}

	public void saveSurveyUser(SurveyUser user) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		pm.makePersistent(user);
		pm.close();
	}

	public void saveSurvey(Survey survey) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		pm.makePersistent(survey);
		pm.close();
	}

	public Iterable<Survey> getSurveys() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		UserService userService = UserServiceFactory.getUserService();
		if (userService.isUserLoggedIn())
		{
			SurveyUser user = pm.getObjectById(SurveyUser.class, userService.getCurrentUser().getUserId());
			Iterable<Survey> result = null;
			try {
				Query query = pm.newQuery(Survey.class, "user == su");
				query.declareParameters("edu.vwa.easyfeedback.client.common.model.SurveyUser su");
				result = (Iterable<Survey>) query.execute(user);
			}
			finally {
				pm.close();
			}
			return result;
		}
		return null;
	}

	public void deleteSurvey(Survey survey) {
		// TODO Auto-generated method stub
		
	}

	public Survey createSurvey(String caption, String description) throws NotAuthorizedException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		UserService userService = UserServiceFactory.getUserService();
		if (userService.isUserLoggedIn())
		{
			SurveyUser user = pm.getObjectById(SurveyUser.class, userService.getCurrentUser().getUserId());
			Survey survey = new Survey();
			survey.setCaption(caption);
			survey.setCreatedAt(new Date());
			survey.setDescription(description);
			survey.setName(UUID.randomUUID().toString());
			survey.setPublishedAt(null);
			survey.setUser(user);
			pm.makePersistent(survey);
			return survey;
		}
		throw new NotAuthorizedException();
	}

}
