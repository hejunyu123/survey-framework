package edu.vwa.easyfeedback.client.common.page;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.InsertPanel;

import edu.vwa.easyfeedback.client.admin.event.ShowSurveyHandler;
import edu.vwa.easyfeedback.client.common.QuestionPresenterFactory;
import edu.vwa.easyfeedback.client.common.model.Question;
import edu.vwa.easyfeedback.client.common.model.Survey;
import edu.vwa.easyfeedback.client.common.model.SurveyElement;
import edu.vwa.easyfeedback.client.common.presenter.EventBus;
import edu.vwa.easyfeedback.client.common.presenter.PagePresenter;
import edu.vwa.easyfeedback.client.common.presenter.WidgetDisplay;
import edu.vwa.easyfeedback.client.common.service.PersistenceService;
import edu.vwa.easyfeedback.client.common.service.PersistenceServiceAsync;
import edu.vwa.easyfeedback.client.fillout.widget.QuestionPresenter;

public abstract class BaseSurveyPresenter<T extends BaseSurveyPresenter.Display>
	extends PagePresenter<T> implements ShowSurveyHandler {
	
	protected PersistenceServiceAsync persistenceService = (PersistenceServiceAsync) GWT.create(PersistenceService.class);
	protected Survey currentModel;	
	@SuppressWarnings("unused")
	private boolean isLoaded = false;
	private QuestionPresenterFactory factory;

	public BaseSurveyPresenter(T display, EventBus eventBus, QuestionPresenterFactory factory) {
		super(display, eventBus);
		this.setFactory(factory);
		currentModel = new Survey();
		
		init();
		
		// Handle show survey events
//		getEventBus().addHandler(ShowSurveyEvent.TYPE, new ShowSurveyHandler() {
//
//			/**
//			 * Handles the Show Survey event.
//			 * Reads the specified survey via the persistence service and causes the 
//			 * History to show the suvey view.
//			 */
//
//
//		});		
	}

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
		 * Container for adding question widgets.
		 * @return The question widget container
		 */
		public InsertPanel getQuestions();
		
		/**
		 * A button to save the current state of the page. 
		 * @return Facility to add click handlers
		 */
		public HasClickHandlers getBtnMakePersistent();
	}
	
	/**
	 * Hauptmethode, die die Oberfläche zusammenbaut
	 */	
	public void init() {
		getDisplay().getCaption().setText("%caption%");
		getDisplay().getDescription().setText("%description%");
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
		setLoading(true);
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
		setLoading(true);
		this.currentModel = model;
		try {
			getDisplay().getCaption().setText(model.getCaption());
			getDisplay().getDescription().setText(model.getDescription());

			while (getDisplay().getQuestions().getWidgetCount() > 0 ) getDisplay().getQuestions().remove(0);

			for (SurveyElement elem : model.getElements()) {
				try {
					// Get presenter for model
					Question question = (Question)elem;
					QuestionPresenter<QuestionPresenter.Display, Question> presenter
					= (QuestionPresenter<QuestionPresenter.Display, Question>) getFactory().createPresenterFor(question.getClass());
					
					// Load model and add question to survey
					presenter.load(question);
					addQuestion(presenter);

				} catch (Throwable e) {
					e.printStackTrace();
				} 
			} 
		}
		finally {
			setLoading(false);
		}
	}
	
	public void addQuestion(QuestionPresenter<?, ?> presenter) {
		getDisplay().getQuestions().add(presenter.getDisplay().asWidget());	
		presenter.getDisplay().getNumber().setValue(getDisplay().getQuestions().getWidgetIndex(presenter.getDisplay().asWidget()) + 1);
		presenter.onShow();
	}

	/**
	 * @see gwttest.client.samplesurvey.PersistsSurvey#save()
	 */
	public void save(){
		persistenceService.saveSurvey(toSurveyModel(), null);
	}	
	
	public String getPlace() {
		return "survey";
	}
	
	public void onShowSurvey(String surveyID) {
		onShow();
		load(surveyID);
	}
	
	protected void setLoading(boolean value) {
		this.isLoaded = !value;
	}

	private void setFactory(QuestionPresenterFactory factory) {
		this.factory = factory;
	}

	public QuestionPresenterFactory getFactory() {
		return factory;
	}

}
