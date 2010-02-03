package edu.vwa.easyfeedback.client.admin.widget;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

/**
 * A label that changes to a textbox when clicked so the user can edit it's text.
 * 
 * <h3>CSS Style Rules</h3>
 * <ul class='css'>
 * <li>.ef-EditableLabel { }</li>
 * <li>.ef-EditableLabel-hover { }</li> 
 * </ul>
 * @author fleerkoetter
 *
 */
public class EditableLabel extends Label implements HasEditState {

	private static final String DEFAULTTEXT = "<Click to edit>";
	private boolean isInEditState;
	private TextBox input;
	private InsertPanel parent = null;

	public EditableLabel() {
		super();
		addStyleName("ef-EditableLabel");
		
		input = new TextBox();
		
		addMouseOverHandler(new MouseOverHandler() {
			
			public void onMouseOver(MouseOverEvent event) {
				addStyleName("ef-EditableLabel-hover");				
			}
		});
		addMouseOutHandler(new MouseOutHandler() {
			
			public void onMouseOut(MouseOutEvent event) {
				removeStyleName("ef-EditableLabel-hover");
				
			}
		});
		addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				switchEditState();			
			}
		});

		input.addBlurHandler(new BlurHandler() {

			public void onBlur(BlurEvent event) {
				switchEditState();
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
	
	/**
	 * Set or unset the widget in editing state.
	 */
	public void switchEditState() {
		setInEditState(!getInEditState());	
	}
	
	/**
	 * Set or unset the widget in editing state.
	 * @param value If true, editing is enabled and a textbox is shown
	 */
	public void setInEditState(boolean value) {
		if (value) {
			if (!this.isInEditState) enableEdit();
		} else {
			if (this.isInEditState) disableEdit();
		}
	}

	private void enableEdit() {
		try {
			parent = (InsertPanel)getParent();
			
			input.setText(getText());
			input.setWidth("300px");
			
			parent.insert(input, parent.getWidgetIndex(this));
			this.removeFromParent();
			
			isInEditState = true;
		} catch (Exception e) {
			com.google.gwt.user.client.Window.alert(e.getMessage());
		}

	}
	
	private void disableEdit() {
		try {
			setText(input.getText());
			parent.insert(this,parent.getWidgetIndex(input));
			input.removeFromParent();
			isInEditState = false;			
		} 
		finally {

		}	

	}
	
	@Override
	public String getText() {
		String txt = super.getText();
		if (txt.equals(DEFAULTTEXT)) txt = "";
		return txt;
	}


	@Override
	public void setText(String text) {
		if (text.trim().length() == 0) {
			text = DEFAULTTEXT;
		}
		super.setText(text);
	}
}
