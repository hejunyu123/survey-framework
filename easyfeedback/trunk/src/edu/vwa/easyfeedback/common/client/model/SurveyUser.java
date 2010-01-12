package edu.vwa.easyfeedback.common.client.model;

import java.io.Serializable;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

public class SurveyUser implements Serializable {
	private static final long serialVersionUID = 3385504694203956156L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String key;

	@Persistent
	private String email;

	public String getEmail() {
		return email;
	}

	public String getKey() {
		return key;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
