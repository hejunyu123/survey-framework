package edu.vwa.easyfeedback.client.common.widget;

import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;

/**
 * Decorator for using a label with numbers and {@link HasValue<Integer>}
 * @author fleerkoetter
 *
 */
public class LabelNumberDecorator implements HasValue<Integer> {
	
	private String valueFormat = "%1";
	private Label target;

	public LabelNumberDecorator(Label target) {
		this.target = target;
	}
	
	public LabelNumberDecorator(Label target, String valueFormat){
		this(target);
		setValueFormat(valueFormat);
	}
	
//	public NumberLabel(int value) {
//		super();	
//		setValue(value);
//	}
	
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
			return Integer.valueOf(getTarget().getText());
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	public void setValue(Integer value) {
		getTarget().setText(valueFormat.replaceAll("%1", value.toString()));
	}

	public void setValue(Integer value, boolean fireEvents) {
		setValue(value);
	}

	public HandlerRegistration addValueChangeHandler(
 	 		ValueChangeHandler<Integer> handler) {
		return new HandlerRegistration() {
			
			public void removeHandler() {
			}
		};
	}

	public void fireEvent(GwtEvent<?> event) {
		getTarget().fireEvent(event);
		
	}

	public Label getTarget() {
		return target;
	}

}
