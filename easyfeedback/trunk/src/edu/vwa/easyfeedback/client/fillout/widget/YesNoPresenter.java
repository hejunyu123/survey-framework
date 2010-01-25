package edu.vwa.easyfeedback.client.fillout.widget;

import com.google.gwt.user.client.ui.HasValue;

import edu.vwa.easyfeedback.client.common.model.YesNoQuestion;
import edu.vwa.easyfeedback.client.common.presenter.EventBus;
import edu.vwa.easyfeedback.client.common.presenter.WidgetDisplay;

/**
 * Persents a YesNoWidget.
 * @author fleerkoetter
 *
 */
public class YesNoPresenter extends QuestionPresenter<YesNoPresenter.Display, YesNoQuestion> {
	
	public YesNoPresenter(final Display display, final EventBus eventBus) {
		super(display, eventBus);
	}

	/**
	 * @see WidgetDisplay
	 * @author fleerkoetter
	 *
	 */
	public interface Display extends QuestionPresenter.Display {
		HasValue<Boolean> getYes();
		HasValue<Boolean> getNo();
	}

	@Override
	public final String getPlace() {
		return "";
	}

	@Override
	public void onShow() {

	}

	@Override
	public final void load(final YesNoQuestion model) {
		super.load(model);
		getDisplay().getYes().setValue(model.getIsYes());
		getDisplay().getNo().setValue(!model.getIsYes());
	}

}
