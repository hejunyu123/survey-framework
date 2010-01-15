package edu.vwa.easyfeedback.client.fillout;

import com.google.gwt.user.client.History;

import edu.vwa.easyfeedback.client.common.presenter.DefaultEventBus;
import edu.vwa.easyfeedback.client.common.presenter.EventBus;
import edu.vwa.easyfeedback.client.fillout.page.FillOutSurveyPage;
import edu.vwa.easyfeedback.client.fillout.page.FillOutSurveyPresenter;
import edu.vwa.easyfeedback.client.fillout.widget.YesNoPresenter;
import edu.vwa.easyfeedback.client.fillout.widget.YesNoWidget;

public class FillOutModuleFactory {
	
	private static final FillOutModuleFactory instance = new FillOutModuleFactory();

	/**
	 * Singleton method.
	 * @return the instance
	 */
	public static FillOutModuleFactory get() {
		return instance;
	}
	
	public EventBus getEventBus() {
		return DefaultEventBus.get();
	}
	
	public FillOutSurveyPresenter createFillOutSurveyPage() {
		FillOutSurveyPresenter presenter = new FillOutSurveyPresenter(new FillOutSurveyPage(), getEventBus());
		History.addValueChangeHandler(presenter);
		return presenter;
	}
	
	public YesNoPresenter createYesNoWidget() {
		return new YesNoPresenter(new YesNoWidget(), getEventBus());
	}

}
