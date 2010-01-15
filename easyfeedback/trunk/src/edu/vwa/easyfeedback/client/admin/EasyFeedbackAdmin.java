package edu.vwa.easyfeedback.client.admin;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.History;

import edu.vwa.easyfeedback.client.admin.page.SelectSurveyPresenter;

public class EasyFeedbackAdmin implements EntryPoint {

	public void onModuleLoad() {
		SelectSurveyPresenter selectSurvey = AdminModuleFactory.get().createSelectSurveyPage();
		
		// Show Select Survey page at startup
		History.newItem(selectSurvey.getPlace(), true);
	}

}
