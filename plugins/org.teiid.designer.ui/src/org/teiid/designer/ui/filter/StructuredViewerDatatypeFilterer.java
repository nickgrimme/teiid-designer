/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.ui.filter;

import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.teiid.designer.core.ModelerCore;
import org.teiid.designer.ui.UiConstants;


/**
 * @since 8.0
 */
public class StructuredViewerDatatypeFilterer extends StructuredViewerFilterer implements IFilter {

    private static final String GROUP_TITLE = UiConstants.Util.getString("StructuredViewerDatatypeFilterer.title"); //$NON-NLS-1$
    private static final String BUTTON_BUILTIN = UiConstants.Util.getString("StructuredViewerDatatypeFilterer.builtin"); //$NON-NLS-1$
    private static final String BUTTON_USERDEF = UiConstants.Util.getString("StructuredViewerDatatypeFilterer.userdef"); //$NON-NLS-1$

    Button bltBtn;
    Button usrBtn;

    boolean showUser = true;
    private boolean showSimple = true;
    boolean showBuiltin = true;

    public void setAllowSimple( boolean allow ) {
        showSimple = allow;
        if (bltBtn != null) {
            updateFilter();
        } // endif
    }

    @Override
    public Control addControl( Composite parent,
                               FormToolkit ftk ) {
        Group grp = new Group(parent, SWT.NONE);
        if (ftk != null) {
            ftk.adapt(grp);
        } // endif
        grp.setText(GROUP_TITLE);
        GridLayout gl = new GridLayout();
        gl.numColumns = 2;
        grp.setLayout(gl);

        bltBtn = createButton(grp, ftk, BUTTON_BUILTIN);
        bltBtn.setSelection(true);
        usrBtn = createButton(grp, ftk, BUTTON_USERDEF);
        usrBtn.setSelection(true);

        // Add listener:
        SelectionListener sl = new SelectionListener() {
            @Override
			public void widgetSelected( SelectionEvent e ) {
                showUser = usrBtn.getSelection();
                showBuiltin = bltBtn.getSelection();
                scheduleUpdate();
            }

            @Override
			public void widgetDefaultSelected( SelectionEvent e ) {
            }
        }; // endanon
        bltBtn.addSelectionListener(sl);
        usrBtn.addSelectionListener(sl);
        updateFilter();

        return grp;
    }

    private Button createButton( Composite parent,
                                 FormToolkit ftk,
                                 String text ) {
        Button btn;

        if (ftk != null) {
            btn = ftk.createButton(parent, text, SWT.CHECK);
        } else {
            btn = new Button(parent, SWT.CHECK);
            btn.setText(text);
        } // endif

        return btn;
    }

    @Override
    protected ViewerFilter createViewerFilter() {
        return new ViewerFilter() {
            @Override
            public boolean select( Viewer viewer,
                                   Object parentElement,
                                   Object element ) {
                return StructuredViewerDatatypeFilterer.this.select(element);
            }
        }; // endanon ViewerFilter
    }

    @Override
    protected IFilter createVirtualFilter() {
        return this;
    }

    //
    // Implementation of IFilter methods:
    //
    @Override
	public boolean select( Object toTest ) {
        // quick cases:
        if (showBuiltin && showUser && showSimple) {
            // keep all:
            return true;
        } else if (!showBuiltin && !showUser && !showSimple) {
            // remove all:
            return false;
        } // endif

        XSDSimpleTypeDefinition std = (XSDSimpleTypeDefinition)toTest;
        // built-in:
        boolean isBuiltin = ModelerCore.getBuiltInTypesManager().isBuiltInDatatype(std);
        if (isBuiltin) {
            // ONLY remove builtin if instructed; we want to skip the other filters in this case:
            return showBuiltin;
        } // endif

        // Enterprise:
        if (showUser) {
            // we are showing user-defined types; filter simple types if needed:
            return showSimple || ModelerCore.getDatatypeManager(std).isEnterpriseDatatype(std);
            // interpreted, the above line returns true when we are showing all user-defined
            // types (we don't care whether simple or not), or, if not showSimple, the type
            // is an enterprise type.
        } // endif

        return false;
    }
}
