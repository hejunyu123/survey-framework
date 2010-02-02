package edu.vwa.easyfeedback.client.fillout;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;

import edu.vwa.easyfeedback.client.admin.event.ShowSurveyEvent;
import edu.vwa.easyfeedback.client.fillout.page.FillOutSurveyPresenter;

public class EasyFeedbackFillOut implements EntryPoint {
	
//	private HandlerManager pageCollection = new HandlerManager(null);

	public void onModuleLoad() {
		final FillOutSurveyPresenter showSurvey = FillOutModuleFactory.get().createFillOutSurveyPage();
		FillOutModuleFactory.get().getEventBus().addHandler(ShowSurveyEvent.TYPE, showSurvey);
		
		// Load the fillout page with the PagePresenter listener function 
//		pageCollection.addHandler(ValueChangeEvent.getType(), showSurvey);
//		pageCollection.fireEvent(new ValueChangeEvent<String>(showSurvey.getPlace()) {
//		});
//		showSurvey.onShow();
		
		// Fire a ShowSurveyEvent for all history changes to use the history tag to show specific surveys by ID
		History.addValueChangeHandler(new ValueChangeHandler<String>() {
			
			public void onValueChange(ValueChangeEvent<String> event) {
				if (event.getValue() != null) {
					FillOutModuleFactory.get().getEventBus().fireEvent(new ShowSurveyEvent(event.getValue()));
				}
			}
		});
		
		History.newItem("sample");
	}

}
