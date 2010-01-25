package edu.vwa.easyfeedback.client.fillout.widget;

import java.util.Map;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Widget;

import edu.vwa.easyfeedback.client.common.model.MultipleChoiceOption;
import edu.vwa.easyfeedback.client.common.model.MultipleChoiceQuestion;
import edu.vwa.easyfeedback.client.common.presenter.EventBus;
import edu.vwa.easyfeedback.client.common.presenter.MyPresenter;

public class MultipleChoiceQuestionPresenter
	 extends QuestionPresenter<MultipleChoiceQuestionPresenter.Display, MultipleChoiceQuestion> {
	
	public interface Display extends QuestionPresenter.Display {
	}
	
	private Map<MultipleChoiceOption, Widget> choices;
	
	public MultipleChoiceQuestionPresenter(Display display, EventBus eventBus) {
		super(display, eventBus);
	}
	

	@Override
	public String getPlace() {
		return "";
	}

	/**
	 * Shows and refreshes the display.
	 * @see MyPresenter#onShow()
	 */
	@Override
	public void onShow() {	
		getDisplay().getElementsContainer().clear();
		for (Widget elem :choices.values()) {
			getDisplay().getElementsContainer().add(elem);
		}
	}

	/**
	 * Loads a {@link MultipleChoiceQuestion} and refreshes the display
	 */
	@Override
	public void load(MultipleChoiceQuestion model) {
		super.load(model);
		
		choices.clear();
		for (MultipleChoiceOption option : model.getOptions()) {
			addChoice(option);
		}
		
		onShow();
	}
	
	/**
	 * Add a choice model to the choices
	 * @param choice
	 */
	public void addChoice(MultipleChoiceOption choice) {
		CheckBox elem = new CheckBox(choice.getCaption());
		elem.setValue(choice.getValue());
		choices.put(choice, elem);
	}		
	
}
