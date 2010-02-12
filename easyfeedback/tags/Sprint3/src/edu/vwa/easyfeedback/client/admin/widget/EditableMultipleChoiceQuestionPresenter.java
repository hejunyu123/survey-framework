package edu.vwa.easyfeedback.client.admin.widget;

import java.util.List;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.CheckBox;

import edu.vwa.easyfeedback.client.common.model.MultipleChoiceOption;
import edu.vwa.easyfeedback.client.common.model.MultipleChoiceQuestion;
import edu.vwa.easyfeedback.client.common.presenter.EventBus;
import edu.vwa.easyfeedback.client.fillout.widget.MultipleChoiceQuestionPresenter;

/**
 * A presenter for an editable multiple choice question
 * @author fleerkoetter
 *
 */
public class EditableMultipleChoiceQuestionPresenter extends MultipleChoiceQuestionPresenter {
	
	public interface Display extends MultipleChoiceQuestionPresenter.Display {
		public HasClickHandlers getBtnAddOption();
		public HasClickHandlers getBtnRemoveOption();
		public List<Integer> getOptionsSelected(); 
		public HasValueChangeHandlers<?> addOption(String caption, boolean value, String name);
		public int getMaxOptions();
		public void setMaxOptions(int value);
		public HasChangeHandlers getMaxOptionsChange();
	}
	
	private class MultipleChoiceOptionChangeHandler implements ValueChangeHandler<Boolean> {
		private MultipleChoiceOption model;

		public MultipleChoiceOptionChangeHandler(MultipleChoiceOption model) {
			this.model = model;
		}

		public void onValueChange(ValueChangeEvent<Boolean> event) {
			CheckBox elem = (CheckBox)event.getSource();
			model.setCaption(elem.getText());
		}
	}

	public EditableMultipleChoiceQuestionPresenter(EditableMultipleChoiceQuestionPresenter.Display display,
			EventBus eventBus) {
		super(display, eventBus);
		
		// Add a "Add option" event handler
		display.getBtnAddOption().addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				try {
					MultipleChoiceOption newOption = new MultipleChoiceOption();
					getModel().getOptions().add(newOption);
					load();
				} catch (Exception e) {
					
				}
			}
		});
		
		display.getBtnRemoveOption().addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
//				assert getDisplay().getElementsContainer().getWidgetCount() == getModel().getOptions().size();
				
				int removedOptions = 0;
				for (int idx : getDisplay().getOptionsSelected()) {
					try {
						getModel().getOptions().remove(idx);
						removedOptions++;
					} catch (Exception e) {
					}
				}
				load();
			}
			
		});
		
		display.getMaxOptionsChange().addChangeHandler(new ChangeHandler() {
			
			public void onChange(ChangeEvent event) {
				getModel().setMaxOptions(getDisplay().getMaxOptions());
			}
		});
	}
	
	@Override
	public void load(MultipleChoiceQuestion model) {
		super.load(model);
		
		assert getDisplay().getElementsContainer().getWidgetCount() == getModel().getOptions().size();
		
		for (int i = 0; i < getDisplay().getElementsContainer().getWidgetCount(); i++) {
			CheckBox elem = (CheckBox)getDisplay().getElementsContainer().getWidget(i);
			elem.addValueChangeHandler(new MultipleChoiceOptionChangeHandler(model.getOptions().get(i)));
		}
	}

	public Display getDisplay() {
		return (Display) this.display;
	}

}
