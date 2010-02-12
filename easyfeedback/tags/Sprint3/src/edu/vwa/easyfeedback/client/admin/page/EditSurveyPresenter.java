package edu.vwa.easyfeedback.client.admin.page;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.vwa.easyfeedback.client.admin.AdminModuleFactory;
import edu.vwa.easyfeedback.client.admin.widget.SelectQuestionTypePresenter;
import edu.vwa.easyfeedback.client.common.event.ShowPageEvent;
import edu.vwa.easyfeedback.client.common.page.BaseSurveyPresenter;
import edu.vwa.easyfeedback.client.common.presenter.EventBus;
import edu.vwa.easyfeedback.client.common.service.PersistenceServiceAsync;

public class EditSurveyPresenter extends BaseSurveyPresenter<EditSurveyPresenter.Display> {

	public EditSurveyPresenter(Display display, EventBus eventBus, AdminModuleFactory factory) {
		super(display, eventBus, factory);
	}

	public interface Display extends BaseSurveyPresenter.Display {
		public InsertPanel asPanel();
	}
	
	@Override
	public void init() {
		super.init();		
			SelectQuestionTypePresenter selectQuestion = ((AdminModuleFactory)getFactory()).createSelectQuestionTypeWidget();
		selectQuestion.setTarget(this);
		getDisplay().asPanel().insert(selectQuestion.getDisplay().asWidget(), getDisplay().asPanel().getWidgetIndex((Widget)getDisplay().getBtnMakePersistent()));
		
		getDisplay().getBtnMakePersistent().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				PersistenceServiceAsync ps = ((AdminModuleFactory)getFactory()).getPersistanceService();
				ps.saveSurvey(getModel(), new AsyncCallback<Void>() {

					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					public void onSuccess(Void result) {
						final DialogBox d = new DialogBox();
						d.setText("Survey saved successfully!");
						Button ok = new Button("OK");
						ok.addClickHandler(new ClickHandler() {
							public void onClick(ClickEvent event) {
								getEventBus().fireEvent(new ShowPageEvent("selectsurvey"));	
								d.hide();
								d.removeFromParent();
							}
						});
						d.setWidget(ok);

						d.center();
						d.show();						
					}
				});
			}
		});
	}

	@Override
	public String getPlace() {
		return "edit-survey";
	}	

}
