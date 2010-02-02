package edu.vwa.easyfeedback.client.fillout.page;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;

import edu.vwa.easyfeedback.client.common.QuestionPresenterFactory;
import edu.vwa.easyfeedback.client.common.page.BaseSurveyPage;

/**
 * This is a sample of how the view of a survey could look like.
 * For the final product, this needs to be seperated into a "Edit survey" and a "Take survey" view.
 * @author fleerkoetter
 *
 */
public class FillOutSurveyPage extends BaseSurveyPage implements FillOutSurveyPresenter.Display {

	public FillOutSurveyPage(QuestionPresenterFactory factory) {
		super(factory);
	}

	private Button btnMakePersistent;
	
	@Override
	protected void construct() {
		btnMakePersistent = new Button("Save");
		root.add(btnMakePersistent);
	}

	public HasClickHandlers getBtnMakePersistent() {
		return btnMakePersistent;
	}	
	
}
