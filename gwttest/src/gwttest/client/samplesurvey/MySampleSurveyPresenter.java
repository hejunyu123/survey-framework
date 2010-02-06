package gwttest.client.samplesurvey;

import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;

import net.customware.gwt.presenter.client.widget.WidgetPresenter;

public class MySampleSurveyPresenter extends WidgetPresenter<MySampleSurveyPresenter.Display> {
	
	public MySampleSurveyPresenter(Display display, EventBus eventBus) {
		super(display, eventBus);
		// TODO Auto-generated constructor stub
	}

	/**
	 * History token used to adress the presented page.
	 */
	public static final Place place = new Place("MySampleSurvey");
	
	public interface Display extends WidgetDisplay {
		public HasText getCaption(); 
		public HasText getDescription();
	}

	@Override
	public Place getPlace() {
		// TODO Auto-generated method stub
		return place;
	}

	@Override
	/**
	 * Hauptmethode, die die Oberfläche zusammenbaut
	 */
	protected void onBind() {
		// TODO Auto-generated method stub
		display.getCaption().setText("HelloWorld Survey");
		display.getDescription().setText("This is just a sample of an survey");
		
	}

	@Override
	protected void onPlaceRequest(PlaceRequest request) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onUnbind() {
		// TODO Auto-generated method stub
		
	}

	public void refreshDisplay() {
		// TODO Auto-generated method stub
		
	}

	public void revealDisplay() {
		// TODO Auto-generated method stub
		
	}
}
