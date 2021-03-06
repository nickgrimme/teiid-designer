/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.core.search.runtime;


/**
 * AbstractSearchRecord
 *
 * @since 8.0
 */
public abstract class AbstractSearchRecord implements SearchRecord {

	private String uuid;

	/* (non-Javadoc)
	 * @See org.teiid.designer.relationship.search.index.SearchRecord#getUUID()
	 */
	@Override
	public String getUUID() {
		return uuid;
	}

	/**
	 * @param string
	 */
	public void setUUID(String string) {
		uuid = string;
	}
}
