package gwttest.client;

import gwttest.client.samplesurvey.MySampleSurveyPresenter;
import gwttest.client.samplesurvey.SelectSurveyPresenter;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.History;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Gwttest implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {	
		// Construct pages and bind presenters to display		
		@SuppressWarnings("unused")
		MySampleSurveyPresenter mssp = GwttestFactory.get().createMySampleSurveyPage();
		SelectSurveyPresenter selectsurvey = GwttestFactory.get().createSelectSurveyPage();
		
		// Show Select Survey page at startup
		History.newItem(selectsurvey.getPlace(), true);
	}
}
