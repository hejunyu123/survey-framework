package edu.vwa.easyfeedback.client.admin.widget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;

import edu.vwa.easyfeedback.client.common.model.MultipleChoiceOption;
import edu.vwa.easyfeedback.client.common.presenter.EventBus;
import edu.vwa.easyfeedback.client.fillout.widget.MultipleChoiceQuestionPresenter;

public class EditableMultipleChoiceQuestionPresenter extends MultipleChoiceQuestionPresenter {

	public EditableMultipleChoiceQuestionPresenter(EditableMultipleChoiceQuestionPresenter.Display display,
			EventBus eventBus) {
		super(display, eventBus);
		
		// Add a "Add option" event handler
		display.getBtnAddOption().addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				try {
					MultipleChoiceOption newOption = new MultipleChoiceOption();
					getModel().getOptions().add(newOption);
					load(getModel());
				} catch (Exception e) {
					
				}
			}
		});
	}

	public interface Display extends MultipleChoiceQuestionPresenter.Display {
		public HasClickHandlers getBtnAddOption();
		public int getMaxOptions();
	}

}
