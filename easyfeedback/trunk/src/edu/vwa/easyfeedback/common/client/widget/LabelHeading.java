package edu.vwa.easyfeedback.common.client.widget;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Label;


public class LabelHeading extends Label {
	private int number;

	public LabelHeading(int headingNumber) {
		if (headingNumber <= 0) {
			headingNumber = 1;
		}
		number = headingNumber;			
	}
	
	public LabelHeading(int headingNumber, String text) {
		this(headingNumber);
		this.setText(text);
	}
	
	public void setText(String text) {
		DOM.setInnerHTML(this.getElement(), "<h"+number+">"+text+"</h"+number+">");
	}		
	
	public String getText() {
		return DOM.getFirstChild(this.getElement()).getInnerText();
	}
}