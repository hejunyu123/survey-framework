package edu.vwa.easyfeedback.client.common.model;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

public class SurveyElement implements Serializable {
	private static final long serialVersionUID = -8222155757625578310L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String key;

	private List<Question> questions;

	public String getKey() {
		return key;
	}

	/**
	 * @deprecated Question now extends SurveyElement
	 * @return
	 */
	public List<Question> getQuestions() {
		return questions;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}
