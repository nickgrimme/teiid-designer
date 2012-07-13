/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.metamodels.xmlservice.aspects.validation;

import org.eclipse.emf.ecore.EClassifier;
import org.teiid.designer.core.metamodel.aspect.MetamodelAspect;
import org.teiid.designer.core.metamodel.aspect.MetamodelAspectFactory;
import org.teiid.designer.core.metamodel.aspect.MetamodelEntity;
import org.teiid.designer.metamodels.xmlservice.XmlServicePackage;



/** 
 * XmlServiceValidationAspectFactoryImpl
 */
public class XmlServiceValidationAspectFactoryImpl implements MetamodelAspectFactory {


    /** 
     * @see org.teiid.designer.core.metamodel.aspect.MetamodelAspectFactory#create(org.eclipse.emf.ecore.EClassifier, org.teiid.designer.core.metamodel.aspect.MetamodelEntity)
     * @since 4.2
     */
    @Override
	public MetamodelAspect create(final EClassifier classifier, final MetamodelEntity entity) {
        switch (classifier.getClassifierID()) {
            case XmlServicePackage.XML_OPERATION: return new XmlOperationAspect(entity);
            case XmlServicePackage.XML_INPUT: return new XmlInputAspect(entity);
            case XmlServicePackage.XML_OUTPUT: return new XmlOutputAspect(entity);
            case XmlServicePackage.XML_RESULT: return null;
            case XmlServicePackage.OPERATION_UPDATE_COUNT: return null;
            default: return null;
        }
    }
}
