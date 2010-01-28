package edu.vwa.easyfeedback.server.common.service;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.vwa.easyfeedback.client.common.model.FreeTextQuestion;
import edu.vwa.easyfeedback.client.common.model.MultipleChoiceOption;
import edu.vwa.easyfeedback.client.common.model.MultipleChoiceQuestion;
import edu.vwa.easyfeedback.client.common.model.Survey;
import edu.vwa.easyfeedback.client.common.model.YesNoQuestion;
import edu.vwa.easyfeedback.client.common.service.PersistenceService;

/**
 * Mock class for testing the survey loading and viewing mechanism
 * @author fleerkoetter
 *
 */
public class PersistenceServiceMock extends RemoteServiceServlet implements
		PersistenceService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8995792040183339359L;

	public Survey getSurvey(String name) {
		Survey sample = new Survey();
		sample.setCaption("HelloWorld Survey");
		sample.setDescription("This is just a sample of an survey");
		sample.setName("sample");
		
		// Yes/Np
		YesNoQuestion yn = new YesNoQuestion();
		yn.setCaption("Do you like surveys?");
		yn.setDescription("Just for a matter of interest...");
		sample.getElements().add(yn);
		
		// Single-line free text
		FreeTextQuestion text = new FreeTextQuestion();
		text.setCaption("Why so you like them (or not)?");
		text.setDescription("Feel free to enter whatever you want ;-)");
		sample.getElements().add(text);
		
		// Multiple-line free text
		FreeTextQuestion multiText = new FreeTextQuestion();
		multiText.setIsMultiLineText(true);
		multiText.setCaption("Do you need some more space?");
		multiText.setDescription("Feel free to enter whatever you want - even more ;-)");
		sample.getElements().add(multiText);
		
		// Multiple choice / exclusive
		MultipleChoiceQuestion multi = new MultipleChoiceQuestion();
		multi.setCaption("How many surveys do you take online?");
		multi.setDescription("In average per month.");
		multi.setMaxOptions(1);
		List<MultipleChoiceOption> multiOptions = multi.getOptions();
		multiOptions.add(new MultipleChoiceOption("None"));
		multiOptions.add(new MultipleChoiceOption("1-5"));
		multiOptions.add(new MultipleChoiceOption("6-10"));
		multiOptions.add(new MultipleChoiceOption("More than 10"));
//		multi.setOptions(multiAnswers);
		sample.getElements().add(multi);
		
		return sample;
	}

	public void saveSurvey(Survey survey) {
		// TODO Auto-generated method stub

	}

}
