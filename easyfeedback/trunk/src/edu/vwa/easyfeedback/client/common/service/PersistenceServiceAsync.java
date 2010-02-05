package edu.vwa.easyfeedback.client.common.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.vwa.easyfeedback.client.common.model.Survey;
import edu.vwa.easyfeedback.client.common.model.SurveyUser;

public interface PersistenceServiceAsync {

	void getSurvey(String name, AsyncCallback<Survey> callback);

	void getSurveysByUser(SurveyUser user, AsyncCallback<Iterable<Survey>> callback);
	
	void saveSurvey(Survey survey, AsyncCallback<Void> callback);
	
	void deleteSurvey(Survey survey, AsyncCallback<Void> callback);

}
