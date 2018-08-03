package com.it.gft.global.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "AUDIT_LOG")
public class AuditLog implements java.io.Serializable {

  
	private static final long serialVersionUID = 1152555741224304950L;
	
	private Long auditLogId;
    private String action;
    private String detail;
    private Date createdDate;
    private long entityId;
    private String entityName;

    public AuditLog() {
    }

    public AuditLog(String action, String detail, Date createdDate, long entityId, String entityName) {
	this.action = action;
	this.detail = detail;
	this.createdDate = createdDate;
	this.entityId = entityId;
	this.entityName = entityName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUDIT_LOG_ID", unique = true, nullable = false)
    public Long getAuditLogId() {
	return this.auditLogId;
    }

    public void setAuditLogId(Long auditLogId) {
	this.auditLogId = auditLogId;
    }

    @Column(name = "ACTION", nullable = false, length = 100)
    public String getAction() {
	return this.action;
    }

    public void setAction(String action) {
	this.action = action;
    }

    @Column(name = "DETAIL", nullable = false, length = 65535)
    public String getDetail() {
	return this.detail;
    }

    public void setDetail(String detail) {
	this.detail = detail;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE", nullable = false, length = 10)
    public Date getCreatedDate() {
	return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
    }

    @Column(name = "ENTITY_ID", nullable = false)
    public long getEntityId() {
	return this.entityId;
    }

    public void setEntityId(long entityId) {
	this.entityId = entityId;
    }

    @Column(name = "ENTITY_NAME", nullable = false)
    public String getEntityName() {
	return this.entityName;
    }

    public void setEntityName(String entityName) {
	this.entityName = entityName;
    }

}
