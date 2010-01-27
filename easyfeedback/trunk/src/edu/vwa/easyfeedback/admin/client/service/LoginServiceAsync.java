package edu.vwa.easyfeedback.admin.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author Pesco (von Julian aus r12 übernommen)
 */
public interface LoginServiceAsync {
	/**
	 * @param requestUri Url, auf die nach dem Einloggen weitergeleitet werden soll.
	 * @param async AsyncCallback Handler
	 */
	public void login(String requestUri, AsyncCallback<LoginInfo> async);
}