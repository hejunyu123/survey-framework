package edu.vwa.easyfeedback.client.common.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.vwa.easyfeedback.client.common.model.Survey;

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
	public Iterable<Survey> getSurveys();
	
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
	
	/**
	 * Creates a new Survey for the current user.
	 * @param survey The survey to delete
	 * @throws NotAuthorizedException 
	 */
	public Survey createSurvey(String caption, String description) throws NotAuthorizedException;
}
