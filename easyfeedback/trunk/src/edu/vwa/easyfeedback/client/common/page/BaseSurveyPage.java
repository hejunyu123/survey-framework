package edu.vwa.easyfeedback.client.common.page;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import edu.vwa.easyfeedback.client.common.QuestionPresenterFactory;

public abstract class BaseSurveyPage extends Composite implements BaseSurveyPresenter.Display {

	protected Label caption;
	protected Label description;
	protected VerticalPanel questions;
	protected Button btnMakePersistent;
	protected VerticalPanel root;
	protected QuestionPresenterFactory factory;
	
	public BaseSurveyPage(QuestionPresenterFactory factory) {
		super();
		this.factory = factory;
		internalConstruct();
		construct();	
		// Must be called
		initWidget(root);	
	}
	
	private void internalConstruct() {
		caption = factory.createSurveyLabel("%Question%");
		description = factory.createSurveyLabel("%Description%");
		questions = new VerticalPanel();
		root = new VerticalPanel();		
		btnMakePersistent = new Button("Save");
		
		caption.addStyleName("ef-Survey-Caption");
		description.addStyleName("ef-survey-Description");
		
		root.add(caption);
		root.add(description);
		root.add(questions);
		root.add(btnMakePersistent);		
	}

	/**
	 * Override this to 
	 */
	protected abstract void construct();
	
	public HasText getCaption() {
		return (HasText) caption;
	}

	public HasText getDescription() {
		return (HasText) description;
	}

	public InsertPanel getQuestions() {
		return questions;
	}
	
	public HasClickHandlers getBtnMakePersistent() {
		return btnMakePersistent;
	}

	public Widget asWidget() {
		return this;
	}

}
