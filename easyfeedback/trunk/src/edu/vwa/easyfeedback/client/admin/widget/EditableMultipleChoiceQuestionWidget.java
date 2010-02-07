package edu.vwa.easyfeedback.client.admin.widget;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.TextBox;

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
	private TextBox maxOptions;

	public EditableMultipleChoiceQuestionWidget(QuestionPresenterFactory factory) {
		super(factory);
		
		btnAddOption = new Button("Add option");
		btnRemoveOption = new Button("Remove option");
		maxOptions = new TextBox();
		
		maxOptions.addValueChangeHandler(new ValueChangeHandler<String>() {
			
			public void onValueChange(ValueChangeEvent<String> event) {
				boolean isInt = false;
				try {
					Integer.parseInt(event.getValue());
					isInt = true;
				} catch (NumberFormatException e) {
				}
				maxOptions.getElement().getStyle().setBackgroundColor(isInt ? "white" : "red");
			}
		});
		setMaxOptions(1);
		
		root.add(btnAddOption);
		root.add(btnRemoveOption);
		root.add(new InlineLabel("Maximum of valid options: "));
		root.add(maxOptions);
	}

	public HasClickHandlers getBtnAddOption() {
		return btnAddOption;
	}
	
	public HasClickHandlers getBtnRemoveOption() {
		return btnRemoveOption;
	}

	@Override
	protected CheckBox createOptionElem(boolean isExclusive) {
		return new EditableCheckBox();
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

	public HasValueChangeHandlers<?> addOption(String caption, boolean value,
			String name) {
		super.addOption(caption, value, name, false);

		try {
			CheckBox elem = (CheckBox)getElementsContainer().getWidget(getElementsContainer().getWidgetCount()-1);
			return elem;
		} catch (Exception e) {
			return null;
		}

	}

	public int getMaxOptions() {
		try {
			return Integer.valueOf(maxOptions.getText());
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	public void setMaxOptions(int value) {
		maxOptions.setText(String.valueOf(value));		
	}

	public HasChangeHandlers getMaxOptionsChange() {
		return maxOptions;
	}


}
