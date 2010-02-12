package edu.vwa.easyfeedback.client.admin.page;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Label;

import edu.vwa.easyfeedback.client.admin.AdminModuleFactory;
import edu.vwa.easyfeedback.client.admin.event.ShowSurveyEvent;
import edu.vwa.easyfeedback.client.admin.service.LoginInfo;
import edu.vwa.easyfeedback.client.admin.widget.SurveyOptionsPresenter;
import edu.vwa.easyfeedback.client.common.event.LoginHandler;
import edu.vwa.easyfeedback.client.common.model.Survey;
import edu.vwa.easyfeedback.client.common.presenter.EventBus;
import edu.vwa.easyfeedback.client.common.presenter.PagePresenter;
import edu.vwa.easyfeedback.client.common.presenter.WidgetDisplay;

public class SelectSurveyPresenter extends PagePresenter<SelectSurveyPresenter.Display> {

	public interface Display extends WidgetDisplay {
		public HasValue<String> getIdBox();
		public HasClickHandlers getBtnSubmit();
		public HasWidgets getSurveyOptions();
		public HasClickHandlers getNewSurveyBtn();
		public HasText getErrorText();
		public void setSurveyBtnVisible(boolean visible);
	}

	public SelectSurveyPresenter(Display display, EventBus eventBus) {
		super(display, eventBus);
		init();
	}

	private void init() {
		AdminModuleFactory.get().getLoginService().login("", new AsyncCallback<LoginInfo>() {
			public void onFailure(Throwable caught) {
				showError(caught.getMessage());
			}
			public void onSuccess(LoginInfo result) {
				loadAdminFeatures(result);
			}
		});
		
		getEventBus().addHandler(new Type<LoginHandler>(), new LoginHandler(){
			public void onLoginStatusChanged(LoginInfo loginInfo) {
				loadAdminFeatures(loginInfo);
			}});
		
		getDisplay().getBtnSubmit().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				getEventBus().fireEvent(new ShowSurveyEvent(
						getDisplay().getIdBox().getValue())
				);				
			}
		});
	}
	
	private void loadAdminFeatures(LoginInfo loginInfo)
	{
		if (loginInfo.isLoggedIn())
		{
			AdminModuleFactory.get().getPersistanceService().getSurveys(new AsyncCallback<Survey[]>() {
				public void onFailure(Throwable caught) {
					showError(caught.getMessage());
				}
				public void onSuccess(Survey[] result) {
					loadSurveys(result);
				}
			});
			
			getDisplay().getNewSurveyBtn().addClickHandler(new ClickHandler() {

				public void onClick(ClickEvent event) {
					AdminModuleFactory.get().getPersistanceService().createSurvey("", "", new AsyncCallback<Survey>(){
						public void onFailure(Throwable caught) {
							showError(caught.getMessage());
						}
						public void onSuccess(Survey result) {
							getEventBus().fireEvent(new ShowSurveyEvent(result.getName()));		
						}}
					);
				}
				
			});
			
			getDisplay().getErrorText().setText("");
			getDisplay().setSurveyBtnVisible(true);
		}
		else
		{
			getDisplay().setSurveyBtnVisible(false);
			loadSurveys(null);
			getDisplay().getErrorText().setText("Please login first!");
		}
	}
	
	private void loadSurveys(Survey[] surveys)
	{
		getDisplay().getSurveyOptions().clear();
		if (surveys == null) return;
		
		for (Survey survey : surveys)
		{
			SurveyOptionsPresenter presenter = AdminModuleFactory.get().createSurveyOptionsWidget();
			presenter.setSurvey(survey);
			getDisplay().getSurveyOptions().add(presenter.getDisplay().asWidget());
			presenter.onShow();
		}
	}
	
	private void showError(String message) {
		DialogBox b = new DialogBox();
		b.add(new Label(message));
		b.show();
	}

	@Override
	public String getPlace() {
		return "selectsurvey";
	}

	@Override
	public void onShow() {
		super.onShow();
		init();
		getDisplay().getIdBox().setValue("");
	}

}
