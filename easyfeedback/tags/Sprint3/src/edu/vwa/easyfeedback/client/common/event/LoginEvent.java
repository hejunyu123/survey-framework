package edu.vwa.easyfeedback.client.common.event;

import com.google.gwt.event.shared.GwtEvent;

import edu.vwa.easyfeedback.client.admin.service.LoginInfo;

/**
 * 
 * @author julian
 *
 */
public class LoginEvent extends GwtEvent<LoginHandler> {
	
	public static Type<LoginHandler> TYPE = new Type<LoginHandler>();

	private LoginInfo loginInfo = null;

	public LoginEvent(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}
	
	/**
	 * 
	 */
	@Override
	protected void dispatch(LoginHandler handler) {
		handler.onLoginStatusChanged(loginInfo);
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<LoginHandler> getAssociatedType() {
		return TYPE;
	}

}
