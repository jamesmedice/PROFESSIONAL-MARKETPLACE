package com.it.gft.global.interceptor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.type.Type;

import com.it.gft.global.interceptor.util.AuditLogUtil;
import com.it.gft.global.log.model.IAuditLog;

public class AuditLogInterceptor extends EmptyInterceptor {
    
	private final transient Log LOGGER = LogFactory.getLog(AuditLogInterceptor.class);

    private static final String SAVED = "Saved";

    private static final String DELETED = "Deleted";

    private static final String UPDATED = "Updated";

    private static final long serialVersionUID = 1775228354052642640L;

    private Set<IAuditLog> inserts = new HashSet();
    private Set<IAuditLog> updates = new HashSet();
    private Set<IAuditLog> deletes = new HashSet();

    Session session;
    SessionBuilder sessionBuilder;

    public void setSession(Session session) {
	this.session = session;
    }

    public void setSessionBuilder(SessionBuilder sessionBuilder) {
	this.sessionBuilder = sessionBuilder;
    }

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {

	if (entity instanceof IAuditLog) {
	    AuditLogUtil.LogIt(SAVED, (IAuditLog) entity, session);
	    inserts.add((IAuditLog) entity);
	    return false;
	} else
	    return super.onSave(entity, id, state, propertyNames, types);

    }

    @Override
    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {

	super.onDelete(entity, id, state, propertyNames, types);

	if (entity instanceof IAuditLog) {
	    AuditLogUtil.LogIt(DELETED, (IAuditLog) entity, session);
	    deletes.add((IAuditLog) entity);
	}
    }

    @Override
    public void postFlush(Iterator entities) {

	super.postFlush(entities);

	try {

	    for (IAuditLog iAuditLog : inserts) {
		LOGGER.info("postFlush S [" + iAuditLog.toString() + "]");
		LOGGER.info("postFlush - insert");
	    }
	    for (IAuditLog iAuditLog : deletes) {
		LOGGER.info("postFlush D [" + iAuditLog.toString() + "]");
		LOGGER.info("postFlush - delete");
	    }
	    for (IAuditLog iAuditLog : updates) {
		LOGGER.info("postFlush U [" + iAuditLog.toString() + "]");
		LOGGER.info("postFlush - update");
	    }

	} finally {
	    inserts.clear();
	    updates.clear();
	    deletes.clear();
	}
    }

    @Override
    public void preFlush(Iterator entities) {
	super.preFlush(entities);
    }

    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
	LOGGER.info("onFlushDirty");

	if (entity instanceof IAuditLog) {
	    AuditLogUtil.LogIt(UPDATED, (IAuditLog) entity, session);
	    updates.add((IAuditLog) entity);
	    return false;
	} else
	    return super.onFlushDirty(entity, id, currentState, previousState, propertyNames, types);

    }

}
