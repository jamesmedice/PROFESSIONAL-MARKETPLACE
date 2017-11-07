package com.it.gft.global.log.model;

import java.io.Serializable;

public interface IAuditLog extends Serializable {

    Long getId();

    String getAuditDetail();

}
