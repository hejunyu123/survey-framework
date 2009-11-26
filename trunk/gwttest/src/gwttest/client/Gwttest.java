package gwttest.client;

import net.customware.gwt.presenter.client.DefaultEventBus;
import gwttest.client.samplesurvey.MySampleSurveyPage;
import gwttest.client.samplesurvey.MySampleSurveyPresenter;
import gwttest.client.samplesurvey.gin.MySampleSurveyGinjector;

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
	 * L‰dt die GUI der Login-Seite.
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
	 * L‰dt die GUI der Admin-Seite.
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
		
//		DefaultEventBus eventBus = new DefaultEventBus();
//		MySampleSurveyPage mSSPage = new MySampleSurveyPage();
//		MySampleSurveyPresenter mSSPresenter = new MySampleSurveyPresenter(mSSPage, eventBus);
		// Ginjector erzeugen
		MySampleSurveyGinjector ginjector = GWT.create(MySampleSurveyGinjector.class);
		// MySampleSurvey Presenter von ginjector erzeugen lassen -> Nutzt GIN-Modul
		MySampleSurveyPresenter mSSPresenter = ginjector.getPagePresenter();
		// View initialisieren und an Oberfläche anhängen
		mSSPresenter.bind();
		content.add(mSSPresenter.getDisplay().asWidget());
	}
}
