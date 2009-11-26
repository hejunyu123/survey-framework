package gwttest.client.samplesurvey.gin;

import net.customware.gwt.presenter.client.EventBus;
import gwttest.client.samplesurvey.MySampleSurveyPresenter;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

@GinModules(MySampleSurveyGinModule.class)
public interface MySampleSurveyGinjector extends Ginjector {
	MySampleSurveyPresenter getPagePresenter();
	EventBus getEventbus();
}
