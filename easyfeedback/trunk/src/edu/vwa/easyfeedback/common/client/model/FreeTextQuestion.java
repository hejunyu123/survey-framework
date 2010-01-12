package edu.vwa.easyfeedback.common.client.model;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class FreeTextQuestion extends Question {
	private static final long serialVersionUID = -1056052722359250876L;
	@Persistent
	private Boolean isMultiLineText; // Maybe an enum would be a better

	// solution..

	public Boolean getIsMultiLineText() {
		return isMultiLineText;
	}

	public void setIsMultiLineText(Boolean isMultiLineText) {
		this.isMultiLineText = isMultiLineText;
	}
}
