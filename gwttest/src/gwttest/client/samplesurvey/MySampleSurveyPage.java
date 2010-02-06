package gwttest.client.samplesurvey;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;

public class MySampleSurveyPage extends Composite implements MySampleSurveyPresenter.Display {

	private static Panel root;
	private static Label caption;
	private static Label description;
	
	public class LabelHeading extends Label {
		private int number;

		public LabelHeading(int headingNumber) {
			if (headingNumber <= 0) {
				headingNumber = 1;
			}
			number = headingNumber;			
		}
		
		public void setText(String text) {
			DOM.setInnerHTML(this.getElement(), "<h"+number+">"+text+"</h"+number+">");
		}		
		
		public String getText() {
			return DOM.getFirstChild(this.getElement()).getInnerText();
		}
	}
	
	/**
	 * Constructs the page
	 */
	public MySampleSurveyPage() {
		// Construct page
		root = new VerticalPanel();
		caption = new LabelHeading(1);
		description = new LabelHeading(2);
		root.add(caption);
		root.add(description);
		
		// Must be called
		initWidget(root);
	}
	
	public Widget asWidget() {
		// TODO Auto-generated method stub
		return this;
	}

	public void startProcessing() {
		// TODO Auto-generated method stub
		
	}

	public void stopProcessing() {
		// TODO Auto-generated method stub
		
	}

	public HasText getCaption() {
		// TODO Auto-generated method stub
		return (HasText) caption;
	}

	public HasText getDescription() {
		// TODO Auto-generated method stub
		return (HasText) description;
	}
	
	
}
