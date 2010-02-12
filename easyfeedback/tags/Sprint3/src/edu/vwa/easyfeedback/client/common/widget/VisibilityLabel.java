package edu.vwa.easyfeedback.client.common.widget;

import java.util.ArrayList;

import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;

public class VisibilityLabel extends Label implements HasValue<Boolean> {
	private final ArrayList<HandlerRegistration> handlers = new ArrayList<HandlerRegistration>();

	public VisibilityLabel(String text) {
		super(text);
	}

	public Boolean getValue() {
		return isVisible();
	}

	public void setValue(Boolean value) {
		setVisible(value);
	}

	public void setValue(Boolean value, boolean fireEvents) {
		setValue(value);
	}

	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<Boolean> handler) {
		return new HandlerRegistration() {

			public void removeHandler() {
				handlers.remove(this);
			}
			
		};
	}
	
}