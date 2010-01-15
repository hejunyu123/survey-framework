package edu.vwa.easyfeedback.server.common.service;

import java.util.Date;

import junit.framework.TestCase;
import edu.vwa.easyfeedback.client.common.model.Survey;
import edu.vwa.easyfeedback.client.common.model.SurveyUser;

public class PersistenceServiceImplTest extends TestCase {
	
	Survey testSurvey;
	SurveyUser testUser;
	
	@Override
	protected void setUp() throws Exception {
		testSurvey = new Survey();
		testSurvey.setName("uniquename");
		testSurvey.setCaption("caption");
		testSurvey.setCreatedAt(new Date());
		testSurvey.setDescription("description");
		
		testUser = new SurveyUser();
		testUser.setEmail("testuser@test.de");
		testUser.setKey("uniquename");
	}

	public void testSaveLoadSurvey() throws Throwable {
		PersistenceServiceImpl persistenceService = new PersistenceServiceImpl();
		persistenceService.saveSurvey(testSurvey);
		Survey result = persistenceService.getSurvey("uniquename");
		assertTrue(
				result.getCaption() == testSurvey.getCaption()
				&& result.getCaption() == testSurvey.getCaption()
				&& result.getCreatedAt() == testSurvey.getCreatedAt()
				&& result.getDescription() == testSurvey.getDescription()
		);
	}
	
	public void testSaveLoadUser() throws Throwable {
		PersistenceServiceImpl persistenceService = new PersistenceServiceImpl();
		persistenceService.saveSurveyUser(testUser);
		SurveyUser result = persistenceService.getSurveyUser("uniquename");
		assertTrue(
				result.getEmail() == testUser.getEmail()
				&& result.getKey() == testUser.getKey()
		);
	}
	
}
