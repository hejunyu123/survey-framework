package edu.vwa.easyfeedback.fillout.client;

import com.google.gwt.user.client.History;

import edu.vwa.easyfeedback.common.client.presenter.DefaultEventBus;
import edu.vwa.easyfeedback.common.client.presenter.EventBus;
import edu.vwa.easyfeedback.fillout.client.page.FillOutSurveyPage;
import edu.vwa.easyfeedback.fillout.client.page.FillOutSurveyPresenter;
import edu.vwa.easyfeedback.fillout.client.widget.YesNoPresenter;
import edu.vwa.easyfeedback.fillout.client.widget.YesNoWidget;

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
