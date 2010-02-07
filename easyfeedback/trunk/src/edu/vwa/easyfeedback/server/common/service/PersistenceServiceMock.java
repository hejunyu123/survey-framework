package edu.vwa.easyfeedback.server.common.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
		return createNewSampleSurvey();
	}

	public void saveSurvey(Survey survey) {
		// TODO Auto-generated method stub
	}

	public Iterable<Survey> getSurveys() {
		List<Survey> surveys = new ArrayList<Survey>(10);
		while (surveys.size() < 10)
			surveys.add(createNewSampleSurvey());
		return surveys;
	}

	private Survey createNewSampleSurvey()
	{
		Survey sample = new Survey();
		sample.setCaption("HelloWorld Survey");
		sample.setDescription("This is just a sample of an survey");
		Random rand = new Random();
		int i = rand.nextInt(99999);
		sample.setName(String.valueOf(i));
		
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
		sample.getElements().add(multi);
		
		MultipleChoiceQuestion alternate = new MultipleChoiceQuestion();
		alternate.setCaption("What are your hobbies?");
		alternate.setDescription("You can select more than 1");
		alternate.setMaxOptions(-1);
		alternate.getOptions().add(new MultipleChoiceOption("Swimming"));
		alternate.getOptions().add(new MultipleChoiceOption("Reading"));
		alternate.getOptions().add(new MultipleChoiceOption("Gardening"));
		alternate.getOptions().add(new MultipleChoiceOption("Biking"));
		alternate.getOptions().add(new MultipleChoiceOption("Watching movies"));
		alternate.getOptions().add(new MultipleChoiceOption("Cleaning the house"));
		sample.getElements().add(alternate);
		
		return sample;
	}

	public void deleteSurvey(Survey survey) {
		// TODO Auto-generated method stub
		
	}

	public Survey createSurvey(String caption, String description)
	{
		Survey survey = createNewSampleSurvey();
		survey.setCaption(caption);
		survey.setDescription(description);
		return survey;
	}
}
