package edu.vwa.easyfeedback.common.client.presenter;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * A presenter for pages, i.e. widgets that use the whole viewport.
 * Implements the {@link ValueChangeHandler} interface and can listen to the History for being activated upon it's Place being
 * requested as the history token.
 * @author fleerkoetter
 *
 * @param <T> 
 */
public abstract class PagePresenter<T extends WidgetDisplay> extends MyPresenter<T> implements ValueChangeHandler<String>{

	public PagePresenter(T display, EventBus eventBus) {
		super(display, eventBus);
	}
	
	public void onValueChange(ValueChangeEvent<String> event) {
		if (getPlace().equals(event.getValue())) {
			onShow();
			RootPanel rp = RootPanel.get();
			rp.clear();
			rp.add(getDisplay().asWidget());			
		}
	}	

}
