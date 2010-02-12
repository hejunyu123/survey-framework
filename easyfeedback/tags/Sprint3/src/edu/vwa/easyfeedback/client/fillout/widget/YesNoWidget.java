package edu.vwa.easyfeedback.client.fillout.widget;

import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Widget;

import edu.vwa.easyfeedback.client.common.QuestionPresenterFactory;

/**
 * View widget for displaying a YesNoQuestion
 * @author fleerkoetter
 *
 */
public class YesNoWidget extends QuestionWidget implements YesNoPresenter.Display {

	private RadioButton cbYes;
	private RadioButton cbNo;

	public YesNoWidget(QuestionPresenterFactory factory) {
		super(factory);
		init();
	}
	
	protected void init() {
		cbYes = new RadioButton("isYes", "Yes");
		cbNo = new RadioButton("isYes", "No");
		
		getElementsContainer().add(cbYes);
		getElementsContainer().add(cbNo);		
	}

	public HasValue<Boolean> getNo() {
		return cbNo;
	}

	public HasValue<Boolean> getYes() {
		return cbYes;
	}
	
	public Widget asWidget() {
		return this;
	}

}
