package gwttest.client;

import com.google.gwt.user.client.History;

import gwttest.client.presenter.DefaultEventBus;
import gwttest.client.presenter.EventBus;
import gwttest.client.samplesurvey.MySampleSurveyPage;
import gwttest.client.samplesurvey.MySampleSurveyPresenter;
import gwttest.client.samplesurvey.SelectSurveyPage;
import gwttest.client.samplesurvey.SelectSurveyPresenter;
import gwttest.client.samplesurvey.widget.survey.YesNoPresenter;
import gwttest.client.samplesurvey.widget.survey.YesNoWidget;

public class GwttestFactory {
	
	private static final GwttestFactory instance = new GwttestFactory();

	/**
	 * Singleton method.
	 * @return the instance
	 */
	public static GwttestFactory get() {
		return instance;
	}
	
	public EventBus getEventBus() {
		return DefaultEventBus.get();
	}
	
	public MySampleSurveyPresenter createMySampleSurveyPage() {
		MySampleSurveyPresenter presenter = new MySampleSurveyPresenter(new MySampleSurveyPage(), getEventBus());
		History.addValueChangeHandler(presenter);
		return presenter;
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
