package edu.vwa.easyfeedback.client.admin.widget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Label;

public class EditableLabel extends Label implements HasEditState {

	private static final String DEFAULTTEXT = "<Click to edit>";
	private boolean isInEditState;
	private Element input;
	
	public EditableLabel() {
		super();
		
		input = DOM.createInputText();
		addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				setInEditState(!getInEditState());				
			}
		});
	}

	public EditableLabel(String text) {
		this();
		setText(text);
	}

	public boolean getInEditState() {
		return isInEditState;
	}

	public void setInEditState(boolean value) {
		if (value) {
			if (!this.isInEditState) enableEdit();
		} else {
			if (this.isInEditState) disableEdit();
		}
	}
	
	private void enableEdit() {
		try {
			input.setNodeValue(getText());
			getElement().getParentNode().appendChild(input);
//			getElement().insertAfter(input, getElement().getFirstChild());
			isInEditState = true;
		} catch (Exception e) {
			com.google.gwt.user.client.Window.alert(e.getMessage());
		}
		
	}
	
	@Override
	public String getText() {
		String txt = super.getText();
		if (txt.equals(DEFAULTTEXT)) txt = "";
		return txt;
	}

	private void disableEdit() {
		String newTxt = DOM.getInnerText(input);	
		setText(newTxt == null ? "" : newTxt);
		input.removeFromParent();
		isInEditState = false;
	}

	@Override
	public void setText(String text) {
		if (text.trim().length() == 0) {
			text = DEFAULTTEXT;
		}
		super.setText(text);
	}
}
