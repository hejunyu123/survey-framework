package edu.vwa.easyfeedback.client.fillout;

import com.google.gwt.user.client.ui.Label;

import edu.vwa.easyfeedback.client.common.QuestionPresenterFactory;
import edu.vwa.easyfeedback.client.fillout.page.FillOutSurveyPage;
import edu.vwa.easyfeedback.client.fillout.page.FillOutSurveyPresenter;
import edu.vwa.easyfeedback.client.fillout.widget.FreeTextQuestionPresenter;
import edu.vwa.easyfeedback.client.fillout.widget.FreeTextQuestionWidget;
import edu.vwa.easyfeedback.client.fillout.widget.MultipleChoiceQuestionPresenter;
import edu.vwa.easyfeedback.client.fillout.widget.MultipleChoiceQuestionWidget;
import edu.vwa.easyfeedback.client.fillout.widget.YesNoPresenter;
import edu.vwa.easyfeedback.client.fillout.widget.YesNoWidget;

public class FillOutModuleFactory extends QuestionPresenterFactory {

	
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
	
	public FillOutSurveyPresenter createFillOutSurveyPage() {
		FillOutSurveyPresenter presenter = new FillOutSurveyPresenter(new FillOutSurveyPage(this), getEventBus(), this);
		return presenter;
	}
	
	/* (non-Javadoc)
	 * @see edu.vwa.easyfeedback.client.fillout.QuestionPresenterFactory#createYesNoWidget()
	 */
	public YesNoPresenter createYesNoWidget() {
		return new YesNoPresenter(new YesNoWidget(this), getEventBus());
	}
	
	/* (non-Javadoc)
	 * @see edu.vwa.easyfeedback.client.fillout.QuestionPresenterFactory#createFreeTextQuestionWidget()
	 */
	public FreeTextQuestionPresenter createFreeTextQuestionWidget() {
		return new FreeTextQuestionPresenter(new FreeTextQuestionWidget(this), getEventBus());
	}
	
	/* (non-Javadoc)
	 * @see edu.vwa.easyfeedback.client.fillout.QuestionPresenterFactory#createMultipleChoiceQuestionWidget()
	 */
	public MultipleChoiceQuestionPresenter createMultipleChoiceQuestionWidget() {
		return new MultipleChoiceQuestionPresenter(new MultipleChoiceQuestionWidget(this), getEventBus());
	}

	public Label createSurveyLabel(String text) {
		return new Label(text);
	}

}
