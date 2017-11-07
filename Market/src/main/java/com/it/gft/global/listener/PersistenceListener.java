package com.it.gft.global.listener;

import org.hibernate.engine.internal.SessionEventListenerManagerImpl;

public class PersistenceListener extends SessionEventListenerManagerImpl {

    private static final long serialVersionUID = 5889326728339307218L;

    @Override
    public void partialFlushEnd(int arg0, int arg1) {

	super.partialFlushEnd(arg0, arg1);
    }

    @Override
    public void flushEnd(int arg0, int arg1) {

	super.flushEnd(arg0, arg1);
    }

    @Override
    public void dirtyCalculationStart() {
	super.dirtyCalculationStart();
    }

    @Override
    public void dirtyCalculationEnd(boolean arg0) {

	super.dirtyCalculationEnd(arg0);
    }

}
