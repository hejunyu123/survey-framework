package edu.vwa.easyfeedback.client.fillout.widget;

import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;

import edu.vwa.easyfeedback.client.common.model.Question;
import edu.vwa.easyfeedback.client.common.presenter.EventBus;
import edu.vwa.easyfeedback.client.common.presenter.MyPresenter;
import edu.vwa.easyfeedback.client.common.presenter.WidgetDisplay;

/**
 * Abstract presenter for a {@link QuestionWidget}.
 * @author fleerkoetter
 *
 * @param <T> The correspondent display interface.
 * @param <M> The correspondent model data class.
 */
public abstract class QuestionPresenter<T extends QuestionPresenter.Display, M extends Question> extends MyPresenter<T> {

	/**
	 * MVP Display interface for question views.
	 * @see WidgetDisplay
	 * @author fleerkoetter
	 *
	 */
	public interface Display extends WidgetDisplay {
		/**
		 * The caption should contain the question's text.
		 * @return The caption
		 */
		HasText getCaption();
		
		/**
		 * The description provides additional information on the question.
		 * @return The description
		 */
		HasText getDescription();
		
		/**
		 * The number of a question widget in the survey
		 * @return The number
		 */
		HasValue<Integer> getNumber();
		
		/**
		 * Container for adding widgets representing the user's answering choices.
		 * @return The container.
		 */
		HasWidgets getElementsContainer();
		
		/**
		 * If set to true, show something to indicate that this question is optional
		 */
		HasValue<Boolean> getIsOptional();
	}

	public QuestionPresenter(T display, EventBus eventBus) {
		super(display, eventBus);
	}
	
	/**
	 * Writes the data from a correspondent model class to the view.
	 * For concrete question type widgets, override this method and call super.load in the first place!
	 * @param model The data instance
	 */
	public void load(M model) {
		getDisplay().getDescription().setText(model.getDescription());
		getDisplay().getCaption().setText(model.getCaption());
		getDisplay().getIsOptional().setValue(model.getIsOptional());
	}	

	@Override
	public abstract String getPlace();

	@Override
	public abstract void onShow();

}
