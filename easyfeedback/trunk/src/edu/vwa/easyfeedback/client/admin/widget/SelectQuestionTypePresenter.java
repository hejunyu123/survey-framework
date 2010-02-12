package edu.vwa.easyfeedback.client.admin.widget;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;

import edu.vwa.easyfeedback.client.common.QuestionPresenterFactory;
import edu.vwa.easyfeedback.client.common.page.BaseSurveyPresenter;
import edu.vwa.easyfeedback.client.common.presenter.EventBus;
import edu.vwa.easyfeedback.client.common.presenter.MyPresenter;
import edu.vwa.easyfeedback.client.common.presenter.WidgetDisplay;
import edu.vwa.easyfeedback.client.fillout.widget.QuestionPresenter;

/**
 * Presents a widget that holds a list of available question types and gives the user a button to add new questions to a survey.
 * @author fleerkoetter
 *
 */
public class SelectQuestionTypePresenter extends MyPresenter<SelectQuestionTypePresenter.Display> {
	
	private BaseSurveyPresenter<?> target = null;

	public SelectQuestionTypePresenter(Display display, EventBus eventBus, final QuestionPresenterFactory factory) {
		super(display, eventBus);
		
		display.setItems(getQuestionTypesList());
		
		display.getBtnAddQuestion().addClickHandler(new ClickHandler(){

			public void onClick(ClickEvent event) {
				if (target != null) {
					QuestionPresenter<?, ?> newQuestion = null;
					
					switch (getDisplay().getSelectedIndex()) {
					case 0:
						newQuestion = factory.createYesNoWidget();
						break;
					case 1:
						newQuestion = factory.createFreeTextQuestionWidget();
						break;
					
					case 2: 
						newQuestion = factory.createMultipleChoiceQuestionWidget();
						break;

					default:
						break;
					}
					if (newQuestion != null) {
						try {
							target.getModel().getElements().add(newQuestion.getModel());
							target.addQuestion(newQuestion);
						} catch (Exception e) {
						}						
					}
				}	
			}
			
		});
	}

	/** 
	 * Tells the presenter where to add new questions when the user clicks on the add question button.
	 * @param target Widget container to which new question widgets will be added
	 */
	public void setTarget(BaseSurveyPresenter<?> target) {
		this.target = target;
	}

	public BaseSurveyPresenter<?> getTarget() {
		return target;
	}

	public interface Display extends WidgetDisplay {
		/** 
		 * Facade for adding items (Strings) to the question type list
		 * @param items A list of strings naming the available question type names
		 */
		public void setItems(List<String> items);
		
		/**
		 * Facade for reading items from the question type list
		 */
		public List<String> getItems();
		
		/**
		 * Facade for the question type list
		 * @return The selected question type list index
		 */
		public int getSelectedIndex();
		
		public HasClickHandlers getBtnAddQuestion();
	}
	
	private List<String> getQuestionTypesList() {
		ArrayList<String> result = new ArrayList<String>();
		result.add("Yes/No question");
		result.add("Free text question");
		result.add("Multiple choice question");
		
		return result;
	}

	@Override
	public String getPlace() {
		return "";
	}

	@Override
	public void onShow() {
				
	}

}
