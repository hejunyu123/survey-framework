package gwttest.client.samplesurvey;

import gwttest.client.samplesurvey.widget.LabelHeading;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class MySampleSurveyPage extends Composite implements MySampleSurveyPresenter.Display {

	private static Panel root;
	private static Label caption;
	private static Label description;
	private static Button btnMakePersistent;
	
	/**
	 * Constructs the page
	 */
	public MySampleSurveyPage() {
		// Construct page
		root = new VerticalPanel();
		caption = new LabelHeading(1);
		description = new LabelHeading(2);
		btnMakePersistent = new Button("Save");
		root.add(caption);
		root.add(description);
		root.add(btnMakePersistent);
		
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
	
	
}
