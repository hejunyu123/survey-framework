package edu.vwa.easyfeedback.client.fillout.widget;

import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;

import edu.vwa.easyfeedback.client.common.presenter.EventBus;
import edu.vwa.easyfeedback.client.common.presenter.MyPresenter;
import edu.vwa.easyfeedback.client.common.presenter.WidgetDisplay;

/**
 * Abstract presenter for a {@link QuestionWidget}.
 * @author fleerkoetter
 *
 * @param <T> The correspondant display interface.
 */
public abstract class QuestionPresenter<T extends QuestionPresenter.Display> extends MyPresenter<T> {

	public interface Display extends WidgetDisplay {
		HasText getCaption();
		HasText getDescription();
		HasWidgets getElementsContainer();
	}

	public QuestionPresenter(T display, EventBus eventBus) {
		super(display, eventBus);
	}

	@Override
	public abstract String getPlace();

	@Override
	public abstract void onShow();

}
