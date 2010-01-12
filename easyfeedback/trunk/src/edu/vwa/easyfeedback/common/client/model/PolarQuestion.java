package edu.vwa.easyfeedback.common.client.model;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class PolarQuestion extends Question {
	private static final long serialVersionUID = 4696679986407824387L;
	@Persistent
	private Boolean isCheckBox; // Maybe an enum would be a better solution..

	public Boolean getIsCheckBox() {
		return isCheckBox;
	}

	public Boolean getIsRadioBox() {
		return !isCheckBox;
	}

	public void setIsCheckBox(Boolean value) {
		this.isCheckBox = value;
	}

	public void setIsRadioBox(Boolean value) {
		this.isCheckBox = !value;
	}
}