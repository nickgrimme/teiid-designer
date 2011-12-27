/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package com.metamatrix.modeler.core.types;

import org.eclipse.emf.ecore.resource.ResourceSet;
import com.metamatrix.modeler.core.ModelerCoreException;


/** 
 * Internal representation
 * @since 4.2
 */
public interface DatatypeManagerLifecycle {

    void initialize( ResourceSet container ) throws ModelerCoreException;
}
