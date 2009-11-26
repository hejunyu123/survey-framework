package gwttest.client.samplesurvey.service;

import gwttest.client.samplesurvey.model.Survey;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("persist")
public interface PersistenceService extends RemoteService {
	/**
	 * Loads a Survey from a datastore.
	 * @param name Survey name serves as a primary key.
	 * @return The survey with the given name, or void, if that survey doesn't exist
	 */
	public Survey getSurvey(String name);
	
	/**
	 * Saves or updates a survey to a datastore.
	 * @param survey The survey to persist
	 */
	public void saveSurvey(Survey survey);
}
