package edu.vwa.easyfeedback.client.fillout.widget;

import com.google.gwt.user.client.ui.HasValue;

import edu.vwa.easyfeedback.client.common.presenter.EventBus;
import edu.vwa.easyfeedback.client.common.presenter.WidgetDisplay;

/**
 * Persents a YesNoWidget.
 * @author fleerkoetter
 *
 */
public class YesNoPresenter extends QuestionPresenter<YesNoPresenter.Display> {
	
	public YesNoPresenter(Display display, EventBus eventBus) {
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
	public String getPlace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onShow() {
		// TODO Auto-generated method stub
		
	}

}
