package edu.vwa.easyfeedback.client.admin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.History;

import edu.vwa.easyfeedback.client.admin.page.SelectSurveyPage;
import edu.vwa.easyfeedback.client.admin.page.SelectSurveyPresenter;
import edu.vwa.easyfeedback.client.admin.widget.SurveyOptionsPresenter;
import edu.vwa.easyfeedback.client.admin.widget.SurveyOptionsWidget;
import edu.vwa.easyfeedback.client.common.presenter.DefaultEventBus;
import edu.vwa.easyfeedback.client.common.presenter.EventBus;
import edu.vwa.easyfeedback.client.common.service.PersistenceService;
import edu.vwa.easyfeedback.client.common.service.PersistenceServiceAsync;
import edu.vwa.easyfeedback.client.fillout.widget.YesNoPresenter;
import edu.vwa.easyfeedback.client.fillout.widget.YesNoWidget;

public class AdminModuleFactory {
	
	private static final AdminModuleFactory instance = new AdminModuleFactory();
	private static final PersistenceServiceAsync persitanceService = GWT.create(PersistenceService.class);

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
	
	public SurveyOptionsPresenter createSurveyOptionsWidget() {
		SurveyOptionsPresenter presenter = new SurveyOptionsPresenter(new SurveyOptionsWidget(), getEventBus());
		return presenter;
	}
	
	public PersistenceServiceAsync getPersistanceService()
	{
		return persitanceService;
	}

	//public LoginPresenter createLoginWidget() {
		//return new LoginPresenter(new LoginWidget(), getEventBus());
	//}
	
	public YesNoPresenter createYesNoWidget() {
		return new YesNoPresenter(new YesNoWidget(), getEventBus());
	}

}
