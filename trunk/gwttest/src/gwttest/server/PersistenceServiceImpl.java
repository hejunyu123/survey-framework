package gwttest.server;

import gwttest.client.samplesurvey.model.Survey;
import gwttest.client.samplesurvey.service.PersistenceService;

import javax.jdo.PersistenceManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class PersistenceServiceImpl extends RemoteServiceServlet implements PersistenceService {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5609326171728515316L;
	
	/**
	 * Manages transactions with the datastore.
	 */
	private static final PersistenceManager pm = PMF.get().getPersistenceManager();

	public Survey getSurvey(String name) {
		return pm.getObjectById(Survey.class, name);
	}

	public void saveSurvey(Survey survey) {
		pm.makePersistent(survey);
		pm.close();
	}

}
