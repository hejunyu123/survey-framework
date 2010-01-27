package edu.vwa.easyfeedback.admin.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * @author Pesco (von Julian aus r12 übernommen)
 */
@RemoteServiceRelativePath("login")
public interface LoginService extends RemoteService {
	/**
	 * @param requestUri Url, auf die nach dem Einloggen weitergeleitet werden soll.
	 * @return Logininformatonen
	 */
	public LoginInfo login(String requestUri);
}