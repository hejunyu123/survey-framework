package edu.vwa.easyfeedback.client.fillout.widget;

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

}
