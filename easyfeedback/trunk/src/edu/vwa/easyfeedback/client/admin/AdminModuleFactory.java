package edu.vwa.easyfeedback.client.admin;

import com.google.gwt.user.client.History;

import edu.vwa.easyfeedback.client.admin.page.SelectSurveyPage;
import edu.vwa.easyfeedback.client.admin.page.SelectSurveyPresenter;
import edu.vwa.easyfeedback.client.common.presenter.DefaultEventBus;
import edu.vwa.easyfeedback.client.common.presenter.EventBus;
import edu.vwa.easyfeedback.client.fillout.widget.YesNoPresenter;
import edu.vwa.easyfeedback.client.fillout.widget.YesNoWidget;

public class AdminModuleFactory {
	
	private static final AdminModuleFactory instance = new AdminModuleFactory();

	/**
	 * Singleton method.
	 * @return the instance
	 */
	public static AdminModuleFactory get() {
		return instance;
	}
	
	public EventBus getEventBus() {
		return DefaultEventBus.get();
	}
	
	public SelectSurveyPresenter createSelectSurveyPage() {
		SelectSurveyPresenter presenter = new SelectSurveyPresenter(new SelectSurveyPage(), getEventBus());
		History.addValueChangeHandler(presenter);
		return presenter;
	}
	
	public YesNoPresenter createYesNoWidget() {
		return new YesNoPresenter(new YesNoWidget(), getEventBus());
	}

}
