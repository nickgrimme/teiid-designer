/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.metamodels.uml2.aspects.uml;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Comment;
import org.teiid.core.util.CoreArgCheck;
import org.teiid.designer.core.metamodel.aspect.MetamodelEntity;
import org.teiid.designer.core.metamodel.aspect.uml.UmlComment;
import org.teiid.designer.metamodels.uml2.Uml2Plugin;


/**
 * Comment Aspect
 */
public class Uml2CommentUmlAspect extends AbstractUml2UmlAspect implements UmlComment {

	/**
	 * @param entity
	 */
	public Uml2CommentUmlAspect(MetamodelEntity entity) {
		super();
		setMetamodelEntity(entity);
	}


	/* (non-Javadoc)
	 * @See org.teiid.designer.core.metamodel.aspect.uml.UmlComment#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object eObject) {
		final Comment c = assertComment(eObject);
		return c.getBody();
	}

	/* (non-Javadoc)
	 * @See org.teiid.designer.core.metamodel.aspect.uml.UmlComment#getOwner(java.lang.Object)
	 */
	@Override
	public EObject getOwner(Object eObject) {
		final Comment c = assertComment(eObject);
		return c.getOwner();
	}

	/* (non-Javadoc)
	 * @See org.teiid.designer.core.metamodel.aspect.uml.UmlDiagramAspect#getEditableSignature(java.lang.Object)
	 */
	@Override
	public String getEditableSignature(Object eObject) {
		return ""; //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @See org.teiid.designer.core.metamodel.aspect.uml.UmlDiagramAspect#getSignature(java.lang.Object, int)
	 */
	@Override
	public String getSignature(Object eObject, int showMask) {
		return ""; //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @See org.teiid.designer.core.metamodel.aspect.uml.UmlDiagramAspect#getStereotype(java.lang.Object)
	 */
	@Override
	public String getStereotype(Object eObject) {
		return Uml2Plugin.getPluginResourceLocator().getString("_UI_Comment_type"); //$NON-NLS-1$
	}

	/* (non-Javadoc)
	 * @See org.teiid.designer.core.metamodel.aspect.uml.UmlDiagramAspect#setSignature(java.lang.Object, java.lang.String)
	 */
	@Override
	public IStatus setSignature(Object eObject, String newSignature) {
		throw new UnsupportedOperationException(Uml2Plugin.Util.getString("Uml2CommentUmlAspect.Signature_may_not_be_set_on_a__1",getStereotype(eObject))); //$NON-NLS-1$
	}
	
	protected Comment assertComment(Object eObject) {
		CoreArgCheck.isInstanceOf(Comment.class, eObject);
		return (Comment) eObject;
	}

}
