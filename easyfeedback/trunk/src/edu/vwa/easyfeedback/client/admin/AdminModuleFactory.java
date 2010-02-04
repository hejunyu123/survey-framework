package edu.vwa.easyfeedback.client.admin;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;

import edu.vwa.easyfeedback.client.admin.page.EditSurveyPage;
import edu.vwa.easyfeedback.client.admin.page.EditSurveyPresenter;
import edu.vwa.easyfeedback.client.admin.page.SelectSurveyPage;
import edu.vwa.easyfeedback.client.admin.page.SelectSurveyPresenter;
import edu.vwa.easyfeedback.client.admin.widget.EditableFreeTextQuestionPresenter;
import edu.vwa.easyfeedback.client.admin.widget.EditableFreeTextQuestionWidget;
import edu.vwa.easyfeedback.client.admin.widget.EditableLabel;
import edu.vwa.easyfeedback.client.admin.widget.EditableMultipleChoiceQuestionPresenter;
import edu.vwa.easyfeedback.client.admin.widget.EditableMultipleChoiceQuestionWidget;
import edu.vwa.easyfeedback.client.admin.widget.SelectQuestionTypePresenter;
import edu.vwa.easyfeedback.client.admin.widget.SelectQuestionTypeWidget;
import edu.vwa.easyfeedback.client.admin.widget.SurveyOptionsPresenter;
import edu.vwa.easyfeedback.client.admin.widget.SurveyOptionsWidget;
import edu.vwa.easyfeedback.client.common.QuestionPresenterFactory;
import edu.vwa.easyfeedback.client.common.presenter.DefaultEventBus;
import edu.vwa.easyfeedback.client.common.presenter.EventBus;
import edu.vwa.easyfeedback.client.common.service.PersistenceService;
import edu.vwa.easyfeedback.client.common.service.PersistenceServiceAsync;
import edu.vwa.easyfeedback.client.fillout.widget.FreeTextQuestionPresenter;
import edu.vwa.easyfeedback.client.fillout.widget.MultipleChoiceQuestionPresenter;
import edu.vwa.easyfeedback.client.fillout.widget.YesNoPresenter;
import edu.vwa.easyfeedback.client.fillout.widget.YesNoWidget;

public class AdminModuleFactory extends QuestionPresenterFactory {
	
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
	
	/*
	 * Pages
	 */
	
	public SelectSurveyPresenter createSelectSurveyPage() {
		SelectSurveyPresenter presenter = new SelectSurveyPresenter(new SelectSurveyPage(), getEventBus());
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
	
	/*
	 * Question Widgets
	 */
	
	public YesNoPresenter createYesNoWidget() {
		return new YesNoPresenter(new YesNoWidget(this), getEventBus());
	}

	public EditSurveyPresenter createEditSurveyPage() {
		return new EditSurveyPresenter(new EditSurveyPage(this), getEventBus(), this);
	}

	@Override
	public FreeTextQuestionPresenter createFreeTextQuestionWidget() {
		return new EditableFreeTextQuestionPresenter(new EditableFreeTextQuestionWidget(this), getEventBus());
	}

	@Override
	public MultipleChoiceQuestionPresenter createMultipleChoiceQuestionWidget() {
		return new EditableMultipleChoiceQuestionPresenter(new EditableMultipleChoiceQuestionWidget(this), getEventBus());
	}

	/*
	 * (Other) widgets
	 */
	
	public Label createSurveyLabel(String text) {
		return new EditableLabel(text);
	}
	
	public SelectQuestionTypePresenter createSelectQuestionTypeWidget() {
		return new SelectQuestionTypePresenter(new SelectQuestionTypeWidget(), getEventBus(), this);
	}
}
