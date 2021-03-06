/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.core.compare;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.mapping.Mapping;
import org.eclipse.emf.mapping.MappingFactory;
import org.teiid.designer.metamodels.core.Annotation;

/**
 * CoreAnnotationMatcher
 *
 * @since 8.0
 */
public class CoreAnnotationMatcher extends AbstractEObjectMatcher implements TwoPhaseEObjectMatcher {

    /**
     * Construct an instance of CoreAnnotationMatcher.
     * 
     */
    public CoreAnnotationMatcher() {
        super();
    }

    /**
     * @see org.teiid.designer.core.compare.EObjectMatcher#addMappingsForRoots(java.util.List, java.util.List, org.eclipse.emf.mapping.Mapping, org.eclipse.emf.mapping.MappingFactory)
     */
    @Override
	public void addMappingsForRoots(final List inputs, final List outputs,
                                    final Map inputsToOutputs, 
                                    final Mapping mapping, final MappingFactory factory) {
        // do nothing for roots ...
    }

    /**
     * @see org.teiid.designer.core.compare.EObjectMatcher#addMappings(org.eclipse.emf.ecore.EReference, java.util.List, java.util.List, org.eclipse.emf.mapping.Mapping, org.eclipse.emf.mapping.MappingFactory)
     */
    @Override
	public void addMappings( final EReference reference, final List inputs, final List outputs, 
                             final Map inputsToOutputs, 
                             final Mapping mapping, final MappingFactory factory) {
        final Map inputAnnotationsByAnnotatedObject = new HashMap();

        // Loop over the inputs and find any of the above objects ...
        final Iterator iter = inputs.iterator();
        while (iter.hasNext()) {
            final Annotation ann = (Annotation)iter.next();
            final EObject annotatedObject = ann.getAnnotatedObject();
            if ( annotatedObject != null ) {
                final Object outputAnnotatedObject = inputsToOutputs.get(annotatedObject);
                inputAnnotationsByAnnotatedObject.put(outputAnnotatedObject,ann);
            }
        }
        
        // Loop over the outputs and find matches for any of the above objects ...
        final Iterator outputIter = outputs.iterator();
        while (outputIter.hasNext()) {
            final Annotation annotation = (Annotation)outputIter.next();
            final EObject annotatedObject = annotation.getAnnotatedObject();
            if ( annotatedObject != null ) {
                final Annotation inputAnn = (Annotation)inputAnnotationsByAnnotatedObject.get(annotatedObject);
                if ( inputAnn != null ) {
                    inputs.remove(inputAnn);
                    outputIter.remove();
                    addMapping(inputAnn,annotation,mapping,factory);
                    inputsToOutputs.put(inputAnn,annotation);
                }
            }
        }
        
    }

    /**
     * @see org.teiid.designer.core.compare.EObjectMatcher#addMappingsForRoots(java.util.List, java.util.List, org.eclipse.emf.mapping.Mapping, org.eclipse.emf.mapping.MappingFactory)
     */
    @Override
	public void addMappingsForRoots(List inputs, List outputs, Mapping mapping, MappingFactory factory) {
        // do nothing for the first phase ...
    }

    /**
     * @see org.teiid.designer.core.compare.EObjectMatcher#addMappings(org.eclipse.emf.ecore.EReference, java.util.List, java.util.List, org.eclipse.emf.mapping.Mapping, org.eclipse.emf.mapping.MappingFactory)
     */
    @Override
	public void addMappings(EReference reference, List inputs, List outputs, Mapping mapping, MappingFactory factory) {
        // do nothing for the first phase ...
    }

}
