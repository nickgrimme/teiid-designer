/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.relationship.ui.navigation.actions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.teiid.designer.core.ModelerCore;
import org.teiid.designer.core.container.Container;
import org.teiid.designer.relationship.NavigationLink;
import org.teiid.designer.relationship.NavigationNode;
import org.teiid.designer.relationship.ui.UiConstants;
import org.teiid.designer.ui.common.eventsupport.SelectionUtilities;
import org.teiid.designer.ui.common.util.WidgetUtil;
import org.teiid.designer.ui.editors.ModelEditorManager;


/**
 * EditWrapperAction is a wrapper class for the global Edit action in the NavigatorView.  
 * It is necessary because the NavigationView does not fire selection events to the
 * Workbench where the global action could hear it.
 */
public class EditWrapperAction extends Action implements ISelectionListener {

    private static final String LABEL = UiConstants.Util.getString("EditWrapperAction.label"); //$NON-NLS-1$
    private static final String TOOLTIP = UiConstants.Util.getString("EditWrapperAction.tooltip"); //$NON-NLS-1$

    private URI selectedURI;

    /**
     * Construct an instance of EditWrapperAction.
     */
    public EditWrapperAction() {
        super();
        setText(LABEL);
        setToolTipText(TOOLTIP);
    }

    /* (non-Javadoc)
     * @see org.eclipse.ui.ISelectionListener#selectionChanged(IWorkbenchPart, ISelection)
     */
    @Override
	public void selectionChanged(IWorkbenchPart thePart,
                                 ISelection theSelection) {
        determineEnablement(theSelection);
    }

    @Override
    public void run() {
        Container container;
        try {
            container = ModelerCore.getModelContainer();
            EObject selectedObject = container.getEObject(selectedURI, true);
            if ( ModelEditorManager.canEdit(selectedObject) ) {
                ModelEditorManager.edit(selectedObject);
            } else {
                ModelEditorManager.open(selectedObject, true);
            }
        } catch (CoreException e) {
            UiConstants.Util.log(e);
            WidgetUtil.showError(e.getLocalizedMessage());
        }
    }
    
    private void determineEnablement(ISelection selection) {
        boolean enable = false;
        selectedURI = null;
        if( SelectionUtilities.isSingleSelection(selection)) {
            Object o = SelectionUtilities.getSelectedObject(selection);
            if ( o instanceof NavigationNode ) {
                selectedURI = ((NavigationNode) o).getModelObjectUri();   
                enable = true;
            } else if ( o instanceof NavigationLink ) {
                selectedURI = ((NavigationLink) o).getModelObjectUri();   
                enable = true;
            }
        }
        setEnabled(enable);
    }
    
    /* (non-Javadoc)
     * @see org.teiid.designer.ui.actions.ModelObjectAction#requiresEditorForRun()
     */
    protected boolean requiresEditorForRun() {
        return true;
    }

}
