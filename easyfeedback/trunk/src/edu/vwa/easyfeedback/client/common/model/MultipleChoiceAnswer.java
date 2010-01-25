package edu.vwa.easyfeedback.client.common.model;

import java.util.List;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class MultipleChoiceAnswer extends Answer {

	private static final long serialVersionUID = -5664928827833400793L;
	@Persistent
	private List<MultipleChoiceOption> options;

	public List<MultipleChoiceOption> getOptions() {
		return options;
	}

	public void setOptions(List<MultipleChoiceOption> options) {
		this.options = options;
	}
}
