package edu.vwa.easyfeedback.client.common.model;

import java.io.Serializable;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

public class MultipleChoiceOption implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3337937758429734466L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	@Extension(vendorName = "datanucleus", key = "gae.encoded-pk", value = "true")
	private String key;

	@Persistent
	private String name = "";
	
	@Persistent
	private String caption = "";

	@Persistent
	private boolean value = false;
	
	public MultipleChoiceOption() {
	}
	
	public MultipleChoiceOption(String caption) {
		setCaption(caption);
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setCaption(String caption) {
		this.caption = caption;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}

	public String getName() {
		return name;
	}	
	
	public String getCaption() {
		return caption;
	}

	public boolean getValue() {
		return value;
	}

}
