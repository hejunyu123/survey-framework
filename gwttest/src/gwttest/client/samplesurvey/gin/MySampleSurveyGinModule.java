package gwttest.client.samplesurvey.gin;

import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;
import gwttest.client.samplesurvey.MySampleSurveyPage;
import gwttest.client.samplesurvey.MySampleSurveyPresenter;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class MySampleSurveyGinModule extends AbstractGinModule {

	/**
	 * Declares dependencies of samplesurvey
	 */
	@Override
	protected void configure() {
		// Use EventBus
		bind(EventBus.class).to(DefaultEventBus.class);
		
		bind(MySampleSurveyPresenter.Display.class).to(MySampleSurveyPage.class);
	}

}
