package edu.vwa.easyfeedback.common.server.service;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.vwa.easyfeedback.common.client.model.Survey;
import edu.vwa.easyfeedback.common.server.PMF;

public class PersistenceServiceImpl extends RemoteServiceServlet implements edu.vwa.easyfeedback.common.client.service.PersistenceService {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5609326171728515316L;
	
	/**
	 * Manages transactions with the datastore.
	 */
	private static final PersistenceManager pm = PMF.get().getPersistenceManager();

	@SuppressWarnings("unchecked")
	public Survey getSurvey(String name) {
		Query query = pm.newQuery("select from" + Survey.class.getName() +" where name =='"+name+"'");
//		return pm.getObjectById(Survey.class, name);
		List<Survey> results = (List<Survey>)query.execute();
		return results.isEmpty() ? new Survey(name, null, 
				new Date().toString(), new Date().toString()
				) : results.get(0); //TODO debug
	}

	public void saveSurvey(Survey survey) {
		Survey existingSurvey = this.getSurvey(survey.getName());
		if (existingSurvey == null) {
			
		}
		
		pm.makePersistent(survey);
		pm.close();
	}

}
