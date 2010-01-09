package gwttest.client;

import gwttest.client.presenter.DefaultEventBus;
import gwttest.client.presenter.EventBus;
import gwttest.client.samplesurvey.MySampleSurveyPage;
import gwttest.client.samplesurvey.MySampleSurveyPresenter;
import gwttest.client.samplesurvey.SelectSurveyPage;
import gwttest.client.samplesurvey.SelectSurveyPresenter;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.History;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Gwttest implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";


	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {	
		// Construct pages and bind presenters to display
		// TODO This should be done via factories or DI
		EventBus bus = DefaultEventBus.get();
		
		MySampleSurveyPresenter mssp = new MySampleSurveyPresenter(new MySampleSurveyPage(), bus);
		History.addValueChangeHandler(mssp);
		
		SelectSurveyPresenter selectsurvey = new SelectSurveyPresenter(new SelectSurveyPage(), bus);
		History.addValueChangeHandler(selectsurvey);
		
//		RootPanel.get().add(new Hyperlink("Sample Survey", mssp.getPlace()));
		History.newItem(selectsurvey.getPlace(), true);
	}
}
