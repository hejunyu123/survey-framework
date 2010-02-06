package edu.vwa.easyfeedback.client.admin.page;

import java.util.Iterator;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;

import edu.vwa.easyfeedback.client.admin.AdminModuleFactory;
import edu.vwa.easyfeedback.client.admin.event.ShowSurveyEvent;
import edu.vwa.easyfeedback.client.admin.widget.SurveyOptionsPresenter;
import edu.vwa.easyfeedback.client.common.model.Survey;
import edu.vwa.easyfeedback.client.common.presenter.EventBus;
import edu.vwa.easyfeedback.client.common.presenter.PagePresenter;
import edu.vwa.easyfeedback.client.common.presenter.WidgetDisplay;

public class SelectSurveyPresenter extends PagePresenter<SelectSurveyPresenter.Display> {

	public interface Display extends WidgetDisplay {
		public HasValue<String> getIdBox();
		public HasClickHandlers getBtnSubmit();
		public void showSubmitError(String errorText);
		public HasWidgets getSurveyOptions();
	}

	public SelectSurveyPresenter(Display display, EventBus eventBus) {
		super(display, eventBus);
		init();
	}

	private void init() {
		getDisplay().getBtnSubmit().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				getEventBus().fireEvent(new ShowSurveyEvent(
						getDisplay().getIdBox().getValue())
				);				
			}
			
		});
	}
	
	private void loadSurveys(Iterable<Survey> surveys)
	{
		getDisplay().getSurveyOptions().clear();
		if (surveys == null) return;
		
		Iterator<Survey> iterator = surveys.iterator();
		while (iterator.hasNext())
		{
			SurveyOptionsPresenter presenter = AdminModuleFactory.get().createSurveyOptionsWidget();
			presenter.setSurvey(iterator.next());
			getDisplay().getSurveyOptions().add(presenter.getDisplay().asWidget());
		}
	}

	@Override
	public String getPlace() {
		return "selectsurvey";
	}

	@Override
	public void onShow() {
		super.onShow();
		getDisplay().getIdBox().setValue("");
	}

}
