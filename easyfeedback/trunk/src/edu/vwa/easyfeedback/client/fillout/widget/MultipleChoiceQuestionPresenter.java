	package edu.vwa.easyfeedback.client.fillout.widget;

import edu.vwa.easyfeedback.client.common.model.MultipleChoiceOption;
import edu.vwa.easyfeedback.client.common.model.MultipleChoiceQuestion;
import edu.vwa.easyfeedback.client.common.presenter.EventBus;
import edu.vwa.easyfeedback.client.common.presenter.MyPresenter;

/**
 * Presents a question with multiple either exclusive or alternate answering choices. 
 * @author fleerkoetter
 *
 */
public class MultipleChoiceQuestionPresenter
	 extends QuestionPresenter<MultipleChoiceQuestionPresenter.Display, MultipleChoiceQuestion> {
	
	public interface Display extends QuestionPresenter.Display {
		public void addOption(String caption, boolean value, String name, boolean isExclusive);
	}
	
	private MultipleChoiceQuestion model = new MultipleChoiceQuestion();	
	

	public MultipleChoiceQuestionPresenter(Display display, EventBus eventBus) {
		super(display, eventBus);
	}
	

	@Override
	public String getPlace() {
		return "";
	}

	/**
	 * Shows and refreshes the display.
	 * @see MyPresenter#onShow()
	 */
	@Override
	public void onShow() {	
		
	}

	/**
	 * Loads a {@link MultipleChoiceQuestion} and refreshes the display
	 */
	@Override
	public void load(MultipleChoiceQuestion model) {
		this.model = model;
		super.load(model);

		while (getDisplay().getElementsContainer().getWidgetCount() > 0) getDisplay().getElementsContainer().remove(0);
		for (MultipleChoiceOption option : model.getOptions()) {
			addOption(option);
		}	
		
		onShow();
	}
	
	/**
	 * Add a choice model to the choices
	 * @param choice
	 */
	private void addOption(final MultipleChoiceOption choice) {
		((MultipleChoiceQuestionPresenter.Display)getDisplay()).addOption(choice.getCaption(), choice.getValue(),
				choice.getName(), model.getMaxOptions() == 1);
	}		
	
	
	public MultipleChoiceQuestion getModel() {
		return model;
	}


	public void setModel(MultipleChoiceQuestion model) {
		this.model = model;
	}
	
}
