package edu.vwa.easyfeedback.client.fillout.widget;

import com.google.gwt.user.client.ui.HasText;

import edu.vwa.easyfeedback.client.common.model.FreeTextQuestion;
import edu.vwa.easyfeedback.client.common.presenter.EventBus;

/**
 * A presenter for a question where the user can enter a text freely.
 * @author fleerkoetter
 *
 */
public class FreeTextQuestionPresenter extends QuestionPresenter<FreeTextQuestionPresenter.Display, FreeTextQuestion> {
	
	/**
	 * @see QuestionPresenter.Display
	 * @author fleerkoetter
	 *
	 */
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
	public void load(FreeTextQuestion model) {
		super.load(model);
		this.setMultiLine(model.getIsMultiLineText());
		getDisplay().getText().setText(model.getText());
	}

	@Override
	public void onShow() {
		
	}
	
	protected void setMultiLine(boolean value) {
		getDisplay().setMultiLine(value);
	}

}
