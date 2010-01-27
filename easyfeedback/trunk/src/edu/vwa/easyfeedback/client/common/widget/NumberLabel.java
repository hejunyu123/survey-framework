package edu.vwa.easyfeedback.client.common.widget;

import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;

/**
 * A label that contains numbers and can be used with HasValue<Integer>
 * @author fleerkoetter
 *
 */
public class NumberLabel extends Label implements HasValue<Integer> {
	
	private String valueFormat = "%1";

	public NumberLabel() {
		this(-1);
	}
	
	public NumberLabel(String valueFormat){
		this();
		setValueFormat(valueFormat);
	}
	
	public NumberLabel(int value) {
		super();	
		setValue(value);
	}
	
	/**
	 * Set a pseudo-format string that is used to convert the Label's value to text.
	 * Any occurence of "%d" in the format string will be replaced by the actual value.
	 * @param valueFormat The format string
	 */
	public void setValueFormat(String valueFormat) {
		this.valueFormat = valueFormat;
	}	

	public Integer getValue() {
		try {
			return Integer.valueOf(getText());
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	public void setValue(Integer value) {
		setText(valueFormat.replaceAll("%1", value.toString()));
	}

	public void setValue(Integer value, boolean fireEvents) {
		setValue(value);
	}

	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<Integer> handler) {
		// TODO Auto-generated method stub
		return null;
	}

}
