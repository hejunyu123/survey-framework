package edu.vwa.easyfeedback.client.common.service;

public class SurveyNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7675355249183140260L;
	
	public SurveyNotFoundException() {
		super("Survey does not exist");
	}

	public SurveyNotFoundException(String surveyId) {
		super("Survey with id '" + surveyId + "' does not exist");
	}

}
