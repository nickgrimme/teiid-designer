/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.mapping.ui.figure;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.teiid.designer.core.ModelerCore;
import org.teiid.designer.diagram.ui.DiagramUiConstants;
import org.teiid.designer.diagram.ui.DiagramUiPlugin;
import org.teiid.designer.diagram.ui.figure.AbstractDiagramFigureFactory;
import org.teiid.designer.diagram.ui.model.DiagramModelNode;
import org.teiid.designer.diagram.ui.notation.NotationFigureGenerator;
import org.teiid.designer.diagram.ui.notation.uml.model.UmlClassifierNode;
import org.teiid.designer.diagram.ui.util.colors.ColorPalette;
import org.teiid.designer.mapping.ui.PluginConstants;
import org.teiid.designer.mapping.ui.UiConstants;
import org.teiid.designer.mapping.ui.diagram.MappingDiagramUtil;
import org.teiid.designer.mapping.ui.editor.SummaryExtent;
import org.teiid.designer.mapping.ui.model.MappingDiagramNode;
import org.teiid.designer.mapping.ui.model.MappingExtentNode;
import org.teiid.designer.mapping.ui.model.SummaryExtentNode;
import org.teiid.designer.metamodels.diagram.Diagram;
import org.teiid.designer.metamodels.transformation.StagingTable;
import org.teiid.designer.transformation.ui.figure.TransformationFigure;
import org.teiid.designer.transformation.ui.model.TransformationNode;
import org.teiid.designer.ui.common.graphics.GlobalUiColorManager;


/**
 * MappingDiagramFigureFactory
 *
 * @since 8.0
 */

public class MappingDiagramFigureFactory extends AbstractDiagramFigureFactory implements UiConstants {
    private static final int EXTENT = 1;
    private static final int DIAGRAM = 0;
    private static final int STAGING_TABLE_EXTENT = 2;
    private static final int TRANSFORM = 3;
    private static final int SUMMARY_EXTENT = 4;

    /**
     * Construct an instance of UmlFigureFactory.
     */
    public MappingDiagramFigureFactory() {
        super();
    }

    @Override
    public Figure createFigure( Object modelObject,
                                String sNotationId ) {
        // System.out.println("[MappingDiagramFigureFactory.createFigure] modelObject: " + modelObject );

        Figure newFigure = null;

        switch (getObjectType(modelObject)) {

            case EXTENT:
            case DIAGRAM:
            case SUMMARY_EXTENT: { // jh Lyra enh: not sure about this
                newFigure = createFigure(modelObject);
            }
                break;

            // Delegate to the UML figure factory to make figures for all other model types.
            default: {
                // Here's where we get the notation manager and tell it to create a figure
                // for this modelObject. So it'll come back in whatever "Notation" it desires.
                NotationFigureGenerator generator = DiagramUiPlugin.getDiagramNotationManager().getFigureGenerator(sNotationId);
                if (modelObject instanceof UmlClassifierNode) {
                    // Check to see if it's a Staging table, then set the hideLocation to TRUE
                    EObject eObj = ((DiagramModelNode)modelObject).getModelObject();
                    if (MappingDiagramUtil.isMappingSqlTable(eObj)) {
                        // System.out.println("[MappingDiagramFigureFactory.createFigure] Is this a Staging Table? eObj: " + eObj
                        // );
                        ((DiagramModelNode)modelObject).setHideLocation(true);
                    }
                }
                if (generator != null) {
                    newFigure = generator.createFigure(modelObject);
                } else {
                    ModelerCore.Util.log(IStatus.ERROR, Util.getString(DiagramUiConstants.Errors.FIGURE_GENERATOR_FAILURE));
                }
            }
                break;

        }

        return newFigure;
    }

    @Override
    public Figure createFigure( Object modelObject ) {

        Figure newFigure = null;
        ColorPalette colorPalette = null;
        switch (getObjectType(modelObject)) {

            case DIAGRAM: {
                Diagram diagram = (Diagram)((DiagramModelNode)modelObject).getModelObject();
                if (MappingDiagramUtil.isDetailedDiagram(diagram)) {
                    newFigure = new MappingDiagramFigure();
                } else {
                    newFigure = new FreeformLayer();
                    newFigure.setLayoutManager(new FreeformLayout());
                    // Don't know why, but if you don't setOpaque(true), you cannot move by drag&drop!
                    newFigure.setOpaque(true);
                    RGB currentBkgdColor = PreferenceConverter.getColor(DiagramUiPlugin.getDefault().getPreferenceStore(),
                                                                        PluginConstants.Prefs.Appearance.MAPPING_BKGD_COLOR);
                    newFigure.setBackgroundColor(GlobalUiColorManager.getColor(currentBkgdColor));
                }
            }
                break;

            case EXTENT: {
                // We need to get the color palette for the staging table instead of the location
                MappingExtentNode mExtentNode = (MappingExtentNode)modelObject;
                colorPalette = getColorPalette(((DiagramModelNode)modelObject).getModelObject());

                // set default color for non-standard MappingExtents
                if (!mExtentNode.getExtent().isCompletelyMapped()) {
                    if (mExtentNode.getExtent().isMappingRequired()) {
                        // newFigure.setBackgroundColor( ColorConstants.red );
                        // set 'required'/unmapped to red
                        colorPalette.setColor(ColorPalette.PRIMARY_BKGD_COLOR_ID, UiConstants.Colors.REQUIRES_MAPPING);
                        colorPalette.setColor(ColorPalette.OUTLINE_COLOR_ID, ColorConstants.black);
                    } else {
                        // set 'not required'/unmapped to yellow
                        colorPalette.setColor(ColorPalette.PRIMARY_BKGD_COLOR_ID, UiConstants.Colors.UNMAPPED);
                        colorPalette.setColor(ColorPalette.OUTLINE_COLOR_ID, ColorConstants.black);
                    }
                }
                newFigure = new MappingExtentFigure(null, colorPalette);

            }
                break;

            case STAGING_TABLE_EXTENT: {
                // We need to get the color palette for the staging table instead of the location
                MappingExtentNode mExtentNode = (MappingExtentNode)modelObject;
                EObject mappingRefEObject = mExtentNode.getExtent().getMappingReference();

                if (mappingRefEObject != null && mappingRefEObject instanceof StagingTable) {
                    colorPalette = getColorPalette(mappingRefEObject);
                }
                if (colorPalette == null) {
                    colorPalette = getColorPalette(((DiagramModelNode)modelObject).getModelObject());
                }

                newFigure = new MappingExtentFigure(null, colorPalette);
            }
                break;

            case TRANSFORM: {
                colorPalette = getColorPalette(((DiagramModelNode)modelObject).getModelObject());
                newFigure = new TransformationFigure((TransformationNode)modelObject, "T", colorPalette); //$NON-NLS-1$
            }
                break;

            case SUMMARY_EXTENT: {
                /*
                 * jh Lyra enh: In old code EXTENT is lumped in with Staging Table; I have
                 *              given the new SUMMARY EXTENT its own.  You might clean up the other
                 *              before you are done.
                 */

                // System.out.println("[MappingDiagramFigureFactory.createFigure#SUMMARY_EXTENT] ");
                // We need to get the color palette for the Summary Extent instead of the location
                SummaryExtentNode sExtentNode = (SummaryExtentNode)modelObject;
                SummaryExtent seExtent = (SummaryExtent)sExtentNode.getExtent(); // MappingExtent

                colorPalette = getColorPalette(((DiagramModelNode)modelObject).getModelObject());

                // Looks like we'll need to pass the style in the constructor
                Image imgImage = sExtentNode.getImage();
                int iImagePosition = sExtentNode.getImagePosition();

                newFigure = new SummaryExtentFigure(seExtent.getMappingClassColumnCount(), seExtent.getUnmappedNodeCount(),
                                                    colorPalette, seExtent.getSomeMappingClassesAreVisible(), imgImage,
                                                    iImagePosition);

            }
                break;

            // Delegate to the UML figure factory to make figures for all other model types.
            default: {
            }
                break;

        }

        return newFigure;
    }

    protected int getObjectType( Object modelObject ) {
        // System.out.println("\n\n\n[MappingDiagramFigureFactory.getObjectType] TOP");
        int objectType = -1;

        if (modelObject != null) {
            if (modelObject instanceof MappingDiagramNode) {
                objectType = DIAGRAM;
            } else if (modelObject instanceof SummaryExtentNode) {
                // special trick: because SummaryExtentNode is a subclass of MappingExtentNode,
                // we must test for it first, otherwise all SummaryExtentNodes
                // will pass the MappingExtentNode instanceof test and be treated
                // like MappingExtentNodes.
                objectType = SUMMARY_EXTENT;
            } else if (modelObject instanceof MappingExtentNode) {
                if (((MappingExtentNode)modelObject).getExtent().getMappingReference() instanceof StagingTable) {
                    objectType = STAGING_TABLE_EXTENT;
                } else {
                    objectType = EXTENT;
                }
            } else if (modelObject instanceof TransformationNode) {
                objectType = TRANSFORM;
            }
        }

        return objectType;
    }

    private ColorPalette getColorPalette( EObject eObject ) {
        return DiagramUiPlugin.getDiagramTypeManager().getDiagram(PluginConstants.MAPPING_DIAGRAM_TYPE_ID).getColorPaletteManager().getColorPalette(eObject);
    }
}
