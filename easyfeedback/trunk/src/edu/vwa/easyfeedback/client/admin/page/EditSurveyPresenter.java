package edu.vwa.easyfeedback.client.admin.page;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.vwa.easyfeedback.client.admin.AdminModuleFactory;
import edu.vwa.easyfeedback.client.admin.widget.SelectQuestionTypePresenter;
import edu.vwa.easyfeedback.client.common.page.BaseSurveyPresenter;
import edu.vwa.easyfeedback.client.common.presenter.EventBus;

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
				// TODO Auto-generated method stub
				// Save survey
			}
		});
	}

	@Override
	public String getPlace() {
		return "edit";
	}	

}
