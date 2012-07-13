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
import org.eclipse.uml2.uml.Substitution;
import org.teiid.core.util.CoreArgCheck;
import org.teiid.designer.core.metamodel.aspect.MetamodelEntity;
import org.teiid.designer.metamodels.uml2.Uml2Plugin;


/**
 * UsageAspect
 */
public class Uml2SubstitutionUmlAspect extends AbstractUml2DependencyUmlAspect {

    /**
     * Substitution Aspect
     */
    public Uml2SubstitutionUmlAspect( MetamodelEntity entity ) {
        super();
        setMetamodelEntity(entity);
    }

    /* (non-Javadoc)
     * @See org.teiid.designer.core.metamodel.aspect.uml.UmlDependency#getSource(java.lang.Object)
     */
    @Override
	public List getSource( Object relationship ) {
        Substitution s = assertSubstitution(relationship);
        return s.getSources();
    }

    /* (non-Javadoc)
     * @See org.teiid.designer.core.metamodel.aspect.uml.UmlDependency#getTarget(java.lang.Object)
     */
    @Override
	public List getTarget( Object relationship ) {
        Substitution s = assertSubstitution(relationship);
        return s.getTargets();
    }

    /* (non-Javadoc)
     * @See org.teiid.designer.core.metamodel.aspect.uml.UmlDependency#getEndObjects(java.lang.Object, int)
     */
    @Override
	public List getEndObjects( Object relationship,
                               int end ) {
        Substitution s = assertSubstitution(relationship);
        return s.getOwnedElements();
    }

    /* (non-Javadoc)
     * @See org.teiid.designer.core.metamodel.aspect.uml.UmlDependency#isAbstraction(java.lang.Object)
     */
    @Override
	public boolean isAbstraction( Object relationship ) {
        return false;
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
        return true;
    }

    /* (non-Javadoc)
     * @See org.teiid.designer.core.metamodel.aspect.uml.UmlDiagramAspect#getStereotype(java.lang.Object)
     */
    @Override
	public String getStereotype( Object eObject ) {
        return Uml2Plugin.getPluginResourceLocator().getString("_UI_Substitution_type"); //$NON-NLS-1$;
    }

    /* (non-Javadoc)
     * @See org.teiid.designer.core.metamodel.aspect.uml.UmlDiagramAspect#getSignature(java.lang.Object, int)
     */
    @Override
	public String getSignature( Object eObject,
                                int showMask ) {
        return ""; //$NON-NLS-1$
    }

    /* (non-Javadoc)
     * @See org.teiid.designer.core.metamodel.aspect.uml.UmlDiagramAspect#getEditableSignature(java.lang.Object)
     */
    @Override
	public String getEditableSignature( Object eObject ) {
        return ""; //$NON-NLS-1$
    }

    /* (non-Javadoc)
     * @See org.teiid.designer.core.metamodel.aspect.uml.UmlDiagramAspect#setSignature(java.lang.Object, java.lang.String)
     */
    @Override
	public IStatus setSignature( Object eObject,
                                 String newSignature ) {
        throw new UnsupportedOperationException(
                                                Uml2Plugin.Util.getString("Uml2UsageUmlAspect.Signature_may_not_be_set_on_a__1", getStereotype(eObject))); //$NON-NLS-1$
    }

    protected Substitution assertSubstitution( Object eObject ) {
        CoreArgCheck.isInstanceOf(Substitution.class, eObject);
        return (Substitution)eObject;
    }

}
