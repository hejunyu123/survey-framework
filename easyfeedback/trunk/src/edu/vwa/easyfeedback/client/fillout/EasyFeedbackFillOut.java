package edu.vwa.easyfeedback.client.fillout;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;

import edu.vwa.easyfeedback.client.admin.event.ShowSurveyEvent;
import edu.vwa.easyfeedback.client.common.model.FreeTextQuestion;
import edu.vwa.easyfeedback.client.common.model.Survey;
import edu.vwa.easyfeedback.client.common.model.YesNoQuestion;
import edu.vwa.easyfeedback.client.fillout.page.FillOutSurveyPresenter;

public class EasyFeedbackFillOut implements EntryPoint {
	
	private HandlerManager pageCollection = new HandlerManager(null);

	public void onModuleLoad() {
		final FillOutSurveyPresenter showSurvey = FillOutModuleFactory.get().createFillOutSurveyPage();
		
		// Load the fillout page with the PagePresenter listener function 
		pageCollection.addHandler(ValueChangeEvent.getType(), showSurvey);
		pageCollection.fireEvent(new ValueChangeEvent<String>(showSurvey.getPlace()) {
		});
		
		// Fire a ShowSurveyEvent for all history changes to use the history tag to show specific surveys by ID
		History.addValueChangeHandler(new ValueChangeHandler<String>() {
			
			public void onValueChange(ValueChangeEvent<String> event) {
				if (event.getValue() != null) {
					FillOutModuleFactory.get().getEventBus().fireEvent(new ShowSurveyEvent(event.getValue()));
				}
			}
		});
		
		History.addValueChangeHandler(new ValueChangeHandler<String>() {
			
			public void onValueChange(ValueChangeEvent<String> event) {
				if ((event.getValue() != null) && (event.getValue().compareTo("sample") == 0)) {
					Survey sample = new Survey();
					sample.setCaption("HelloWorld Survey");
					sample.setDescription("This is just a sample of an survey");
					
					YesNoQuestion yn = new YesNoQuestion();
					yn.setCaption("Do you like surveys?");
					yn.setDescription("Just for a matter of interest...");
					sample.getElements().add(yn);
					
					FreeTextQuestion text = new FreeTextQuestion();
					text.setCaption("2. Why so you like them");
					text.setDescription("Feel free to enter whatever you want ;-)");
					sample.getElements().add(text);
					
					showSurvey.load(sample);
				}
			}
		});
		
		History.newItem("sample");
	}

}
