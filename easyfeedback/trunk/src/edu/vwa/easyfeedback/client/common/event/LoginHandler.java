package edu.vwa.easyfeedback.client.common.event;

import com.google.gwt.event.shared.EventHandler;

import edu.vwa.easyfeedback.client.admin.service.LoginInfo;

public interface LoginHandler extends EventHandler {
	public void onLoginStatusChanged(LoginInfo loginInfo);
}
