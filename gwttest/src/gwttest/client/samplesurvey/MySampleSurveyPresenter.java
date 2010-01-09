package gwttest.client.samplesurvey;

import gwttest.client.presenter.EventBus;
import gwttest.client.presenter.MyPresenter;
import gwttest.client.presenter.WidgetDisplay;
import gwttest.client.samplesurvey.event.ShowSurveyEvent;
import gwttest.client.samplesurvey.event.ShowSurveyHandler;
import gwttest.client.samplesurvey.model.Survey;
import gwttest.client.samplesurvey.service.PersistenceService;
import gwttest.client.samplesurvey.service.PersistenceServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasText;

public class MySampleSurveyPresenter extends MyPresenter<MySampleSurveyPresenter.Display>{


	public MySampleSurveyPresenter(Display display, EventBus eventBus) {
		super(display, eventBus);
		init();
	}

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

	/**
	 * History token used to adress the presented page.
	 */
	private PersistenceServiceAsync persistenceService = (PersistenceServiceAsync) GWT.create(PersistenceService.class);


	@Override
	public String getPlace() {
		// TODO Auto-generated method stub
		return "sample";
	}

	/**
	 * Hauptmethode, die die Oberfläche zusammenbaut
	 */	
//	@Override
	public void init() {
		// TODO Auto-generated method stub
		getDisplay().getCaption().setText("HelloWorld Survey");
		getDisplay().getDescription().setText("This is just a sample of an survey");
		
		getEventBus().addHandler(ShowSurveyEvent.TYPE, new ShowSurveyHandler() {

			public void onShowSurvey(String surveyID) {
				load(surveyID);
			}
			
		});
	}
	
	private Survey toSurveyModel() {
		return new Survey(getDisplay().getDescription().getText(), getDisplay().getCaption().getText());
	}
	
	/**
	 * Lädt ein Suvey aus der Datenhaltung durch die Benutzung des PersistsSuvey-Services
	 * @see gwttest.client.samplesurvey.PersistsSurvey#load(gwttest.client.samplesurvey.model.Survey)
	 */
	public void load(String name) {
		persistenceService.getSurvey(name, new AsyncCallback<Survey>() {

			public void onFailure(Throwable caught) {
				
			}

			public void onSuccess(Survey result) {
				load(result);
			}
		});
	}
	
	
	/**
	 * Präsentiert ein Survey-Model auf dem View.
	 * @param model Das darzustellende Modell
	 */
	public void load(Survey model) {	
		getDisplay().getCaption().setText(model.getCaption());
		getDisplay().getDescription().setText(model.getDescription());		
	}
	
	/**
	 * @see gwttest.client.samplesurvey.PersistsSurvey#save()
	 */
	public void save(){
		persistenceService.saveSurvey(toSurveyModel(), null);
	}

	@Override
	public void onShow() {
		// TODO Auto-generated method stub
//		Window.alert("Hi!");
	}
	
	
}
