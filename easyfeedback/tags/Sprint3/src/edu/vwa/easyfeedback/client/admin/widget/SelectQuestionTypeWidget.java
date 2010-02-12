package edu.vwa.easyfeedback.client.admin.widget;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class SelectQuestionTypeWidget extends Composite implements SelectQuestionTypePresenter.Display {

	private Button btnAddQuestion = new Button("Append new question");
	private ListBox lbQuestionTypes = new ListBox();
	
	public SelectQuestionTypeWidget() {
		FlowPanel root = new FlowPanel();
		root.add(lbQuestionTypes);
		root.add(btnAddQuestion);
		initWidget(root);
	}

	public HasClickHandlers getBtnAddQuestion() {
		return btnAddQuestion;
	}

	public List<String> getItems() {
		ArrayList<String> result = new ArrayList<String>();
		for (int i  = 0; i < lbQuestionTypes.getItemCount(); i++) {
			result.add(lbQuestionTypes.getItemText(i));
		}		
		return result;
	}

	public int getSelectedIndex() {
		return lbQuestionTypes.getSelectedIndex();
	}

	public void setItems(List<String> items) {
		lbQuestionTypes.clear();
		// Dunno, but javac won't let me use a foreach here...
		for (Iterator<String> i  = items.iterator(); i.hasNext(); ) {
			lbQuestionTypes.addItem(i.next());
		}
	}

	public Widget asWidget() {
		return this;
	}

}
