package edu.vwa.easyfeedback.fillout.client.widget;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.vwa.easyfeedback.common.client.widget.LabelHeading;

public class QuestionWidget extends Composite implements QuestionPresenter.Display {
	
	private Label caption;
	private Label description;
	private Panel elements;
	private Panel root;


	protected void construct() {
		caption = new LabelHeading(2, "%QuestionWidget.caption%");
		description = new Label("%QuestionWidget.description%");
		elements = new VerticalPanel();
		root = new VerticalPanel();
		
		root.addStyleName("ef-Survey-Question");
		
		root.add(caption);
		root.add(description);
		root.add(elements);
		
		initWidget(root);
	}

	public HasText getCaption() {
		return caption;
	}

	public HasText getDescription() {
		return description;
	}

	public Widget asWidget() {
		return this;
	}

	public HasWidgets getElementsContainer() {
		return elements;
	}

}
