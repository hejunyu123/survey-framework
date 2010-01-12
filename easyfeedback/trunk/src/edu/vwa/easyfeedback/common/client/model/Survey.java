package edu.vwa.easyfeedback.common.client.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

public class Survey implements Serializable {
	private static final long serialVersionUID = 881287580798933082L;

	@Persistent
	private String caption;

	@Persistent
	private Date createdAt;

	@Persistent
	private String description;

	@Persistent
	private List<SurveyElement> elements;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
//	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String name;

	@Persistent
	private Date publishedAt;

	@Persistent
	private List<SurveyResponse> responses;

	@Persistent
	private SurveyUser user;

	public Survey() {
		this("", null, "", "");
	}

	public Survey(String name, SurveyUser user, String description, String caption) {
		this.description = description;
		this.caption = caption;
		this.createdAt = new Date();
		this.name = name;
		this.user = user;
		
		this.elements = new ArrayList<SurveyElement>();
		this.responses = new ArrayList<SurveyResponse>();
	}

	public String getCaption() {
		return caption;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public String getDescription() {
		return description;
	}

	public List<SurveyElement> getElements() {
		return elements;
	}


	public String getName() {
		return name;
	}

	public Date getPublishedAt() {
		return publishedAt;
	}

	public List<SurveyResponse> getResponses() {
		return responses;
	}

	public SurveyUser getUser() {
		return user;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setElements(List<SurveyElement> elements) {
		this.elements = elements;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void setPublishedAt(Date publishedAt) {
		this.publishedAt = publishedAt;
	}

	public void setResponses(List<SurveyResponse> responses) {
		this.responses = responses;
	}

	public void setUser(SurveyUser user) {
		this.user = user;
	}
}
