package edu.vwa.easyfeedback.client.common.model;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class FreeTextQuestion extends Question {
	private static final long serialVersionUID = -1056052722359250876L;
	
	@Persistent
	private boolean isMultiLineText; // Maybe an enum would be a better
	
	@Persistent
	private String text = "";

	// solution..

	public boolean getIsMultiLineText() {
		return isMultiLineText;
	}

	public void setIsMultiLineText(boolean isMultiLineText) {
		this.isMultiLineText = isMultiLineText;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	
	
}
