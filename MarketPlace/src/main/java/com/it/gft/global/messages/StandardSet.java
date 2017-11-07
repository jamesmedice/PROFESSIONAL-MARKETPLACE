package com.it.gft.global.messages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StandardSet implements Serializable {

    private static final long serialVersionUID = 2202869838312279401L;

    private List<String> parents;

    private List<String> childs;

    public List<String> getParents() {
	if (parents == null)
	    parents = new ArrayList<String>();

	return parents;
    }

    public List<String> getChilds() {
	if (childs == null)
	    childs = new ArrayList<String>();

	return childs;
    }

}
