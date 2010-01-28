package edu.vwa.easyfeedback.admin.client.widget;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

import edu.vwa.easyfeedback.client.common.widget.LabelHeading;

/**
 * Displays the login Widget
 * @author Pesco
 *
 */
public class LoginWidget extends Composite implements LoginPresenter.Display {
	
	private Label caption;
	private Panel elements;
	private Panel root;
	private Button Login;
	private Button Logout;
	
	public LoginWidget() {
		caption = new LabelHeading(2, "%LoginWidget.caption%");
		elements = new HorizontalPanel();
		root = new HorizontalPanel();		
		
		String baseStyle = "ef-Survey-Login";
		root.addStyleName(baseStyle);
		caption.addStyleName(baseStyle + "-Caption");
		elements.addStyleName(baseStyle + "-Elements");
		
		root.add(caption);
		root.add(elements);
		
		initWidget(root);
		
		Login = new Button("Login");
		Logout = new Button("Logout");
		
		root.add(Login);
		root.add(Logout);
	}
	
	protected void construct() {

	}
	
	public HasText getWelcomeMessage() {
		return caption;
	}
	
	public HasClickHandlers getBtnLogin() {
		//Bei Klick Weiterleitung zur LoginUrl
		return Login;
	}	
	
	public HasClickHandlers getBtnLogout() {
		//Bei Klick Weiterleitung zur LogoutUrl
		return Logout;
	}

	public Widget asWidget() {
		return this;
	}

	public HasWidgets getElementsContainer() {
		return elements;
	}

}
