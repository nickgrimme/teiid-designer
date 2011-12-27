/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package com.metamatrix.metamodels.relational.aspects.validation;

import com.metamatrix.modeler.core.metamodel.aspect.MetamodelEntity;

/**
 * TableAspect
 */
public class BaseTableAspect extends TableAspect {
    
    /**
     * Construct an instance of TableAspect.
     * @param entity
     */
    public BaseTableAspect(MetamodelEntity entity){
        super(entity);
    }
}
