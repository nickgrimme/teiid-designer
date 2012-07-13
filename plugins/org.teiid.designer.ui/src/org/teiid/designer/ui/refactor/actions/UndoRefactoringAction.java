/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.ui.refactor.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.actions.ActionDelegate;
import org.teiid.designer.ui.UiPlugin;
import org.teiid.designer.ui.actions.ModelerActionService;
import org.teiid.designer.ui.refactor.RefactorUndoListener;
import org.teiid.designer.ui.refactor.RefactorUndoManager;


/**
 * UndoRefactoringAction
 */
public class UndoRefactoringAction extends ActionDelegate 
    implements IWorkbenchWindowActionDelegate, IViewActionDelegate, RefactorUndoListener {

    private ModelerActionService actionService;
    private IAction action;

    /**
     * Construct an instance of UndoRefactoringAction.
     */
    public UndoRefactoringAction() {
        super();
        RefactorUndoManager.getInstance().addListener(this);
    }

    /* (non-Javadoc)
     * @see org.eclipse.ui.IViewActionDelegate#init(org.eclipse.ui.IViewPart)
     */
    @Override
	public void init(IViewPart view) {
        if ( actionService == null ) {
            this.actionService = (ModelerActionService) UiPlugin.getDefault().getActionService(view.getSite().getPage());
        }
    }

    /* (non-Javadoc)
     * @see org.eclipse.ui.IWorkbenchWindowActionDelegate#init(org.eclipse.ui.IWorkbenchWindow)
     */
    @Override
	public void init(IWorkbenchWindow window) {
        if ( actionService == null ) {
            this.actionService = (ModelerActionService) UiPlugin.getDefault().getActionService(window.getActivePage());
        }
        
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.ui.IActionDelegate2#dispose()
     */
    @Override
    public void dispose() {
        RefactorUndoManager.getInstance().removeListener(this);
        super.dispose();
    }

    /* (non-Javadoc)
     * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
     */
    @Override
    public void selectionChanged(IAction action, ISelection selection) {
        super.selectionChanged(action, selection);
        this.action = action;
        action.setEnabled(getUndoManager().canUndo());
        action.setText(getUndoManager().getUndoLabel());
    }

    /* (non-Javadoc)
     * @see org.teiid.designer.ui.refactor.RefactorUndoListener#stateChanged()
     */
    @Override
	public void stateChanged() {
        action.setEnabled(getUndoManager().canUndo());
        action.setText(getUndoManager().getUndoLabel());
    }

    private RefactorUndoManager getUndoManager() {
        if ( this.actionService == null ) {
            actionService = (ModelerActionService) UiPlugin.getDefault().getActionService(UiPlugin.getDefault().getCurrentWorkbenchWindow().getActivePage());
        }
        return actionService.getRefactorUndoManager();
    }

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	@Override
    public void run(IAction action) {
		getUndoManager().undo();
	}

}
