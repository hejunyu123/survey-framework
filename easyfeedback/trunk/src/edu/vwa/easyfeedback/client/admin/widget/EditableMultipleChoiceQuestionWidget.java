package edu.vwa.easyfeedback.client.admin.widget;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;

import edu.vwa.easyfeedback.client.common.QuestionPresenterFactory;
import edu.vwa.easyfeedback.client.fillout.widget.MultipleChoiceQuestionWidget;

/**
 * A view for {@link EditableMultipleChoiceQuestionPresenter}
 * @author fleerkoetter
 *
 */
public class EditableMultipleChoiceQuestionWidget extends MultipleChoiceQuestionWidget implements EditableMultipleChoiceQuestionPresenter.Display {

	private Button btnAddOption;
	private Button btnRemoveOption;

	public EditableMultipleChoiceQuestionWidget(QuestionPresenterFactory factory) {
		super(factory);
		
		btnAddOption = new Button("Add option");
		btnRemoveOption = new Button("Remove option");
		
		root.add(btnAddOption);
		root.add(btnRemoveOption);
	}

	public HasClickHandlers getBtnAddOption() {
		return btnAddOption;
	}
	
	public HasClickHandlers getBtnRemoveOption() {
		// TODO Auto-generated method stub
		return btnRemoveOption;
	}

	/**
	 * Returns a list of indices of selected multiple choice options in the 
	 * elements container.
	 * You can use all indcies for getElementContainer().getWidget() and cast the result to
	 * CheckBox safely.
	 */
	public List<Integer> getOptionsSelected() {
		List<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < getElementsContainer().getWidgetCount(); i++) {
			try {
				CheckBox elem = (CheckBox)getElementsContainer().getWidget(i);
				if (elem.getValue()) {
					result.add(i);
				}
			} catch (Exception e) {
			}
		}
		
		return result;
	}



}
