package edu.vwa.easyfeedback.server.common.service;

import java.util.Date;

import edu.vwa.easyfeedback.client.common.model.Survey;
import edu.vwa.easyfeedback.client.common.model.SurveyUser;
import edu.vwa.easyfeedback.server.common.LocalServiceTestCase;

public class PersistenceServiceImplTest extends LocalServiceTestCase {
	
	Survey testSurvey;
	SurveyUser testUser;
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		testSurvey = new Survey();
		testSurvey.setName("uniquename");
		testSurvey.setCaption("caption");
		testSurvey.setCreatedAt(new Date());
		testSurvey.setDescription("description");
		
		testUser = new SurveyUser();
		testUser.setEmail("testuser@test.de");
//		testUser.setKey("uniquename");
	}

	public void testSaveLoadSurvey() throws Throwable {
		PersistenceServiceImpl persistenceService = new PersistenceServiceImpl();
		persistenceService.saveSurvey(testSurvey);
		Survey result = persistenceService.getSurvey("uniquename");
		assertTrue(
				result.getCaption().equals(testSurvey.getCaption())
//				&& result.getCaption() == testSurvey.getCaption()
				&& result.getCreatedAt().equals(testSurvey.getCreatedAt())
				&& result.getDescription().equals(testSurvey.getDescription())
		);
	}
	
	public void testSaveLoadUser() throws Throwable {
		PersistenceServiceImpl persistenceService = new PersistenceServiceImpl();
		persistenceService.saveSurveyUser(testUser);
		SurveyUser result = persistenceService.getSurveyUser(testUser.getEmail());
		assertTrue(
				result.getEmail().equals(testUser.getEmail())
//				&& result.getKey().equals(testUser.getKey())
		);
	}
	
}
