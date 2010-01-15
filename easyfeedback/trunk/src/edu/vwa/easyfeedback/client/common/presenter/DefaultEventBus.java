package edu.vwa.easyfeedback.client.common.presenter;

import com.google.gwt.event.shared.HandlerManager;

public class DefaultEventBus extends HandlerManager implements EventBus {
	
	private static DefaultEventBus instance = new DefaultEventBus(null);

	public DefaultEventBus(Object source) {
		super(source);
	}
	
	public static EventBus get() {
		return instance;
	}

}
