package edu.vwa.easyfeedback.server.common.service;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ServicesTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for edu.vwa.easyfeedback.common.server.service");
		//$JUnit-BEGIN$
		suite.addTestSuite(PersistenceServiceImplTest.class);
		//$JUnit-END$
		return suite;
	}

}
