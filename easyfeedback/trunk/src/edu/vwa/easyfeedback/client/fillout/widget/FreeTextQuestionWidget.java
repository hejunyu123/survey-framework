package edu.vwa.easyfeedback.client.fillout.widget;

import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.Widget;

public class FreeTextQuestionWidget extends QuestionWidget implements FreeTextQuestionPresenter.Display {

	private TextBoxBase text = new TextBox();
	private boolean isMultiLine = false;
	
	public FreeTextQuestionWidget() {
		super();
		getElementsContainer().add(text);
	}
	
	public HasText getText() {
		return text;
	}

	public boolean isMultiLine() {
		return isMultiLine;
	}

	public void setMultiLine(boolean value) {
		if (value != isMultiLine()) {
			if (value) {
				String currText = text.getText();
				text = new TextArea();
				text.setText(currText);
			} else {
				String currText = text.getText();
				text = new TextBox();
				text.setText(currText);				
			}
			
		}

	}

	public Widget asWidget() {
		return this;
	}

}
