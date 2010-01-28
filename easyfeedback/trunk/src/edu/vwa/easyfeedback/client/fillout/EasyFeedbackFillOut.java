package edu.vwa.easyfeedback.client.fillout;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;

import edu.vwa.easyfeedback.client.admin.event.ShowSurveyEvent;
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
		
//		History.addValueChangeHandler(new ValueChangeHandler<String>() {
//			
//			public void onValueChange(ValueChangeEvent<String> event) {
//				if ((event.getValue() != null) && (event.getValue().compareTo("sample") == 0)) {
//					Survey sample = new Survey();
//					sample.setCaption("HelloWorld Survey");
//					sample.setDescription("This is just a sample of an survey");
//					
//					// Yes/Np
//					YesNoQuestion yn = new YesNoQuestion();
//					yn.setCaption("Do you like surveys?");
//					yn.setDescription("Just for a matter of interest...");
//					sample.getElements().add(yn);
//					
//					// Single-line free text
//					FreeTextQuestion text = new FreeTextQuestion();
//					text.setCaption("Why so you like them (or not)?");
//					text.setDescription("Feel free to enter whatever you want ;-)");
//					sample.getElements().add(text);
//					
//					// Multiple-line free text
//					FreeTextQuestion multiText = new FreeTextQuestion();
//					multiText.setIsMultiLineText(true);
//					multiText.setCaption("Do you need some more space?");
//					multiText.setDescription("Feel free to enter whatever you want - even more ;-)");
//					sample.getElements().add(multiText);
//					
//					// Multiple choice / exclusive
//					MultipleChoiceQuestion multi = new MultipleChoiceQuestion();
//					multi.setCaption("How many surveys do you take online?");
//					multi.setDescription("In average per month.");
//					multi.setMaxOptions(1);
//					ArrayList<MultipleChoiceOption> multiAnswers = new ArrayList<MultipleChoiceOption>();
//					multiAnswers.add(new MultipleChoiceOption("None"));
//					multiAnswers.add(new MultipleChoiceOption("1-5"));
//					multiAnswers.add(new MultipleChoiceOption("6-10"));
//					multiAnswers.add(new MultipleChoiceOption("More than 10"));
//					multi.setOptions(multiAnswers);
//					sample.getElements().add(multi);
//				}
//			}
//		});
		
		History.newItem("sample");
	}

}
