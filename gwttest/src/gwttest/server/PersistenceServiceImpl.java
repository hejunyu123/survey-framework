package gwttest.server;

import gwttest.client.samplesurvey.helper.PMF;
import gwttest.client.samplesurvey.model.Survey;
import gwttest.client.samplesurvey.service.PersistenceService;

import javax.jdo.PersistenceManager;

public class PersistenceServiceImpl implements PersistenceService {
	
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
