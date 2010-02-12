package edu.vwa.easyfeedback.client.admin.page;

import com.google.gwt.user.client.ui.InsertPanel;

import edu.vwa.easyfeedback.client.common.QuestionPresenterFactory;
import edu.vwa.easyfeedback.client.common.page.BaseSurveyPage;

public class EditSurveyPage extends BaseSurveyPage implements EditSurveyPresenter.Display {

	public EditSurveyPage(QuestionPresenterFactory factory) {
		super(factory);
	}


	public InsertPanel asPanel() {
		return root;
	}


	@Override
	protected void construct() {
		// TODO Auto-generated method stub
		
	}

}
