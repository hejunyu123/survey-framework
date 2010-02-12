package edu.vwa.easyfeedback.client.common.model;

import java.io.Serializable;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable="true")
public class SurveyUser implements Serializable {
	private static final long serialVersionUID = 3385504694203956156L;

	/**
	 * Encoded string mit internem GAE-Key. Ist nštig, damit die Beziehung zu {@link Survey} mšglich ist.
	 */
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    @Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
	private String key;

	@Persistent
//	@Extension(vendorName="datanucleus", key="gae.pk-name", value="true")
	private String email = "";

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}


}
