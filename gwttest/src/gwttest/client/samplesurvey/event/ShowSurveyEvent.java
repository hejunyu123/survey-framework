package gwttest.client.samplesurvey.event;

import com.google.gwt.event.shared.GwtEvent;

public class ShowSurveyEvent extends GwtEvent<ShowSurveyHandler> {
	
	public static Type<ShowSurveyHandler> TYPE = new Type<ShowSurveyHandler>();
	
	private final String surveyID;
	
	public ShowSurveyEvent(String surveyID) {
		this.surveyID = surveyID;
	}

	@Override
	protected void dispatch(ShowSurveyHandler handler) {
		handler.onShowSurvey(surveyID);
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ShowSurveyHandler> getAssociatedType() {
		return TYPE;		
	}

}
