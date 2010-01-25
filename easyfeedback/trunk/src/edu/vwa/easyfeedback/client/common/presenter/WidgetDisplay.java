package edu.vwa.easyfeedback.client.common.presenter;

import com.google.gwt.user.client.ui.Widget;

/**
 * A declaration interface for view classes according to the MVP pattern. 
 * @author fleerkoetter
 *
 */
public interface WidgetDisplay {
	
	/**
	 * The widget implementing the Display. Usually, this is the current instance.
	 * @return The widget
	 */
	public Widget asWidget();

}
