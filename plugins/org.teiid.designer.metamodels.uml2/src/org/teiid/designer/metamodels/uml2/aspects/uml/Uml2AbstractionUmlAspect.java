/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.metamodels.uml2.aspects.uml;

import java.util.List;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.uml2.uml.Abstraction;
import org.teiid.core.util.CoreArgCheck;
import org.teiid.core.util.CoreStringUtil;
import org.teiid.designer.core.metamodel.aspect.MetamodelEntity;
import org.teiid.designer.metamodels.uml2.Uml2Plugin;


/**
 * AbstractionAspect
 */
public class Uml2AbstractionUmlAspect extends AbstractUml2DependencyUmlAspect {

    /**
     * Abstraction Aspect
     */
    public Uml2AbstractionUmlAspect( MetamodelEntity entity ) {
        super();
        setMetamodelEntity(entity);
    }

    /* (non-Javadoc)
     * @See org.teiid.designer.core.metamodel.aspect.uml.UmlDependency#getSource(java.lang.Object)
     */
    @Override
	public List getSource( Object relationship ) {
        Abstraction a = assertAbstraction(relationship);
        return a.getSources();
    }

    /* (non-Javadoc)
     * @See org.teiid.designer.core.metamodel.aspect.uml.UmlDependency#getTarget(java.lang.Object)
     */
    @Override
	public List getTarget( Object relationship ) {
        Abstraction a = assertAbstraction(relationship);
        return a.getTargets();
    }

    /* (non-Javadoc)
     * @See org.teiid.designer.core.metamodel.aspect.uml.UmlDependency#getEndObjects(java.lang.Object, int)
     */
    @Override
	public List getEndObjects( Object relationship,
                               int end ) {
        Abstraction a = assertAbstraction(relationship);
        if (end == 0) {
            return a.getSources();
        } else if (end == 1) {
            return a.getTargets();
        }
        return null;
    }

    /* (non-Javadoc)
     * @See org.teiid.designer.core.metamodel.aspect.uml.UmlDependency#isAbstraction(java.lang.Object)
     */
    @Override
	public boolean isAbstraction( Object relationship ) {
        return true;
    }

    /* (non-Javadoc)
     * @See org.teiid.designer.core.metamodel.aspect.uml.UmlDependency#isUsage(java.lang.Object)
     */
    @Override
	public boolean isUsage( Object relationship ) {
        return false;
    }

    /* (non-Javadoc)
     * @See org.teiid.designer.core.metamodel.aspect.uml.UmlDependency#isPermission(java.lang.Object)
     */
    @Override
	public boolean isPermission( Object relationship ) {
        return false;
    }

    /* (non-Javadoc)
     * @See org.teiid.designer.core.metamodel.aspect.uml.UmlDependency#isRealization(java.lang.Object)
     */
    @Override
	public boolean isRealization( Object relationship ) {
        return false;
    }

    /* (non-Javadoc)
     * @See org.teiid.designer.core.metamodel.aspect.uml.UmlDependency#isSubstitution(java.lang.Object)
     */
    @Override
	public boolean isSubstitution( Object relationship ) {
        return false;
    }

    /* (non-Javadoc)
     * @See org.teiid.designer.core.metamodel.aspect.uml.UmlDiagramAspect#getStereotype(java.lang.Object)
     */
    @Override
	public String getStereotype( Object eObject ) {
        return Uml2Plugin.getPluginResourceLocator().getString("_UI_Abstraction_type"); //$NON-NLS-1$;
    }

    /* (non-Javadoc)
     * @See org.teiid.designer.core.metamodel.aspect.uml.UmlDiagramAspect#getSignature(java.lang.Object, int)
     */
    @Override
	public String getSignature( Object eObject,
                                int showMask ) {
        return CoreStringUtil.Constants.EMPTY_STRING;
    }

    /* (non-Javadoc)
     * @See org.teiid.designer.core.metamodel.aspect.uml.UmlDiagramAspect#getEditableSignature(java.lang.Object)
     */
    @Override
	public String getEditableSignature( Object eObject ) {
        return CoreStringUtil.Constants.EMPTY_STRING;
    }

    /* (non-Javadoc)
     * @See org.teiid.designer.core.metamodel.aspect.uml.UmlDiagramAspect#setSignature(java.lang.Object, java.lang.String)
     */
    @Override
	public IStatus setSignature( Object eObject,
                                 String newSignature ) {
        throw new UnsupportedOperationException();
    }

    protected Abstraction assertAbstraction( Object eObject ) {
        CoreArgCheck.isInstanceOf(Abstraction.class, eObject);
        return (Abstraction)eObject;
    }

}
