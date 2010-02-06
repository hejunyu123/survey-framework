package edu.vwa.easyfeedback.client.fillout.widget;

import com.google.gwt.user.client.ui.HasText;

import edu.vwa.easyfeedback.client.common.presenter.EventBus;

public class FreeTextQuestionPresenter extends QuestionPresenter<FreeTextQuestionPresenter.Display> {
	
	public interface Display extends QuestionPresenter.Display {
		public HasText getText();
		public boolean isMultiLine();
		public void setMultiLine(boolean value);
	}
	
	public FreeTextQuestionPresenter(Display display, EventBus eventBus) {
		super(display, eventBus);
	}

	@Override
	public String getPlace() {
		return null;
		
	}

	@Override
	public void onShow() {
		
	}

}
