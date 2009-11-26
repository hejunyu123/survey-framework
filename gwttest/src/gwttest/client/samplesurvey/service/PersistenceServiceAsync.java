package gwttest.client.samplesurvey.service;

import gwttest.client.samplesurvey.model.Survey;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PersistenceServiceAsync {

	void getSurvey(String name, AsyncCallback<Survey> callback);

	void saveSurvey(Survey survey, AsyncCallback<Void> callback);

}
