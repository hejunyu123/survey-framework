package edu.vwa.easyfeedback.client.fillout;

import edu.vwa.easyfeedback.client.common.model.FreeTextQuestion;
import edu.vwa.easyfeedback.client.common.model.MultipleChoiceQuestion;
import edu.vwa.easyfeedback.client.common.model.Question;
import edu.vwa.easyfeedback.client.common.model.YesNoQuestion;
import edu.vwa.easyfeedback.client.common.presenter.DefaultEventBus;
import edu.vwa.easyfeedback.client.common.presenter.EventBus;
import edu.vwa.easyfeedback.client.fillout.page.FillOutSurveyPage;
import edu.vwa.easyfeedback.client.fillout.page.FillOutSurveyPresenter;
import edu.vwa.easyfeedback.client.fillout.widget.FreeTextQuestionPresenter;
import edu.vwa.easyfeedback.client.fillout.widget.FreeTextQuestionWidget;
import edu.vwa.easyfeedback.client.fillout.widget.MultipleChoiceQuestionPresenter;
import edu.vwa.easyfeedback.client.fillout.widget.MultipleChoiceQuestionWidget;
import edu.vwa.easyfeedback.client.fillout.widget.YesNoPresenter;
import edu.vwa.easyfeedback.client.fillout.widget.YesNoWidget;

public class FillOutModuleFactory {

	
	private static final FillOutModuleFactory instance = new FillOutModuleFactory();	
	
	public FillOutModuleFactory() {
		super();
	}

	/**
	 * Singleton method.
	 * @return the instance
	 */
	public static FillOutModuleFactory get() {
		return instance;
	}
	
	/**
	 * Use this event bus for application events.
	 * @return The event bus
	 */
	public EventBus getEventBus() {
		return DefaultEventBus.get();
	}
	
	/**
	 * Statically creates presenter instances depending on a given model class.
	 * TODO better use dependency injection with GIN here.
	 * @param modelClass A model class for a survey question
	 * @return The instanciated presenter
	 */
	public Object createPresenterFor(Class<? extends Question> modelClass) {
		
		if (modelClass.equals(YesNoQuestion.class)) {
			return createYesNoWidget();
		} else if (modelClass.equals(FreeTextQuestion.class)) {
			return createFreeTextQuestionWidget();
		} else if (modelClass.equals(MultipleChoiceQuestion.class)) {
			return createMultipleChoiceQuestionWidget();
		}
		return null;			
	}

	
	public FillOutSurveyPresenter createFillOutSurveyPage() {
		FillOutSurveyPresenter presenter = new FillOutSurveyPresenter(new FillOutSurveyPage(), getEventBus());
		return presenter;
	}
	
	public YesNoPresenter createYesNoWidget() {
		return new YesNoPresenter(new YesNoWidget(), getEventBus());
	}
	
	public FreeTextQuestionPresenter createFreeTextQuestionWidget() {
		return new FreeTextQuestionPresenter(new FreeTextQuestionWidget(), getEventBus());
	}
	
	public MultipleChoiceQuestionPresenter createMultipleChoiceQuestionWidget() {
		return new MultipleChoiceQuestionPresenter(new MultipleChoiceQuestionWidget(), getEventBus());
	}

}
