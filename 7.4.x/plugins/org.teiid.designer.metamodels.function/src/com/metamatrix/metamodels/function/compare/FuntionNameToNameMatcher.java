/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package com.metamatrix.metamodels.function.compare;

import org.eclipse.emf.ecore.EObject;
import com.metamatrix.metamodels.function.Function;
import com.metamatrix.modeler.core.compare.AbstractEObjectNameMatcher;


/** 
 * @since 4.2
 */
public class FuntionNameToNameMatcher extends AbstractEObjectNameMatcher {

    /**
     * Construct an instance of UuidEObjectMatcher.
     * 
     */
    public FuntionNameToNameMatcher() {
        super();
    }

    /** 
     * @see com.metamatrix.modeler.core.compare.AbstractEObjectNameMatcher#getInputKey(org.eclipse.emf.ecore.EObject)
     * @since 4.2
     */
    @Override
    protected String getInputKey(final EObject entity) {
        if(entity instanceof Function) {
            return ((Function)entity).getName();
        }
        return null;
    }
    /** 
     * @see com.metamatrix.modeler.core.compare.AbstractEObjectNameMatcher#getOutputKey(org.eclipse.emf.ecore.EObject)
     * @since 4.2
     */
    @Override
    protected String getOutputKey(final EObject entity) {
        if(entity instanceof Function) {
            return ((Function)entity).getName();
        }
        return null;
    }

}
