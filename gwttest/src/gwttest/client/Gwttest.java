package gwttest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Das ist unsere EntryPoint Klasse.
 */
public class Gwttest implements EntryPoint {
	
	private LoginInfo loginInfo = null;
	private Anchor signInLink = new Anchor("Einloggen");
	private Anchor signOutLink = new Anchor("Ausloggen");
  
	/**
	 * Alles hat einen Anfang ;)
	 */
	public void onModuleLoad() {
		//Login-Informationen holen
		LoginServiceAsync loginService = GWT.create(LoginService.class);
		loginService.login(GWT.getHostPageBaseURL(), new AsyncCallback<LoginInfo>() {
			public void onFailure(Throwable error) {
			}
			
			public void onSuccess(LoginInfo result) {
				loginInfo = result;
				if (loginInfo.isLoggedIn()) {
					loadAdminPage();
				} else {
					loadLoginPage();
				}
			}
		});
	}

	/**
	 * Lädt die GUI der Login-Seite.
	 */
	private void loadLoginPage() {
		//Login Panel rendern
		signInLink.setHref(loginInfo.getLoginUrl());
		RootPanel login = RootPanel.get("login");
		login.add(signInLink);
		
		//Welcome Message rendern
		RootPanel content = RootPanel.get("content");
		content.add(new HTML("<h1>Easy Feedback</h1>"));
		content.add(new InlineHTML("Hallo! Bitte "));
		Anchor signInLink = new Anchor("loggen Sie sich ein");
		signInLink.setHref(loginInfo.getLoginUrl());
		content.add(signInLink);
		content.add(new InlineHTML(", um Umfragen zu erstellen."));
	}
  
	/**
	 * Lädt die GUI der Admin-Seite.
	 */
	private void loadAdminPage() {
		//Login Panel rendern
		signOutLink.setHref(loginInfo.getLogoutUrl());
		RootPanel login = RootPanel.get("login");
		login.add(new InlineLabel(loginInfo.getEmailAddress()));
		login.add(new InlineLabel(" | "));
		login.add(signOutLink);
		
		//Welcome Message rendern
		RootPanel content = RootPanel.get("content");
		content.add(new HTML("<h1>Easy Feedback</h1>"));
		content.add(new InlineHTML("Hallo " + loginInfo.getNickname() + "!"));
	}
}
