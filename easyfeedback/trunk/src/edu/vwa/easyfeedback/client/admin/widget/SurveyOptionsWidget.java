package edu.vwa.easyfeedback.client.admin.widget;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

public class SurveyOptionsWidget extends Composite implements SurveyOptionsPresenter.Display {
	
	private Panel root = new HorizontalPanel();
	private Label lblName = new Label();
	private Hyperlink showLink = new Hyperlink("Edit", "edit-survey");
	private Anchor deleteLink = new Anchor("Delete");
	private Anchor publishLink = new Anchor("Publish");
	private Hyperlink takeLink = new Hyperlink("Take", "take-survey");
	
	public SurveyOptionsWidget() {
		super();
		root.addStyleName("gwt-Survey-Options ");
		root.add(lblName);
		root.add(showLink);
		root.add(publishLink);
		root.add(takeLink);
		root.add(deleteLink);
		this.initWidget(root);
	}

	public Widget asWidget() {
		return this;
	}

	public HasText getName() {
		return lblName;
	}

	public HasClickHandlers getDeleteClickHandlers() {
		return deleteLink;
	}

	public HasClickHandlers getPublishClickHandlers() {
		return publishLink;
	}

	public void setPublishVisible(boolean visible) {
		publishLink.setVisible(visible);
	}

	public HasClickHandlers getShowClickHandlers() {
		return showLink;
	}

	public HasClickHandlers getTakeClickHandlers() {
		return takeLink;
	}

	public void setTakeVisible(boolean visible) {
		takeLink.setVisible(visible);
	}
	
}
