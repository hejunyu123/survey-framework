package edu.vwa.easyfeedback.client.fillout.page;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IndexedPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.vwa.easyfeedback.client.common.widget.LabelHeading;

/**
 * This is a sample of how the view of a survey could look like.
 * For the final product, this needs to be seperated into a "Edit survey" and a "Take survey" view.
 * @author fleerkoetter
 *
 */
public class FillOutSurveyPage extends Composite implements FillOutSurveyPresenter.Display {

	private Panel root;
	private Label caption;
	private Label description;
	private Button btnMakePersistent;
	private VerticalPanel questions;
	
	/**
	 * Constructs the page
	 */
	public FillOutSurveyPage() {
		// Construct page
		root = new VerticalPanel();
		caption = new LabelHeading(1);
		description = new LabelHeading(2);
		btnMakePersistent = new Button("Save");
		questions = new VerticalPanel();
		
		root.add(caption);
		root.add(description);
		root.add(btnMakePersistent);
		root.add(questions);
		
		// Must be called
		initWidget(root);
	}
	
	public Widget asWidget() {
		return this;
	}

//	public void startProcessing() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void stopProcessing() {
//		// TODO Auto-generated method stub
//		
//	}

	public HasText getCaption() {
		return (HasText) caption;
	}

	public HasText getDescription() {
		return (HasText) description;
	}

	public HasClickHandlers getBtnMakePersistent() {
		return btnMakePersistent;
	}

	public HasWidgets getQuestions() {
		return questions;
	}

	public IndexedPanel getQuestionOrder() {
		return questions;
	}
	
	
}
