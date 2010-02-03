package edu.vwa.easyfeedback.client.fillout.page;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;

import edu.vwa.easyfeedback.client.common.QuestionPresenterFactory;
import edu.vwa.easyfeedback.client.common.model.Survey;
import edu.vwa.easyfeedback.client.common.page.BaseSurveyPresenter;
import edu.vwa.easyfeedback.client.common.presenter.EventBus;

/**
 * Presents a MySampleSurveyPage.
 * @author fleerkoetter
 *
 */
public class FillOutSurveyPresenter extends BaseSurveyPresenter<FillOutSurveyPresenter.Display>{


	public FillOutSurveyPresenter(Display display, EventBus eventBus, QuestionPresenterFactory factory) {
		super(display, eventBus, factory);
		currentModel = new Survey();
	}

	/**
	 * Display interface defining components of this user interface.
	 * @author fleerkoetter
	 *
	 */
	public interface Display extends BaseSurveyPresenter.Display {
		/**
		 * 
		 * @return
		 */
		public HasClickHandlers getBtnMakePersistent();
	}



	@Override
	public String getPlace() {
		// TODO Auto-generated method stub
		return "sample";
	}

	/**
	 * Hauptmethode, die die Oberfläche zusammenbaut
	 */	
	public void init() {
		super.init();

		// Add handler to save button
		getDisplay().getBtnMakePersistent().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				save();				
			}

		});
	}
}
