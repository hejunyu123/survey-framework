package edu.vwa.easyfeedback.server.common.service;

import javax.jdo.PersistenceManager;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.vwa.easyfeedback.client.common.model.Survey;
import edu.vwa.easyfeedback.client.common.model.SurveyUser;
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

}
