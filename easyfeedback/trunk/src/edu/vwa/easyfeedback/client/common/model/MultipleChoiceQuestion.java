package edu.vwa.easyfeedback.client.common.model;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class MultipleChoiceQuestion extends Question {
	private static final long serialVersionUID = -1239708544240560505L;
	
	public static final Class<MultipleChoiceOption> OPTION = MultipleChoiceOption.class;

	@Persistent
	private Integer maxOptions;

	@Persistent
	private List<MultipleChoiceOption> options;
	
	public MultipleChoiceQuestion() {
		this.options = new ArrayList<MultipleChoiceOption>();
	}

	public Integer getMaxOptions() {
		return maxOptions;
	}

	public List<MultipleChoiceOption> getSelectedOptions() {
		return getOptions();
	}

	public void setMaxOptions(Integer maxOptions) {
		this.maxOptions = maxOptions;
	}

//	public void setSelectedOptions(List<MultipleChoiceOption> options) {
////		this.setOptions(selectedOptions);
//	}

//	public void setOptions(List<MultipleChoiceOption> options) {
//		this.options = options;
//	}

	public List<MultipleChoiceOption> getOptions() {
		return options;
	}
}
