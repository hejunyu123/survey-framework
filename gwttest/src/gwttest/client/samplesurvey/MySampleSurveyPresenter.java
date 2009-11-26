package gwttest.client.samplesurvey;

import gwttest.client.samplesurvey.model.Survey;
import gwttest.client.samplesurvey.service.PersistenceService;
import gwttest.client.samplesurvey.service.PersistenceServiceAsync;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasText;
import com.google.inject.Inject;

public class MySampleSurveyPresenter extends WidgetPresenter<MySampleSurveyPresenter.Display> {

	/**
	 * Display interface defining components of this user interface.
	 * @author fleerkoetter
	 *
	 */
	public interface Display extends WidgetDisplay {
		public HasText getCaption(); 
		public HasText getDescription();
		public HasClickHandlers getBtnMakePersistent();
	}
	
	
	@Inject
	public MySampleSurveyPresenter(Display display, EventBus eventBus) {
		super(display, eventBus);
	}

	/**
	 * History token used to adress the presented page.
	 */
	public static final Place place = new Place("MySampleSurvey");
	private PersistenceServiceAsync persistenceService = (PersistenceServiceAsync) GWT.create(PersistenceService.class);


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
	
	private Survey toSurveyModel() {
		return new Survey(display.getDescription().getText(), display.getCaption().getText());
	}
	
	/**
	 * @see gwttest.client.samplesurvey.PersistsSurvey#load(gwttest.client.samplesurvey.model.Survey)
	 */
	public void load(String name) {
//		display.getCaption().setText(survey.getCaption());
//		display.getDescription().setText(survey.getDescription());
		persistenceService.getSurvey(name, new AsyncCallback<Survey>() {

			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			public void onSuccess(Survey result) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	/**
	 * @see gwttest.client.samplesurvey.PersistsSurvey#save()
	 */
	public void save(){
		persistenceService.saveSurvey(toSurveyModel(), null);
	}
	
	
}
