package edu.vwa.easyfeedback.client.admin.widget;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;

import edu.vwa.easyfeedback.client.common.model.MultipleChoiceOption;
import edu.vwa.easyfeedback.client.common.presenter.EventBus;
import edu.vwa.easyfeedback.client.fillout.widget.MultipleChoiceQuestionPresenter;

/**
 * A presenter for an editable multiple choice question
 * @author fleerkoetter
 *
 */
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
		
		display.getBtnRemoveOption().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				int removedOptions = 0;
				for (int idx : getDisplay().getOptionsSelected()) {
					getDisplay().getElementsContainer().remove(idx-removedOptions);
					getModel().getOptions().remove(idx);
					
					removedOptions++;
				}
			}
			
		});
	}

	public interface Display extends MultipleChoiceQuestionPresenter.Display {
		public HasClickHandlers getBtnAddOption();
		public HasClickHandlers getBtnRemoveOption();
		public List<Integer> getOptionsSelected();
	}
	
	public Display getDisplay() {
		return (Display) this.display;
	}

}
