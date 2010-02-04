package edu.vwa.easyfeedback.client.admin.widget;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasText;

import edu.vwa.easyfeedback.client.common.QuestionPresenterFactory;
import edu.vwa.easyfeedback.client.fillout.widget.FreeTextQuestionWidget;

/**
 * Display for {@link EditableFreeTextPresenter.Display}. 
 * @author fleerkoetter
 *
 */
public class EditableFreeTextQuestionWidget extends FreeTextQuestionWidget implements EditableFreeTextQuestionPresenter.Display {

	private Button btnExpand;

	public EditableFreeTextQuestionWidget(QuestionPresenterFactory factory) {
		super(factory);
		
		btnExpand = new Button("Expand");
		getElementsContainer().add(btnExpand);
	}
	
	public HasClickHandlers getBtnExpand() {
		return btnExpand;
	}

	public HasText getBtnExpandText() {
		return btnExpand;
	}

}
