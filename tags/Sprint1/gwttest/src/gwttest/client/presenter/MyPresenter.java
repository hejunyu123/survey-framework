package gwttest.client.presenter;

/**
 * Abstract superclass for all presenters according to MVP pattern.
 * The presenter holds the logic for the user interface element it presents. He is generically bound to a display interface,
 * which defines of which logic elements the user interface consists of. The presenter uses only this logic abstraction to
 * implement the logic, while the view class holds the concrete implementation through implementing the display interface.
 *  
 * @author fleerkoetter
 *
 * @param <T> The display interface that logically defines the elements of the view. Usually, this is a sub-interface of the 
 *   concrete presenter class.
 */
public abstract class MyPresenter<T extends WidgetDisplay>{
	
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
