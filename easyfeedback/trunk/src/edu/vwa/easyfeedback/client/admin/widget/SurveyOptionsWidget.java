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
		root.add(lblName);
		root.add(showLink);
		root.add(publishLink);
		root.add(takeLink);
		root.add(deleteLink);
		this.initWidget(root);
	}

	@Override
	public Widget asWidget() {
		return this;
	}

	@Override
	public HasText getName() {
		return lblName;
	}

	@Override
	public HasClickHandlers getDeleteClickHandlers() {
		return deleteLink;
	}

	@Override
	public HasClickHandlers getPublishClickHandlers() {
		return publishLink;
	}

	@Override
	public void setPublishVisible(boolean visible) {
		publishLink.setVisible(visible);
	}

	@Override
	public HasClickHandlers getShowClickHandlers() {
		return showLink;
	}

	@Override
	public HasClickHandlers getTakeClickHandlers() {
		return takeLink;
	}

	@Override
	public void setTakeVisible(boolean visible) {
		takeLink.setVisible(visible);
	}
	
}
