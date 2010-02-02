package edu.vwa.easyfeedback.client.admin.widget;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;

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
public class LoginPresenter<T extends LoginPresenter.Display> extends MyPresenter<T> {

	public interface Display extends WidgetDisplay {
		HasText getWelcomeMessage();
		HasClickHandlers getBtnLogin();
		HasClickHandlers getBtnLogout();
	}
	
	public LoginPresenter(T loginWidget, EventBus eventBus) {
		super(loginWidget, eventBus);
	}

	@Override
	public String getPlace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onShow() {
		// TODO Auto-generated method stub
		
	}
}
