package edu.vwa.easyfeedback.client.common.model;

/**
 * Question which's answering choices are only "Yes" or "No".
 * Type is for definition purpose only.
 * @author fleerkoetter
 *
 */
public class YesNoQuestion extends Question {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2668360878822132101L;
	private boolean isYes;
	
	public boolean getIsYes() {
		return isYes;
	}
	
}
