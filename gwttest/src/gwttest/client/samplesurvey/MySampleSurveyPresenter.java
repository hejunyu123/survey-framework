package gwttest.client.samplesurvey;

import gwttest.client.GwttestFactory;
import gwttest.client.presenter.EventBus;
import gwttest.client.presenter.PagePresenter;
import gwttest.client.presenter.WidgetDisplay;
import gwttest.client.samplesurvey.event.ShowSurveyEvent;
import gwttest.client.samplesurvey.event.ShowSurveyHandler;
import gwttest.client.samplesurvey.model.Survey;
import gwttest.client.samplesurvey.service.PersistenceService;
import gwttest.client.samplesurvey.service.PersistenceServiceAsync;
import gwttest.client.samplesurvey.widget.survey.YesNoPresenter;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;

/**
 * Presents a MySampleSurveyPage.
 * @author fleerkoetter
 *
 */
public class MySampleSurveyPresenter extends PagePresenter<MySampleSurveyPresenter.Display>{


	public MySampleSurveyPresenter(Display display, EventBus eventBus) {
		super(display, eventBus);
		currentModel = new Survey();
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
		public HasWidgets getQuestions();
	}

	/**
	 * History token used to adress the presented page.
	 */
	private PersistenceServiceAsync persistenceService = (PersistenceServiceAsync) GWT.create(PersistenceService.class);
	private Survey currentModel;


	@Override
	public String getPlace() {
		// TODO Auto-generated method stub
		return "sample";
	}

	/**
	 * Hauptmethode, die die Oberfl�che zusammenbaut
	 */	
	public void init() {
		// TODO Auto-generated method stub
		getDisplay().getCaption().setText("HelloWorld Survey");
		getDisplay().getDescription().setText("This is just a sample of an survey");
		
		// Add handler to save button
		getDisplay().getBtnMakePersistent().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				save();				
			}
			
		});
		
		// Handle show survey events
		getEventBus().addHandler(ShowSurveyEvent.TYPE, new ShowSurveyHandler() {

			/**
			 * Handles the Show Survey event.
			 * Reads the specified survey via the persistence service and causes the 
			 * History to show the suvey view.
			 */
			public void onShowSurvey(String surveyID) {
				load(surveyID);
				History.newItem(getPlace(), true);
			}
			
		});
		
		// Add a question widget for demostration purpose
		YesNoPresenter demo = GwttestFactory.get().createYesNoWidget();
//		getDisplay().getQuestions().add(demo.getDisplay().asWidget());
	}
	
	private Survey toSurveyModel() {
		return new Survey(currentModel.getName(),
				currentModel.getUser(), 
				getDisplay().getDescription().getText(), 
				getDisplay().getCaption().getText()
				);
	}
	
	/**
	 * L�dt ein Suvey aus der Datenhaltung durch die Benutzung des PersistsSuvey-Services
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
	 * Pr�sentiert ein Survey-Model auf dem View.
	 * @param model Das darzustellende Modell
	 */
	public void load(Survey model) {	
		this.currentModel = model;
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
