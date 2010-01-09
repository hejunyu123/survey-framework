package gwttest.client.presenter;


import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.RootPanel;

public abstract class MyPresenter<T extends WidgetDisplay> implements ValueChangeHandler<String>{
	
	private final T display;
	private EventBus eventBus;

	public MyPresenter(T display, EventBus eventBus) {
		this.display = display;
		this.eventBus = eventBus;
	}

	public T getDisplay() {
		return display;
	}
	
	public EventBus getEventBus() {
		return eventBus;
	}
	
	public void onValueChange(ValueChangeEvent<String> event) {
		if (getPlace().equals(event.getValue())) {
			onShow();
			RootPanel rp = RootPanel.get();
			rp.clear();
			rp.add(getDisplay().asWidget());			
		}
	}

	/**
	 * Method executed when the Presenter's display should be shown.
	 */
	public abstract void onShow();

	/**
	 * Identifies this widget.
	 * @return A constant identifier literal.
	 */
	public abstract String getPlace();

}
