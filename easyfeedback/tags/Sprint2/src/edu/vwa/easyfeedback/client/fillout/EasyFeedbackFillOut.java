package edu.vwa.easyfeedback.client.fillout;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.History;

import edu.vwa.easyfeedback.client.fillout.page.FillOutSurveyPresenter;

public class EasyFeedbackFillOut implements EntryPoint {

	public void onModuleLoad() {
		FillOutSurveyPresenter showSurvey = FillOutModuleFactory.get().createFillOutSurveyPage();
		History.newItem(showSurvey.getPlace());
	}

}
