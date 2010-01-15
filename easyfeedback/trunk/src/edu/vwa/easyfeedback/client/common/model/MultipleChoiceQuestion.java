package edu.vwa.easyfeedback.client.common.model;

import java.util.List;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class MultipleChoiceQuestion extends Question {
	private static final long serialVersionUID = -1239708544240560505L;

	@Persistent
	private Integer maxOptions;

	@Persistent
	private List<MultipleChoiseOption> selectedOptions;

	public Integer getMaxOptions() {
		return maxOptions;
	}

	public List<MultipleChoiseOption> getSelectedOptions() {
		return selectedOptions;
	}

	public void setMaxOptions(Integer maxOptions) {
		this.maxOptions = maxOptions;
	}

	public void setSelectedOptions(List<MultipleChoiseOption> selectedOptions) {
		this.selectedOptions = selectedOptions;
	}
}
