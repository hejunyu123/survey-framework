package gwttest.client.samplesurvey.model;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

public class Survey implements Serializable {
    /**
	 * Generated serial ID
	 */
	private static final long serialVersionUID = 881287580798933082L;
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private String name;	
	
	@Persistent
	private String caption;
	
	@Persistent
	private String description;
	
	public Survey() {
		caption = "";
		description = "";
	}
	
	public Survey(String description, String caption) {
		this.description = description;
		this.caption = caption;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	public String getCaption() {
		return caption;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
