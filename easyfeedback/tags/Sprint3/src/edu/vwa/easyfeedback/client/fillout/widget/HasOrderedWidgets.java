package edu.vwa.easyfeedback.client.fillout.widget;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

/**
 * Interface for marking components that hold widgets in a specific order.
 * @author fleerkoetter
 *
 */
public interface HasOrderedWidgets extends HasWidgets {
	
	/**
	 * Determines the position of a widget in this container
	 * @param w A widget that is part of this container
	 * @return Index of w
	 */
	public int getPosition(Widget w);
	
	/**
	 * Repositions a widget in this container or adds it at a specified position
	 * @param w The widget
	 */
	public void setPosition(Widget w);	

}
