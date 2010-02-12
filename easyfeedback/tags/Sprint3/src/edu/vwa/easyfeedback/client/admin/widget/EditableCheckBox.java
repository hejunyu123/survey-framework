package edu.vwa.easyfeedback.client.admin.widget;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.TextBox;

/**
 * A CheckBox that shows a TextBox in order to having it's caption edited.
 * @author fleerkoetter
 *
 */
public class EditableCheckBox extends CheckBox {

	private TextBox input = new TextBox();
	
	public EditableCheckBox() {
		super();
		
		input.addValueChangeHandler(new ValueChangeHandler<String>() {
			
			public void onValueChange(ValueChangeEvent<String> event) {
				ValueChangeEvent<Boolean> ev = new ValueChangeEvent<Boolean>(getValue()) {};
				fireEvent(ev);
			}
		});
		
		Event.setEventListener(input.getElement(), new EventListener() {
			
			public void onBrowserEvent(Event event) {
				if (event.getTypeInt() == Event.ONCHANGE) {
					ValueChangeEvent<Boolean> ev = new ValueChangeEvent<Boolean>(getValue()) {};
					fireEvent(ev);
				}
				
			}
		});
		Event.sinkEvents(input.getElement(), Event.ONCHANGE);
	}

	@Override
	protected void onAttach() {
		super.onAttach();
		
		input.addValueChangeHandler(new ValueChangeHandler<String>() {
			
			public void onValueChange(ValueChangeEvent<String> event) {
				Window.alert(event.getValue());
				
			}
		});
		
//		HasWidgets parent = (HasWidgets)getParent();
//		parent.add(input);
		getElement().appendChild(input.getElement());		
		
		
//		input.getElement().getStyle().setProperty("position", "absolute");
//		input.getElement().getStyle().setProperty("left", 
//				String.valueOf(this.getAbsoluteLeft() + 20));
//		input.getElement().getStyle().setProperty("top", 
//				String.valueOf(this.getAbsoluteTop()));
		
		this.setHeight(input.getElement().getStyle().getHeight()+5);
	}

	@Override
	protected void onDetach() {
		super.onDetach();
		input.removeFromParent();		
	}

	@Override
	public String getText() {
		return input.getText();
	}

	@Override
	public void setText(String text) {
		input.setText(text);
	}

	
}
