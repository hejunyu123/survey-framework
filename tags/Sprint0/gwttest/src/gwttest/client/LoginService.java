package gwttest.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @author Julian
 */
@RemoteServiceRelativePath("login")
public interface LoginService extends RemoteService {
	/**
	 * @param requestUri Url, auf die nach dem Einloggen weitergeleitet werden soll.
	 * @return Logininformatonen
	 */
	public LoginInfo login(String requestUri);
}