package edu.vwa.easyfeedback.client.common.presenter;

import com.google.gwt.event.shared.HandlerManager;

/**
 * Default implementation for the {@link EventBus} interface. 
 * It uses GWT's HandlerManager class for this purpose.
 * @author fleerkoetter
 *
 */
public class DefaultEventBus extends HandlerManager implements EventBus {
	
	private static DefaultEventBus instance = new DefaultEventBus(null);

	public DefaultEventBus(Object source) {
		super(source);
	}
	
	/**
	 * Singleton method.
	 * @return The only instance of this class
	 */
	public static EventBus get() {
		return instance;
	}

}
