package edu.vwa.easyfeedback.client.common.event;

import com.google.gwt.event.shared.EventHandler;

public interface ShowPageHandler extends EventHandler {
	public void onShow();
	public String getPlace();
}
