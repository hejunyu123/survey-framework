package gwttest.client.samplesurvey.model;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class FreeTextAnswer extends Answer {
	private static final long serialVersionUID = 1763876178370043129L;
	@Persistent
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
