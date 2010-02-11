package edu.vwa.easyfeedback.client.admin;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;

import edu.vwa.easyfeedback.client.admin.event.ShowSurveyEvent;
import edu.vwa.easyfeedback.client.admin.page.EditSurveyPresenter;
import edu.vwa.easyfeedback.client.admin.page.SelectSurveyPresenter;
import edu.vwa.easyfeedback.client.common.event.ShowPageEvent;
import edu.vwa.easyfeedback.client.fillout.FillOutModuleFactory;

public class EasyFeedbackAdmin implements EntryPoint {

	public void onModuleLoad() {
		SelectSurveyPresenter selectSurvey = AdminModuleFactory.get().createSelectSurveyPage();
//		AdminModuleFactory.get().getEventBus().addHandler(ShowPageEvent.TYPE, selectSurvey);
		
		EditSurveyPresenter editSurvey = AdminModuleFactory.get().createEditSurveyPage();
//		AdminModuleFactory.get().getEventBus().addHandler(ShowSurveyEvent.TYPE, editSurvey);
		
		// Fire a ShowSurveyEvent for all history changes to use the history tag to show specific surveys by ID
//		History.addValueChangeHandler(new ValueChangeHandler<String>() {
//			
//			public void onValueChange(ValueChangeEvent<String> event) {
//				if (event.getValue() != null) {
//					FillOutModuleFactory.get().getEventBus().fireEvent(new ShowSurveyEvent(event.getValue()));
//				}
//			}
//		});
//		
		// Show Select Survey page at startup
		AdminModuleFactory.get().getEventBus().fireEvent(new ShowPageEvent(selectSurvey.getPlace()));
		
//		History.fireCurrentHistoryState();
	}

}
