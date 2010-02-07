package edu.vwa.easyfeedback.client.admin.widget;

import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.History;
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

	public void onShow() {
		getDisplay().getName().setText(survey.getCaption());
		
		getDisplay().getShowClickHandlers().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				getEventBus().fireEvent(new ShowSurveyEvent(survey.getName()));
				History.newItem(survey.getName(), false);
			}
		});
		
		getDisplay().getDeleteClickHandlers().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				PersistenceServiceAsync db = AdminModuleFactory.get().getPersistanceService();
				db.deleteSurvey(survey, new AsyncCallback<Void>() {

					public void onFailure(Throwable caught) {
						onShow();
					}

					public void onSuccess(Void result) {
						onShow();
					}
				});
			}
		});
		
		if (survey.getPublishedAt() == null)
		{
			getDisplay().getPublishClickHandlers().addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					survey.setPublishedAt(new Date());
					PersistenceServiceAsync db = AdminModuleFactory.get().getPersistanceService();
					db.saveSurvey(survey, new AsyncCallback<Void>() {

						public void onFailure(Throwable caught) {
							onShow();
						}

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
				public void onClick(ClickEvent event) {
					
				}
			});
			getDisplay().setPublishVisible(false);
		}
	}
}
