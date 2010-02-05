package edu.vwa.easyfeedback.client.common.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.vwa.easyfeedback.client.common.model.Survey;
import edu.vwa.easyfeedback.client.common.model.SurveyUser;

/**
 * Es wäre evtl. eine gute Idee einen generischen Service für Create Read Update Delete zu machen.
 * Zum Bsp: CrudService<Serializable T> mit create(T model), load(Serializable id), update(T model), delete (T model)...
 * Weiß nur nicht wie das dann mit der Authorization funktionieren würde...
 */
@RemoteServiceRelativePath("persist")
public interface PersistenceService extends RemoteService {
	/**
	 * Loads a Survey from a datastore.
	 * @param name Survey name serves as a primary key.
	 * @return The survey with the given name, or void, if that survey doesn't exist
	 */
	public Survey getSurvey(String name);
	
	/**
	 * Loads all surveys owned by a specified user from the datastore.
	 * @return All surveys owned by the specified user.
	 */
	public Iterable<Survey> getSurveysByUser(SurveyUser user);
	
	/**
	 * Saves or updates a survey to a datastore.
	 * @param survey The survey to persist
	 */
	public void saveSurvey(Survey survey);
	
	/**
	 * Deletes a survey from the datastore.
	 * @param survey The survey to delete
	 */
	public void deleteSurvey(Survey survey);
}
