package edu.vwa.easyfeedback.client.admin.page;

import edu.vwa.easyfeedback.client.common.QuestionPresenterFactory;
import edu.vwa.easyfeedback.client.common.page.BaseSurveyPresenter;
import edu.vwa.easyfeedback.client.common.presenter.EventBus;

public class EditSurveyPresenter extends BaseSurveyPresenter<EditSurveyPresenter.Display> {

	public EditSurveyPresenter(Display display, EventBus eventBus, QuestionPresenterFactory factory) {
		super(display, eventBus, factory);
	}

	@Override
	public void init() {
		super.init();		
	}

	public interface Display extends BaseSurveyPresenter.Display {
		
	}

	@Override
	public String getPlace() {
		return "edit";
	}	

}
