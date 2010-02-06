package edu.vwa.easyfeedback.client.admin.page;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.vwa.easyfeedback.client.admin.AdminModuleFactory;
import edu.vwa.easyfeedback.client.admin.widget.LoginPresenter;
import edu.vwa.easyfeedback.client.common.widget.LabelHeading;

public class SelectSurveyPage extends Composite implements SelectSurveyPresenter.Display {
	
	private final Button btnSubmit = new Button("Load or create survey");
	private final TextBox tbID = new TextBox();
	private final Label lblError = new Label("Test");
	private final VerticalPanel root = new VerticalPanel();
	private final VerticalPanel surveys = new VerticalPanel();

	public SelectSurveyPage() {
		LoginPresenter login = AdminModuleFactory.get().createLoginWidget();
		root.add(login.getDisplay().asWidget());
		root.add(new LabelHeading(1, "Please enter survey id:"));
		root.add(tbID);
		root.add(btnSubmit);
		root.add(lblError);
		root.add(surveys);
		
		lblError.addStyleName("gwt-Label-Red");
		
		initWidget(root);
		login.onShow();
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
	
	public HasWidgets getSurveyOptions() {
		return surveys;
	}

}
