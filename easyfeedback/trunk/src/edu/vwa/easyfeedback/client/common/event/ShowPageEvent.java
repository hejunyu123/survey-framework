package edu.vwa.easyfeedback.client.common.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * 
 * @author fleerkoetter
 *
 */
public class ShowPageEvent extends GwtEvent<ShowPageHandler> {
	
	public static Type<ShowPageHandler> TYPE = new Type<ShowPageHandler>();

	private String place = "";

	public ShowPageEvent(String place) {
		this.place = place;
	}
	
	/**
	 * 
	 */
	@Override
	protected void dispatch(ShowPageHandler handler) {
		if (handler.getPlace().equals(this.place)) {
			handler.onShow();
		}		
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ShowPageHandler> getAssociatedType() {
		return TYPE;
	}

}
