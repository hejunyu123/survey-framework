package edu.vwa.easyfeedback.client.common.presenter;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.GwtEvent.Type;

/**
 * This is an interface for an event bus.
 * An event bus is used to decouple the application. It reduces the amount of direct dependencies between classes. Instead of directly
 * calling another object's method, a class fires an {@link GwtEvent} on the EventBus via {@link EventBus#fireEvent(GwtEvent)}. The
 * {@link EventHandler} assigned to this type then executes the desired logic.
 * 
 * @author fleerkoetter
 *
 */
public interface EventBus {

	<H extends EventHandler> HandlerRegistration addHandler( Type<H> type, H handler );

	void fireEvent( GwtEvent<?> event );

	<H extends EventHandler> H getHandler( Type<H> type, int index );

	int getHandlerCount( Type<?> type );

	boolean isEventHandled( Type<?> e );
	
	
}