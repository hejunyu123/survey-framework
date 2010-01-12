package edu.vwa.easyfeedback.common.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.vwa.easyfeedback.common.client.model.Survey;

public interface PersistenceServiceAsync {

	void getSurvey(String name, AsyncCallback<Survey> callback);

	void saveSurvey(Survey survey, AsyncCallback<Void> callback);

}
