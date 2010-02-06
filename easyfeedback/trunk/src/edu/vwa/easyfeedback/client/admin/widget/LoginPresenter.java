package edu.vwa.easyfeedback.client.admin.widget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasText;

import edu.vwa.easyfeedback.client.admin.AdminModuleFactory;
import edu.vwa.easyfeedback.client.admin.service.LoginInfo;
import edu.vwa.easyfeedback.client.admin.service.LoginServiceAsync;
import edu.vwa.easyfeedback.client.common.presenter.EventBus;
import edu.vwa.easyfeedback.client.common.presenter.MyPresenter;
import edu.vwa.easyfeedback.client.common.presenter.WidgetDisplay;

/**
 * Presents  a LoginWidget
 * @author Pesco
 * @param <T>
 *
 * @param <T> The correspondant display interface.
 */
public class LoginPresenter extends MyPresenter<LoginPresenter.Display> {
	
	public interface Display extends WidgetDisplay {
		HasText getWelcomeMessage();
		HasClickHandlers getBtnLogin();
		HasClickHandlers getBtnLogout();
		void setLoginVisible(boolean visible);
		void setLogoutVisible(boolean visible);
	}
	
	public LoginPresenter(LoginPresenter.Display display, EventBus eventBus) {
		super(display, eventBus);
	}

	public String getPlace() {
		// TODO Auto-generated method stub
		return null;
	}

	public void onShow() {
		final LoginServiceAsync loginService = AdminModuleFactory.get().getLoginService();
		getDisplay().setLoginVisible(false);
		getDisplay().setLogoutVisible(false);
		getDisplay().getWelcomeMessage().setText("");
		loginService.login("/admin.html", new AsyncCallback<LoginInfo>() {
			public void onFailure(Throwable caught) {
				
			}
			public void onSuccess(final LoginInfo result) {
				if (!result.isLoggedIn())
				{
					getDisplay().getWelcomeMessage().setText("");
					getDisplay().getBtnLogin().addClickHandler(new ClickHandler(){
						public void onClick(ClickEvent event) {
							Window.open(result.getLoginUrl(), "_self", "");
						}
					});
					getDisplay().setLoginVisible(true);
				}
				else
				{
					getDisplay().getWelcomeMessage().setText("Hello " + result.getNickname() + "!");
					getDisplay().getBtnLogout().addClickHandler(new ClickHandler(){
						public void onClick(ClickEvent event) {
							Window.open(result.getLogoutUrl(), "_self", "");
						}
					});
					getDisplay().setLogoutVisible(true);
				}
			}
		});
	}
}
