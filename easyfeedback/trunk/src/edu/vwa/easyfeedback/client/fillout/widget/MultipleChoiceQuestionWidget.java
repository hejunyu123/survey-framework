package edu.vwa.easyfeedback.client.fillout.widget;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.RadioButton;

import edu.vwa.easyfeedback.client.common.QuestionPresenterFactory;

/**
 * Widget presenting a multiple choice question.
 * Currently, this has only marking purpose.
 * @author fleerkoetter
 *
 */
public class MultipleChoiceQuestionWidget extends QuestionWidget implements MultipleChoiceQuestionPresenter.Display {

	public MultipleChoiceQuestionWidget(QuestionPresenterFactory factory) {
		super(factory);
	}

	/** 
	 * Adds an option.
	 */
	public void addOption(String caption, boolean value, String name, boolean isExclusive) {
		CheckBox elem; 
		if (isExclusive) {
			elem = new RadioButton(name); 
		} else {
			elem = new CheckBox();
			elem.setName(caption);
		}
		elem.setText(caption);
		elem.setValue(value);
		getElementsContainer().add(elem);		
	}

}
