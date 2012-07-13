/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.relationship;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.teiid.core.util.CoreArgCheck;
import org.teiid.designer.core.ModelerCore;
import org.teiid.designer.core.ModelerCoreException;
import org.teiid.designer.core.TransactionRunnable;
import org.teiid.designer.core.transaction.UnitOfWork;
import org.teiid.designer.metamodels.relationship.Relationship;
import org.teiid.designer.metamodels.relationship.RelationshipRole;
import org.teiid.designer.metamodels.relationship.RelationshipType;

/**
 * RelationshipEditorImpl
 */
public class RelationshipEditorImpl implements RelationshipEditor {

    final Relationship relationship;
    private final boolean useTransactions;

    /**
     * Construct an instance of RelationshipEditorImpl.
     * 
     * @param relationship the relationship to be edited; may not be null
     * @param useTransactions true if the move methods should be completed in a single transaction, or false if implicit
     *        transactions should be used for all operations
     */
    public RelationshipEditorImpl( final Relationship relationship,
                                   final boolean useTransactions ) {
        super();
        CoreArgCheck.isNotNull(relationship);
        this.relationship = relationship;
        this.useTransactions = useTransactions;
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#getRelationshipType()
     */
    @Override
	public Relationship getRelationship() {
        return relationship;
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#validate()
     */
    @Override
	public IStatus validate() {
        return relationship.isValid();
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#getName()
     */
    @Override
	public String getName() {
        return relationship.getName();
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#setName(java.lang.String)
     */
    @Override
	public void setName( final String name ) {
        if (name == null || name.trim().length() == 0) {
            this.relationship.setName(null);
        } else {
            this.relationship.setName(name);
        }
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#getRelationshipType()
     */
    @Override
	public RelationshipType getRelationshipType() {
        return this.relationship.getType();
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#setRelationshipType(org.teiid.designer.metamodels.relationship.RelationshipType)
     */
    @Override
	public void setRelationshipType( final RelationshipType type ) {
        this.relationship.setType(type); // may be null
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#getSourceRoleName()
     */
    @Override
	public String getSourceRoleName() {
        final RelationshipRole role = this.relationship.getSourceRole();
        if (role != null) {
            return role.getName();
        }
        return null;
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#getTargetRoleName()
     */
    @Override
	public String getTargetRoleName() {
        final RelationshipRole role = this.relationship.getTargetRole();
        if (role != null) {
            return role.getName();
        }
        return null;
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#getSourceParticipants()
     */
    @Override
	public List getSourceParticipants() {
        return this.relationship.getSources();
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#getTargetParticipants()
     */
    @Override
	public List getTargetParticipants() {
        return this.relationship.getTargets();
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#moveSourceParticipantToTargetParticipant(org.eclipse.emf.ecore.EObject)
     */
    @Override
	public boolean moveSourceParticipantToTargetParticipant( final EObject sourceParticipant ) {
        if (!canMoveSourceParticipantToTargetParticipant(sourceParticipant)) {
            return false;
        }
        final TransactionRunnable runnable = new TransactionRunnable() {
            @Override
			public Object run( UnitOfWork uow ) {
                relationship.getSources().remove(sourceParticipant);
                relationship.getTargets().add(sourceParticipant);
                return null;
            }
        };

        return executeAsTransaction(runnable, sourceParticipant, true);
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#moveTargetParticipantToSourceParticipant(org.eclipse.emf.ecore.EObject)
     */
    @Override
	public boolean moveTargetParticipantToSourceParticipant( final EObject targetParticipant ) {
        if (!canMoveTargetParticipantToSourceParticipant(targetParticipant)) {
            return false;
        }
        final TransactionRunnable runnable = new TransactionRunnable() {
            @Override
			public Object run( UnitOfWork uow ) {
                relationship.getTargets().remove(targetParticipant);
                relationship.getSources().add(targetParticipant);
                return null;
            }
        };

        return executeAsTransaction(runnable, targetParticipant, false);
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#canMoveSourceParticipantToTargetParticipant(org.eclipse.emf.ecore.EObject)
     */
    @Override
	public boolean canMoveSourceParticipantToTargetParticipant( final EObject object ) {
        if (object == null) {
            return false;
        }
        // Don't allow adding the relationship as a participant of itself ...
        if (object.equals(this.relationship)) {
            return false;
        }

        // Make sure the object already exists in the sources ...
        if (!this.relationship.getSources().contains(object)) {
            return false;
        }
        // See if already exists in the target ...
        final boolean uniqueRequired = isTargetUnique();
        final boolean alreadyExists = this.relationship.getTargets().contains(object);
        if (alreadyExists && uniqueRequired) {
            return false;
        }
        final boolean allowedByRole = this.getRelationshipType() == null ? true : this.getRelationshipType().getTargetRole().isAllowed(object);
        return allowedByRole;
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#canMoveTargetParticipantToSourceParticipant(org.eclipse.emf.ecore.EObject)
     */
    @Override
	public boolean canMoveTargetParticipantToSourceParticipant( final EObject object ) {
        if (object == null) {
            return false;
        }
        // Don't allow adding the relationship as a participant of itself ...
        if (object.equals(this.relationship)) {
            return false;
        }

        // Make sure the object already exists in the targets ...
        if (!this.relationship.getTargets().contains(object)) {
            return false;
        }
        // See if already exists in the sources ...
        final boolean uniqueRequired = isSourceUnique();
        final boolean alreadyExists = this.relationship.getSources().contains(object);
        if (alreadyExists && uniqueRequired) {
            return false;
        }
        final boolean allowedByRole = this.getRelationshipType() == null ? true : this.getRelationshipType().getSourceRole().isAllowed(object);
        return allowedByRole;
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#canAddToTargetParticipants(org.eclipse.emf.ecore.EObject)
     */
    @Override
	public boolean canAddToTargetParticipants( final EObject object ) {
        if (object == null) {
            return false;
        }
        // Don't allow adding the relationship as a participant of itself ...
        if (object.equals(this.relationship)) {
            return false;
        }

        // See if already exists in the target ...
        final boolean uniqueRequired = isTargetUnique();
        final boolean alreadyExists = this.relationship.getTargets().contains(object);
        if (alreadyExists && uniqueRequired) {
            return false;
        }
        final boolean allowedByRole = this.getRelationshipType() == null ? true : this.getRelationshipType().getTargetRole().isAllowed(object);
        return allowedByRole;
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#canAddToSourceParticipants(org.eclipse.emf.ecore.EObject)
     */
    @Override
	public boolean canAddToSourceParticipants( final EObject object ) {
        if (object == null) {
            return false;
        }
        // Don't allow adding the relationship as a participant of itself ...
        if (object.equals(this.relationship)) {
            return false;
        }

        // See if already exists in the sources ...
        final boolean uniqueRequired = isSourceUnique();
        final boolean alreadyExists = this.relationship.getSources().contains(object);
        if (alreadyExists && uniqueRequired) {
            return false;
        }
        final boolean allowedByRole = this.getRelationshipType() == null ? true : this.getRelationshipType().getSourceRole().isAllowed(object);
        return allowedByRole;
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#moveSourceParticipantToTargetParticipant(java.util.List)
     */
    @Override
	public boolean moveSourceParticipantToTargetParticipant( final List sourceParticipants ) {
        if (!canMoveSourceParticipantToTargetParticipant(sourceParticipants)) {
            return false;
        }
        final TransactionRunnable runnable = new TransactionRunnable() {
            @Override
			public Object run( UnitOfWork uow ) {
                relationship.getSources().removeAll(sourceParticipants);
                relationship.getTargets().addAll(sourceParticipants);
                return null;
            }
        };

        return executeAsTransaction(runnable, sourceParticipants, true);
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#moveTargetParticipantToSourceParticipant(java.util.List)
     */
    @Override
	public boolean moveTargetParticipantToSourceParticipant( final List targetParticipants ) {
        if (!canMoveTargetParticipantToSourceParticipant(targetParticipants)) {
            return false;
        }
        final TransactionRunnable runnable = new TransactionRunnable() {
            @Override
			public Object run( UnitOfWork uow ) {
                relationship.getTargets().removeAll(targetParticipants);
                relationship.getSources().addAll(targetParticipants);
                return null;
            }
        };

        return executeAsTransaction(runnable, targetParticipants, false);
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#canMoveSourceParticipantToTargetParticipant(java.util.List)
     */
    @Override
	public boolean canMoveSourceParticipantToTargetParticipant( final List objects ) {
        final Iterator iter = objects.iterator();
        while (iter.hasNext()) {
            final EObject element = (EObject)iter.next();
            if (!canMoveSourceParticipantToTargetParticipant(element)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#canMoveTargetParticipantToSourceParticipant(java.util.List)
     */
    @Override
	public boolean canMoveTargetParticipantToSourceParticipant( final List objects ) {
        final Iterator iter = objects.iterator();
        while (iter.hasNext()) {
            final EObject element = (EObject)iter.next();
            if (!canMoveTargetParticipantToSourceParticipant(element)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#canAddToTargetParticipants(java.util.List)
     */
    @Override
	public boolean canAddToTargetParticipants( final List objects ) {
        final Iterator iter = objects.iterator();
        while (iter.hasNext()) {
            final EObject element = (EObject)iter.next();
            if (!canAddToTargetParticipants(element)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#canAddToSourceParticipants(java.util.List)
     */
    @Override
	public boolean canAddToSourceParticipants( final List objects ) {
        final Iterator iter = objects.iterator();
        while (iter.hasNext()) {
            final EObject element = (EObject)iter.next();
            if (!canAddToSourceParticipants(element)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#addSourceParticipant(org.eclipse.emf.ecore.EObject)
     */
    @Override
	public void addSourceParticipant( final EObject newSourceParticipant ) throws ModelerCoreException {
        CoreArgCheck.isNotNull(newSourceParticipant);
        final EList values = this.relationship.getSources();
        ModelerCore.getModelEditor().addValue(this.relationship, newSourceParticipant, values);
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#addSourceParticipants(java.util.List)
     */
    @Override
	public void addSourceParticipants( final List newSourceParticipants ) throws ModelerCoreException {
        if (newSourceParticipants == null || newSourceParticipants.isEmpty()) {
            return;
        }
        final EList values = this.relationship.getSources();
        final TransactionRunnable runnable = new TransactionRunnable() {
            @Override
			public Object run( UnitOfWork uow ) throws ModelerCoreException {
                final Iterator iter = new ArrayList(newSourceParticipants).iterator();
                while (iter.hasNext()) {
                    final EObject newParticipant = (EObject)iter.next();
                    ModelerCore.getModelEditor().addValue(relationship, newParticipant, values);
                }
                return null;
            }
        };
        final Object[] params = new Object[] {new Integer(newSourceParticipants.size())};
        final String desc = RelationshipPlugin.Util.getString("RelationshipEditorImpl.Added_{0}_sources_to_relationship", params); //$NON-NLS-1$
        ModelerCore.getModelEditor().executeAsTransaction(runnable, desc, true, this);
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#removeSourceParticipant(org.eclipse.emf.ecore.EObject)
     */
    @Override
	public boolean removeSourceParticipant( final EObject sourceParticipant ) throws ModelerCoreException {
        CoreArgCheck.isNotNull(sourceParticipant);
        final EList values = this.relationship.getSources();
        if (!values.contains(sourceParticipant)) {
            return false;
        }
        ModelerCore.getModelEditor().removeValue(this.relationship, sourceParticipant, values);
        return true;
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#removeSourceParticipants(java.util.List)
     */
    @Override
	public boolean removeSourceParticipants( final List sourceParticipants ) throws ModelerCoreException {
        if (sourceParticipants == null || sourceParticipants.isEmpty()) {
            return false;
        }
        final EList values = this.relationship.getSources();
        final TransactionRunnable runnable = new TransactionRunnable() {
            @Override
			public Object run( UnitOfWork uow ) throws ModelerCoreException {
                final Iterator iter = new ArrayList(sourceParticipants).iterator();
                while (iter.hasNext()) {
                    final EObject participant = (EObject)iter.next();
                    if (values.contains(participant)) {
                        ModelerCore.getModelEditor().removeValue(relationship, participant, values);
                    }
                }
                return null;
            }
        };
        final Object[] params = new Object[] {new Integer(sourceParticipants.size())};
        final String desc = RelationshipPlugin.Util.getString("RelationshipEditorImpl.Removed_{0}_sources_from_relationship", params); //$NON-NLS-1$
        ModelerCore.getModelEditor().executeAsTransaction(runnable, desc, true, this);
        return true;
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#addTargetParticipant(org.eclipse.emf.ecore.EObject)
     */
    @Override
	public void addTargetParticipant( final EObject newTargetParticipant ) throws ModelerCoreException {
        CoreArgCheck.isNotNull(newTargetParticipant);
        final EList values = this.relationship.getTargets();
        ModelerCore.getModelEditor().addValue(this.relationship, newTargetParticipant, values);
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#addTargetParticipants(java.util.List)
     */
    @Override
	public void addTargetParticipants( final List newTargetParticipants ) throws ModelerCoreException {
        if (newTargetParticipants == null || newTargetParticipants.isEmpty()) {
            return;
        }
        final EList values = this.relationship.getTargets();
        final TransactionRunnable runnable = new TransactionRunnable() {
            @Override
			public Object run( UnitOfWork uow ) throws ModelerCoreException {
                final Iterator iter = new ArrayList(newTargetParticipants).iterator();
                while (iter.hasNext()) {
                    final EObject newParticipant = (EObject)iter.next();
                    ModelerCore.getModelEditor().addValue(relationship, newParticipant, values);
                }
                return null;
            }
        };
        final Object[] params = new Object[] {new Integer(newTargetParticipants.size())};
        final String desc = RelationshipPlugin.Util.getString("RelationshipEditorImpl.Added_{0}_targets_to_relationship", params); //$NON-NLS-1$
        ModelerCore.getModelEditor().executeAsTransaction(runnable, desc, true, this);
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#removeTargetParticipant(org.eclipse.emf.ecore.EObject)
     */
    @Override
	public boolean removeTargetParticipant( final EObject targetParticipant ) throws ModelerCoreException {
        CoreArgCheck.isNotNull(targetParticipant);
        final EList values = this.relationship.getTargets();
        if (!values.contains(targetParticipant)) {
            return false;
        }
        ModelerCore.getModelEditor().removeValue(this.relationship, targetParticipant, values);
        return true;
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#removeTargetParticipants(java.util.List)
     */
    @Override
	public boolean removeTargetParticipants( final List targetParticipants ) throws ModelerCoreException {
        if (targetParticipants == null || targetParticipants.isEmpty()) {
            return false;
        }
        final EList values = this.relationship.getTargets();
        final TransactionRunnable runnable = new TransactionRunnable() {
            @Override
			public Object run( UnitOfWork uow ) throws ModelerCoreException {
                final Iterator iter = new ArrayList(targetParticipants).iterator();
                while (iter.hasNext()) {
                    final EObject participant = (EObject)iter.next();
                    if (values.contains(participant)) {
                        ModelerCore.getModelEditor().removeValue(relationship, participant, values);
                    }
                }
                return null;
            }
        };
        final Object[] params = new Object[] {new Integer(targetParticipants.size())};
        final String desc = RelationshipPlugin.Util.getString("RelationshipEditorImpl.Removed_{0}_targets_from_relationship", params); //$NON-NLS-1$
        ModelerCore.getModelEditor().executeAsTransaction(runnable, desc, true, this);
        return true;
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#canSwapParticipants()
     */
    @Override
	public boolean canSwapParticipants() {
        final boolean sourcesToTargets = this.canAddToTargetParticipants(this.getSourceParticipants());
        if (!sourcesToTargets) {
            return false;
        }
        final boolean targetsToSources = this.canAddToSourceParticipants(this.getTargetParticipants());
        if (!targetsToSources) {
            return false;
        }
        return true;
    }

    /**
     * @see org.teiid.designer.relationship.RelationshipEditor#swapParticipants()
     */
    @Override
	public void swapParticipants() throws ModelerCoreException {
        final TransactionRunnable runnable = new TransactionRunnable() {
            @Override
			public Object run( UnitOfWork uow ) throws ModelerCoreException {
                final EList sources = (EList)getSourceParticipants();
                final EList targets = (EList)getTargetParticipants();
                final List oldSources = new ArrayList(sources);
                final List oldTargets = new ArrayList(targets);

                // Remove the existing targets ...
                Iterator iter = oldTargets.iterator();
                while (iter.hasNext()) {
                    final EObject obj = (EObject)iter.next();
                    ModelerCore.getModelEditor().removeValue(relationship, obj, targets);
                }

                // Remove the existing sources (and put them right into the targets) ...
                iter = oldSources.iterator();
                while (iter.hasNext()) {
                    final EObject obj = (EObject)iter.next();
                    ModelerCore.getModelEditor().removeValue(relationship, obj, sources);
                    ModelerCore.getModelEditor().addValue(relationship, obj, targets);
                }

                // Add the targets to the sources ...
                iter = oldTargets.iterator();
                while (iter.hasNext()) {
                    final EObject obj = (EObject)iter.next();
                    ModelerCore.getModelEditor().addValue(relationship, obj, sources);
                }

                return null;
            }
        };
        final Object[] params = new Object[] {relationship};
        final String desc = RelationshipPlugin.Util.getString("RelationshipEditorImpl.Swapped_participants", params); //$NON-NLS-1$
        ModelerCore.getModelEditor().executeAsTransaction(runnable, desc, true, this);
    }

    protected boolean executeAsTransaction( final TransactionRunnable runnable,
                                            final Object objectsBeingMoved,
                                            final boolean sourceToTarget ) {
        if (useTransactions) {
            String label = null;
            if (objectsBeingMoved instanceof List) {
            } else if (objectsBeingMoved instanceof EObject) {
                label = ModelerCore.getModelEditor().getName((EObject)objectsBeingMoved);
            } else {
                label = objectsBeingMoved.toString();
            }
            String role1 = null;
            String role2 = null;
            if (sourceToTarget) {
                role1 = this.getSourceRoleName();
                role2 = this.getTargetRoleName();
                if (role1 == null) {
                    role1 = RelationshipPlugin.Util.getString("RelationshipEditorImpl.DefaultSourceRoleName"); //$NON-NLS-1$
                }
                if (role2 == null) {
                    role2 = RelationshipPlugin.Util.getString("RelationshipEditorImpl.DefaultTargetRoleName"); //$NON-NLS-1$
                }
            } else {
                role1 = this.getTargetRoleName();
                role2 = this.getSourceRoleName();
                if (role1 == null) {
                    role1 = RelationshipPlugin.Util.getString("RelationshipEditorImpl.DefaultTargetRoleName"); //$NON-NLS-1$
                }
                if (role2 == null) {
                    role2 = RelationshipPlugin.Util.getString("RelationshipEditorImpl.DefaultSourceRoleName"); //$NON-NLS-1$
                }
            }
            final Object[] params = new Object[] {label, role1, role2};
            final String desc = RelationshipPlugin.Util.getString("RelationshipEditorImpl.MoveTransactionDescription", params); //$NON-NLS-1$
            try {
                ModelerCore.getModelEditor().executeAsTransaction(runnable, desc, true, this);
            } catch (ModelerCoreException e) {
                return false;
            }
            return true;
        }
        try {
            runnable.run(null);
        } catch (ModelerCoreException e) {
            return false;
        }
        return true;
    }

    protected boolean isExclusive() {
        final RelationshipType type = this.getRelationshipType();
        if (type != null) {
            return type.isExclusive();
        }
        return false;
    }

    protected boolean isTargetUnique() {
        final RelationshipRole role = this.relationship.getTargetRole();
        if (role != null) {
            return role.isUnique();
        }
        return false;
    }

    protected boolean isSourceUnique() {
        final RelationshipRole role = this.relationship.getSourceRole();
        if (role != null) {
            return role.isUnique();
        }
        return false;
    }

}
