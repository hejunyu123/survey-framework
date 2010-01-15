package edu.vwa.easyfeedback.client.fillout.widget;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.vwa.easyfeedback.client.common.widget.LabelHeading;

public class QuestionWidget extends Composite implements QuestionPresenter.Display {
	
	private Label caption;
	private Label description;
	private Panel elements;
	private Panel root;

	public QuestionWidget() {
		caption = new LabelHeading(2, "%QuestionWidget.caption%");
		description = new Label("%QuestionWidget.description%");
		elements = new VerticalPanel();
		root = new VerticalPanel();
		
		String baseStyle = "ef-Survey-Question";
		root.addStyleName(baseStyle);
		caption.addStyleName(baseStyle + "-Caption");
		description.addStyleName(baseStyle + "-Description");
		elements.addStyleName(baseStyle + "-Elements");
		
		root.add(caption);
		root.add(description);
		root.add(elements);
		
		initWidget(root);
	}

	protected void construct() {

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
