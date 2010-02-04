package edu.vwa.easyfeedback.client.admin.widget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;

import edu.vwa.easyfeedback.client.common.presenter.EventBus;
import edu.vwa.easyfeedback.client.fillout.widget.FreeTextQuestionPresenter;

/**
 * Presents a FreeTextQuestion for editing, i.e. the user can set wether it's a multi-line text question or not.
 * @author fleerkoetter
 *
 */
public class EditableFreeTextQuestionPresenter extends
		FreeTextQuestionPresenter {
	
	private boolean isExpanded = false;

	@Override
	public Display getDisplay() {
		return (Display)super.getDisplay();
	}

	public EditableFreeTextQuestionPresenter(Display display, EventBus eventBus) {
		super(display, eventBus);
		
		getDisplay().getBtnExpand().addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				setMultiLine(!isExpanded());
			}
		});
	}
	
	public interface Display extends FreeTextQuestionPresenter.Display {
		public HasClickHandlers getBtnExpand();
		public HasText getBtnExpandText();
	}

	@Override
	protected void setMultiLine(boolean value) {
		super.setMultiLine(value);
		this.isExpanded = value;
		getDisplay().getBtnExpandText().setText(value ? "Shorten answering space for respondent" : "Expand answering space for respondent");
	}


	public boolean isExpanded() {
		return isExpanded;
	}

}
