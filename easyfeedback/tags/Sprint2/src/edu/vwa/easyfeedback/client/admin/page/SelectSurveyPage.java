package edu.vwa.easyfeedback.client.admin.page;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.vwa.easyfeedback.client.common.widget.LabelHeading;

public class SelectSurveyPage extends Composite implements SelectSurveyPresenter.Display {
	
	private final static Button btnSubmit = new Button("Load or create survey");
	private final static TextBox tbID = new TextBox();
	private final static Label lblError = new Label("Test");
	private final static VerticalPanel root = new VerticalPanel();

	public SelectSurveyPage() {		
		root.add(new LabelHeading(1, "Please enter survey id:"));
		root.add(tbID);
		root.add(btnSubmit);
		root.add(lblError);
		
		lblError.addStyleName("gwt-Label-Red");
		
		initWidget(root);
	}
	
	public HasClickHandlers getBtnSubmit() {
		return btnSubmit;
	}

	public HasValue<String> getIdBox() {
		return tbID;
	}

	public void showSubmitError(String errorText) {
		lblError.setText(errorText);		
	}

	public Widget asWidget() {
		return (Widget)this;
	}

}
