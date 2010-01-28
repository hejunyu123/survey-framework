package edu.vwa.easyfeedback.client.fillout.page;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IndexedPanel;

import edu.vwa.easyfeedback.client.admin.event.ShowSurveyEvent;
import edu.vwa.easyfeedback.client.admin.event.ShowSurveyHandler;
import edu.vwa.easyfeedback.client.common.model.Question;
import edu.vwa.easyfeedback.client.common.model.Survey;
import edu.vwa.easyfeedback.client.common.model.SurveyElement;
import edu.vwa.easyfeedback.client.common.presenter.EventBus;
import edu.vwa.easyfeedback.client.common.presenter.PagePresenter;
import edu.vwa.easyfeedback.client.common.presenter.WidgetDisplay;
import edu.vwa.easyfeedback.client.common.service.PersistenceService;
import edu.vwa.easyfeedback.client.common.service.PersistenceServiceAsync;
import edu.vwa.easyfeedback.client.fillout.FillOutModuleFactory;
import edu.vwa.easyfeedback.client.fillout.widget.QuestionPresenter;

/**
 * Presents a MySampleSurveyPage.
 * @author fleerkoetter
 *
 */
public class FillOutSurveyPresenter extends PagePresenter<FillOutSurveyPresenter.Display>{


	public FillOutSurveyPresenter(Display display, EventBus eventBus) {
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
		/**
		 * The survey's caption.
		 * @return
		 */
		public HasText getCaption();

		/**
		 * The survey's description or introductry text.
		 * @return
		 */
		public HasText getDescription();

		/**
		 * 
		 * @return
		 */
		public HasClickHandlers getBtnMakePersistent();

		/**
		 * Container for adding question widgets.
		 * @return The question widget container
		 */
		public HasWidgets getQuestions();
		
		/**
		 * Returns the question container with facilites to determine the order of the contained widgets
		 * @return The question widget container
		 */
		public IndexedPanel getQuestionOrder();
	}


	private PersistenceServiceAsync persistenceService = (PersistenceServiceAsync) GWT.create(PersistenceService.class);
	private Survey currentModel;


	@Override
	public String getPlace() {
		// TODO Auto-generated method stub
		return "sample";
	}

	/**
	 * Hauptmethode, die die Oberfläche zusammenbaut
	 */	
	public void init() {
		getDisplay().getCaption().setText("%caption%");
		getDisplay().getDescription().setText("%description");

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
				//History.newItem(getPlace(), true);
			}

		});


	}

	private Survey toSurveyModel() {
		//TODO make dynamic
		return new Survey(currentModel.getName(),
				currentModel.getUser(), 
				getDisplay().getDescription().getText(), 
				getDisplay().getCaption().getText()
		);
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
	 * @throws Throwable 
	 */
	@SuppressWarnings("unchecked")
	public void load(Survey model) {	
		this.currentModel = model;
		getDisplay().getCaption().setText(model.getCaption());
		getDisplay().getDescription().setText(model.getDescription());
		
		getDisplay().getQuestions().clear();
		
		int questionNum = 0;
		for (SurveyElement elem : model.getElements()) {
			try {
				Question question = (Question)elem;
				QuestionPresenter<QuestionPresenter.Display, Question> presenter
					= (QuestionPresenter<QuestionPresenter.Display, Question>) FillOutModuleFactory.get().createPresenterFor(question.getClass());
				presenter.load(question);
				presenter.getDisplay().getNumber().setValue(++questionNum);
				getDisplay().getQuestions().add(presenter.getDisplay().asWidget());

			} catch (Throwable e) {
				e.printStackTrace();
			} 
		}
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
