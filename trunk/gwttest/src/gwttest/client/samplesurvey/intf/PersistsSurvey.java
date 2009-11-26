package gwttest.client.samplesurvey.intf;

import gwttest.client.samplesurvey.model.Survey;

public interface PersistsSurvey {

	public abstract void load(Survey survey);

	public abstract Survey save();

}