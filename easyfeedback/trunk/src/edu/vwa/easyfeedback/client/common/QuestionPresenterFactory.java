package edu.vwa.easyfeedback.client.common;

import com.google.gwt.user.client.ui.Label;

import edu.vwa.easyfeedback.client.common.model.Question;

public interface QuestionPresenterFactory {

	/**
	 * Statically creates presenter instances depending on a given model class.
	 * TODO better use dependency injection with GIN here.
	 * @param modelClass A model class for a survey question
	 * @return The instanciated presenter
	 */
	public abstract Object createPresenterFor(
			Class<? extends Question> modelClass);
	
	public Label createSurveyLabel(String text);

}