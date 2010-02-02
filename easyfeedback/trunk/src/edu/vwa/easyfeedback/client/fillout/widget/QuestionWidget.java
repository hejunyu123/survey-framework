package edu.vwa.easyfeedback.client.fillout.widget;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.vwa.easyfeedback.client.common.presenter.WidgetDisplay;
import edu.vwa.easyfeedback.client.common.widget.LabelHeading;
import edu.vwa.easyfeedback.client.common.widget.NumberLabel;
import edu.vwa.easyfeedback.client.common.widget.VisibilityLabel;

/**
 * Abstract superclass for widgets representing a survey question.
 * 
 * @author fleerkoetter
 *
 */
public class QuestionWidget extends Composite implements QuestionPresenter.Display {
		
	protected Label caption;
	protected Label description;
	private Panel elements;
	protected FlowPanel root;
	private VisibilityLabel isOptional;
	private NumberLabel number;

	/**
	 * Constructs the widget. initWidget musn't be called by 
	 */
	public QuestionWidget() {
		number = new NumberLabel("#%1");
		caption = new LabelHeading(2, "%QuestionWidget.caption%");
		description = new Label("%QuestionWidget.description%");
		elements = new VerticalPanel();
		root = new FlowPanel();
		isOptional = new VisibilityLabel("<i>This question is optional</i>");
		
		String baseStyle = "ef-Survey-Question";
		root.addStyleName(baseStyle);
		
		number.addStyleName(baseStyle + "-Number");
		caption.addStyleName(baseStyle + "-Caption");
		description.addStyleName(baseStyle + "-Description");
		elements.addStyleName(baseStyle + "-Elements");
		
		root.add(number);
		root.add(isOptional);
		root.add(caption);
		root.add(description);
		root.add(elements);
		
		initWidget(root);
		
	}
	
	/**
	 * @see QuestionPresenter.Display#getCaption()
	 */
	public HasText getCaption() {
		return caption;
	}

	/*
	 * (non-Javadoc)
	 * @see edu.vwa.easyfeedback.client.fillout.widget.QuestionPresenter.Display#getDescription()
	 */
	public HasText getDescription() {
		return description;
	}

	/**
	 * @see WidgetDisplay#asWidget()
	 */
	public Widget asWidget() {
		return this;
	}

	/**
	 * @see QuestionPresenter.Display#getElementsContainer()
	 */
	public HasWidgets getElementsContainer() {
		return elements;
	}

	public HasValue<Boolean> getIsOptional() {
		return isOptional;
	}

	public HasValue<Integer> getNumber() {
		return number;
	}

}
