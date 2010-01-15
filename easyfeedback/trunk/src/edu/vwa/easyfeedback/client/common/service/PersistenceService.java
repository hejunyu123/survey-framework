package edu.vwa.easyfeedback.client.common.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.vwa.easyfeedback.client.common.model.Survey;

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
