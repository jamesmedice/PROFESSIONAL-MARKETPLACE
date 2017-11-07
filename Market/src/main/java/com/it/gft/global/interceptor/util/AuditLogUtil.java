package com.it.gft.global.interceptor.util;

import java.util.Date;

import org.hibernate.Session;

import com.it.gft.global.log.model.IAuditLog;
import com.it.gft.global.model.AuditLog;

public class AuditLogUtil {
    public static void LogIt(String action, IAuditLog entity, Session session) {
	AuditLog auditRecord = new AuditLog(action, entity.getAuditDetail(), new Date(), entity.getId(), entity.getClass().toString());
	session.save(auditRecord);
    }
}
