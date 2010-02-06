package gwttest.client.samplesurvey.widget.survey;

import gwttest.client.presenter.EventBus;
import gwttest.client.presenter.WidgetDisplay;

import com.google.gwt.user.client.ui.HasValue;

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
