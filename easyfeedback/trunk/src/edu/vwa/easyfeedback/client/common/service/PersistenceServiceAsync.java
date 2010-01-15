package edu.vwa.easyfeedback.client.common.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.vwa.easyfeedback.client.common.model.Survey;

public interface PersistenceServiceAsync {

	void getSurvey(String name, AsyncCallback<Survey> callback);

	void saveSurvey(Survey survey, AsyncCallback<Void> callback);

}
