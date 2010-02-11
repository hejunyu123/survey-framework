package edu.vwa.easyfeedback.client.common.presenter;

import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.RootPanel;

import edu.vwa.easyfeedback.client.common.event.ShowPageEvent;
import edu.vwa.easyfeedback.client.common.event.ShowPageHandler;

/**
 * A presenter for pages, i.e. widgets that use the whole viewport.
 * Implements the {@link ValueChangeHandler} interface and can listen to the History for being activated upon it's Place being
 * requested as the history token.
 * @author fleerkoetter
 *
 * @param <T> 
 */
public abstract class PagePresenter<T extends WidgetDisplay> extends MyPresenter<T> implements ShowPageHandler {

	public PagePresenter(T display, EventBus eventBus) {
		super(display, eventBus);
		eventBus.addHandler(ShowPageEvent.TYPE, this);
	}

	/**
	 * Shows the page in the whole viewport / root panel.
	 * Override this to do custom actions when the page is shown, but make sure to call super.show();
	 */
	public void onShow() {
		RootPanel rp = RootPanel.get();
		rp.clear();
		rp.add(getDisplay().asWidget());			
	}
}
