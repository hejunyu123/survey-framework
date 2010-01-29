package edu.vwa.easyfeedback.client.admin.widget;

import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasText;

import edu.vwa.easyfeedback.client.admin.AdminModuleFactory;
import edu.vwa.easyfeedback.client.admin.event.ShowSurveyEvent;
import edu.vwa.easyfeedback.client.common.model.Survey;
import edu.vwa.easyfeedback.client.common.presenter.EventBus;
import edu.vwa.easyfeedback.client.common.presenter.MyPresenter;
import edu.vwa.easyfeedback.client.common.presenter.WidgetDisplay;
import edu.vwa.easyfeedback.client.common.service.PersistenceServiceAsync;

public class SurveyOptionsPresenter extends MyPresenter<SurveyOptionsPresenter.Display> {
	private Survey survey;
	
	public SurveyOptionsPresenter(Display display, EventBus eventBus) {
		super(display, eventBus);
		// TODO Auto-generated constructor stub
	}

	public interface Display extends WidgetDisplay {
		public HasText getName();
		public HasClickHandlers getShowClickHandlers();
		public HasClickHandlers getDeleteClickHandlers();
		public HasClickHandlers getPublishClickHandlers();
		public HasClickHandlers getTakeClickHandlers();
		public void setPublishVisible(boolean visible);
		public void setTakeVisible(boolean visible);
	}

	public void setSurvey(Survey survey)
	{
		this.survey = survey;
	}
	
	@Override
	public String getPlace() {
		return "survey-options";
	}

	@Override
	public void onShow() {
		getDisplay().getName().setText(survey.getCaption());
		
		getDisplay().getShowClickHandlers().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				getEventBus().fireEvent(new ShowSurveyEvent(survey.getName()));
			}
		});
		
		getDisplay().getDeleteClickHandlers().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				
				//DialogBox dialog = new DialogBox();
				//dialog.setTitle("Umfrage lšschen?");
				//dialog.setText("Mšchten Sie diese Umfrage und alle Antworten lšschen?");
				//dialog.show();
			}
		});
		
		if (survey.getPublishedAt() == null)
		{
			getDisplay().getPublishClickHandlers().addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					survey.setPublishedAt(new Date());
					PersistenceServiceAsync db = AdminModuleFactory.get().getPersistanceService();
					db.saveSurvey(survey, new AsyncCallback<Void>() {

						@Override
						public void onFailure(Throwable caught) {
							onShow();
						}

						@Override
						public void onSuccess(Void result) {
							onShow();
						}
						
					});
				}
			});
			getDisplay().setTakeVisible(false);
		}
		else
		{
			getDisplay().getTakeClickHandlers().addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					
				}
			});
			getDisplay().setPublishVisible(false);
		}
	}
}
