package edu.vwa.easyfeedback.admin.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.History;

import edu.vwa.easyfeedback.admin.client.page.SelectSurveyPresenter;

public class EasyFeedbackAdmin implements EntryPoint {

	public void onModuleLoad() {
		SelectSurveyPresenter selectSurvey = AdminModuleFactory.get().createSelectSurveyPage();
		
		// Show Select Survey page at startup
		History.newItem(selectSurvey.getPlace(), true);
	}

}
