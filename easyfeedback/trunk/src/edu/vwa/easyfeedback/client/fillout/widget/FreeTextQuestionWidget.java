package edu.vwa.easyfeedback.client.fillout.widget;

import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.Widget;

import edu.vwa.easyfeedback.client.common.QuestionPresenterFactory;

/**
 * View widget for displaying questions where the user can enter a text freely.
 * The caller can choose whether the widget should show a one-line {@code <input type="text">} or a
 * multi-line {@code <textarea>}.
 * 
 * @author fleerkoetter
 *
 */
public class FreeTextQuestionWidget extends QuestionWidget implements FreeTextQuestionPresenter.Display {

	private TextBoxBase text;
	private boolean isMultiLine;
	
	public FreeTextQuestionWidget(QuestionPresenterFactory factory) {
		super(factory);
		text = createText(false, "");
		getElementsContainer().add(text);
		isMultiLine = false;
	}
	
	public HasText getText() {
		return text;
	}

	public boolean isMultiLine() {
		return isMultiLine;
	}

	/**
	 * Determines the style of the text box.
	 * @param value If set to true, the widget shows a multi-row input field. If not, it show a single-row input field.
	 */
	public void setMultiLine(boolean value) {	
		if (value != isMultiLine()) {
			getElementsContainer().clear();
			text = createText(value, text.getText());
			getElementsContainer().add(text);			
		}

	}
	
	private TextBoxBase createText(boolean isMultiline, String text) {
		TextBoxBase result;
		if (isMultiline) {
			result = new TextArea();
			result.getElement().setAttribute("rows", "7");
			result.getElement().setAttribute("cols", "40");					

		} else {
			result = new TextBox();		
		}
		result.setText(text);
		this.isMultiLine = isMultiline;
		return result;		
	}

	public Widget asWidget() {
		return this;
	}

}
