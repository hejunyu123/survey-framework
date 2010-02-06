package edu.vwa.easyfeedback.server.common;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

/**
 * Singleton for JDO Persistence Manager.
 * Taken from http://code.google.com/intl/de-DE/appengine/docs/java/datastore/usingjdo.html#Getting_a_PersistenceManager_Instance
 * @author fleerkoetter
 *
 */
public class PMF {
    private static final PersistenceManagerFactory pmfInstance =
        JDOHelper.getPersistenceManagerFactory("transactions-optional");

    private PMF() {}

    public static PersistenceManagerFactory get() {
        return pmfInstance;
    }

}
