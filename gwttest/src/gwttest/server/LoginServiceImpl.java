package gwttest.server;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import gwttest.client.LoginInfo;
import gwttest.client.LoginService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * Implementiert den LoginService, der dazu dient den Login-Status,
 * Userinformationen und die Login-/Logout-Uris abzurufen.
 * @author Julian
 */
public class LoginServiceImpl extends RemoteServiceServlet implements
    LoginService {

	private static final long serialVersionUID = 8943138328986929525L;

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