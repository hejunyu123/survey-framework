package edu.vwa.easyfeedback.client.common.model;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
@Inheritance(strategy = InheritanceStrategy.SUBCLASS_TABLE)
public abstract class Question implements Serializable {
	private static final long serialVersionUID = -3032677572801693979L;

	@Persistent
	private List<Answer> answers;

	@Persistent
	private String description;

	@Persistent
	private Boolean isOptional;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String key;

	public List<Answer> getAnswers() {
		return answers;
	}

	public String getDescription() {
		return description;
	}

	public Boolean getIsOptional() {
		return isOptional;
	}

	public String getKey() {
		return key;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setIsOptional(Boolean isOptional) {
		this.isOptional = isOptional;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
