/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.relationship.ui.navigation.actions;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.teiid.designer.core.ModelerCore;
import org.teiid.designer.relationship.NavigationLink;
import org.teiid.designer.relationship.NavigationNode;
import org.teiid.designer.relationship.ui.UiConstants;
import org.teiid.designer.relationship.ui.UiPlugin;
import org.teiid.designer.ui.UiConstants.Extensions;
import org.teiid.designer.ui.common.eventsupport.SelectionUtilities;
import org.teiid.designer.ui.common.util.UiUtil;
import org.teiid.designer.ui.common.util.WidgetUtil;
import org.teiid.designer.ui.explorer.ModelExplorerResourceNavigator;


/**
 * NavigateToAction
 */
public class NavigateToAction extends Action implements ISelectionListener, UiConstants.Images {

    private static final String LABEL = UiConstants.Util.getString("NavigateToAction.label"); //$NON-NLS-1$
    private static final String TOOLTIP = UiConstants.Util.getString("NavigateToAction.tooltip"); //$NON-NLS-1$

    private ISelectionProvider selectionProvider;
    private URI selectedUri;

    /**
     * Construct an instance of NavigateToAction.
     */
    public NavigateToAction(ISelectionProvider selectionProvider) {
        super();
        this.selectionProvider = selectionProvider;
        setText(LABEL);
        setToolTipText(TOOLTIP);
        setImageDescriptor(UiPlugin.getDefault().getImageDescriptor(FIND));
        setEnabled(false); 
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.action.IAction#run()
     */
    @Override
    public void run() {
        try {
            // resolve the object
            EObject obj = ModelerCore.getModelContainer().getEObject(selectedUri, true);
            // send the selected EObject as a new selection in the workbench
            final ISelection selection = new StructuredSelection(obj);
            selectionProvider.setSelection(selection);
            // activate the Model Explorer view (must do this last)
            Display.getCurrent().asyncExec(new Runnable() {
                @Override
				public void run() {
                    try {
                        ModelExplorerResourceNavigator view = 
                            (ModelExplorerResourceNavigator) UiUtil.getWorkbenchPage().showView(Extensions.Explorer.VIEW);
                        view.getTreeViewer().setSelection(selection);
                    } catch (PartInitException err) {
                        UiConstants.Util.log(err);
                        WidgetUtil.showError(err.getLocalizedMessage());
                    }
                }
            });
        } catch (Exception err) {
            UiConstants.Util.log(err);
            WidgetUtil.showError(err.getLocalizedMessage());
        }
    }

    /* (non-Javadoc)
     * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart, org.eclipse.jface.viewers.ISelection)
     */
    @Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
        setEnabled(false);
        if ( SelectionUtilities.isSingleSelection(selection) ) {
            Object selectedObject = SelectionUtilities.getSelectedObject(selection);
            if ( selectedObject instanceof NavigationNode ) {
                this.selectedUri = ((NavigationNode) selectedObject).getModelObjectUri();
                setEnabled(selectedUri != null);
            } else if ( selectedObject instanceof NavigationLink ) {
                this.selectedUri = ((NavigationLink) selectedObject).getModelObjectUri();
                // there may not be a model object representing this link, so check
                setEnabled(this.selectedUri != null);
            }
        }
    }

}
