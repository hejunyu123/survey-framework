package edu.vwa.easyfeedback.client.admin.widget;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;

import edu.vwa.easyfeedback.client.common.QuestionPresenterFactory;
import edu.vwa.easyfeedback.client.fillout.widget.MultipleChoiceQuestionWidget;

public class EditableMultipleChoiceQuestionWidget extends MultipleChoiceQuestionWidget implements EditableMultipleChoiceQuestionPresenter.Display {

	private Button btnAddOption;

	public EditableMultipleChoiceQuestionWidget(QuestionPresenterFactory factory) {
		super(factory);
		
		btnAddOption = new Button("Add option");
		root.add(btnAddOption);
	}

	public HasClickHandlers getBtnAddOption() {
		return btnAddOption;
	}

	public int getMaxOptions() {
		// TODO Auto-generated method stub
		return 0;
	}



}
