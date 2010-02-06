package gwttest.client.samplesurvey.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

public class SurveyResponse implements Serializable {
	private static final long serialVersionUID = 6882694252233011509L;

	@Persistent
	private List<Answer> answers;

	@Persistent
	private Date completedAt;

	@Persistent
	private Date createdAt;

	@Persistent
	private Integer daysValid;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String key;

	@Persistent
	private String token;

	public List<Answer> getAnswers() {
		return answers;
	}

	public Date getCompletedAt() {
		return completedAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Integer getDaysValid() {
		return daysValid;
	}

	public String getKey() {
		return key;
	}

	public String getToken() {
		return token;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public void setCompletedAt(Date completedAt) {
		this.completedAt = completedAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDaysValid(Integer daysValid) {
		this.daysValid = daysValid;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
