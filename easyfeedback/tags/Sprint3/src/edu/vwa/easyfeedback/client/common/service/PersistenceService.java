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
	 * @return The survey with the given name, or null, if that survey doesn't exist
	 * @throws SurveyNotFoundException Survey of given name does not exist
	 */
	public Survey getSurvey(String name) throws SurveyNotFoundException;
	
	/**
	 * Loads all surveys owned by a specified user from the datastore.
	 * @return All surveys owned by the specified user or null, if no user logged in
	 * @throws NotAuthorizedException 
	 */
	public Survey[] getSurveys() throws NotAuthorizedException;
	
	/**
	 * Saves or updates a survey to a datastore.
	 * @param survey The survey to persist
	 * @throws NotAuthorizedException 
	 */
	public void saveSurvey(Survey survey) throws NotAuthorizedException;
	
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
	
	public SurveyUser getSurveyUser(String email);
	
	public void saveSurveyUser(SurveyUser user);
}
