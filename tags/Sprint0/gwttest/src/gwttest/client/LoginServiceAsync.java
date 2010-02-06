package gwttest.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author Julian
 */
public interface LoginServiceAsync {
	/**
	 * @param requestUri Url, auf die nach dem Einloggen weitergeleitet werden soll.
	 * @param async AsyncCallback Handler
	 */
	public void login(String requestUri, AsyncCallback<LoginInfo> async);
}