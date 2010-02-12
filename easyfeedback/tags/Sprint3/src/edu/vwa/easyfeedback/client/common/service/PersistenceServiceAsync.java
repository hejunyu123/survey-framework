package edu.vwa.easyfeedback.client.common.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.vwa.easyfeedback.client.common.model.Survey;
import edu.vwa.easyfeedback.client.common.model.SurveyUser;

/**
 * Async interface for {@link PersistenceService}
 * @author fleerkoetter
 *
 */
public interface PersistenceServiceAsync {

	void getSurvey(String name, AsyncCallback<Survey> callback);

	void getSurveys(AsyncCallback<Survey[]> asyncCallback);
	
	void saveSurvey(Survey survey, AsyncCallback<Void> callback);
	
	void deleteSurvey(Survey survey, AsyncCallback<Void> callback);

	void createSurvey(String caption, String description, AsyncCallback<Survey> callback);

	void getSurveyUser(String email, AsyncCallback<SurveyUser> callback);

	void saveSurveyUser(SurveyUser user, AsyncCallback<Void> callback);
	
}
