package gwttest.client.samplesurvey.event;

import com.google.gwt.event.shared.EventHandler;


public interface ShowSurveyHandler extends EventHandler {
	void onShowSurvey(String surveyID);
}
