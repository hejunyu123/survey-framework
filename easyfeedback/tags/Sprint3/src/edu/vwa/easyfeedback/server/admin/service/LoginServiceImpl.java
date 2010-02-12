package edu.vwa.easyfeedback.server.admin.service;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.vwa.easyfeedback.client.admin.service.LoginInfo;
import edu.vwa.easyfeedback.client.admin.service.LoginService;

/**
 * Implementiert den LoginService, der dazu dient den Login-Status,
 * Userinformationen und die Login-/Logout-Uris abzurufen.
 * @author Julian
 */
public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7073677870043278355L;

	/**
	 * @return Beinhaltet den Login-Status, Userinformationen und die Login-/Logout-Uris.
	 * @see gwttest.client.LoginService#login(java.lang.String)
	 * @see gwttest.client.LoginInfo
	 */
	public LoginInfo login(String requestUri) {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		LoginInfo loginInfo = new LoginInfo();
	
		if (user != null) {
			loginInfo.setLoggedIn(true);
			loginInfo.setEmailAddress(user.getEmail());
			loginInfo.setNickname(user.getNickname());
			loginInfo.setLogoutUrl(userService.createLogoutURL(requestUri));
	    } else {
	    	loginInfo.setLoggedIn(false);
	    	loginInfo.setLoginUrl(userService.createLoginURL(requestUri));
		}
		return loginInfo;
	}
}