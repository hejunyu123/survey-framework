package edu.vwa.easyfeedback.client.common;

import com.google.gwt.user.client.ui.Label;

import edu.vwa.easyfeedback.client.common.model.FreeTextQuestion;
import edu.vwa.easyfeedback.client.common.model.MultipleChoiceQuestion;
import edu.vwa.easyfeedback.client.common.model.Question;
import edu.vwa.easyfeedback.client.common.model.YesNoQuestion;
import edu.vwa.easyfeedback.client.common.presenter.DefaultEventBus;
import edu.vwa.easyfeedback.client.common.presenter.EventBus;
import edu.vwa.easyfeedback.client.fillout.widget.FreeTextQuestionPresenter;
import edu.vwa.easyfeedback.client.fillout.widget.MultipleChoiceQuestionPresenter;
import edu.vwa.easyfeedback.client.fillout.widget.YesNoPresenter;

public abstract class QuestionPresenterFactory {
	
	
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
	
	public abstract Label createSurveyLabel(String text);
	
	public abstract YesNoPresenter createYesNoWidget();

	public abstract FreeTextQuestionPresenter createFreeTextQuestionWidget();

	public abstract MultipleChoiceQuestionPresenter createMultipleChoiceQuestionWidget();

}