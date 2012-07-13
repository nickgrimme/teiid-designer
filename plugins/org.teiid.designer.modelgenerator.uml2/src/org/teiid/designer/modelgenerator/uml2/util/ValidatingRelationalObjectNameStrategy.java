/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.teiid.designer.modelgenerator.uml2.util;

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Property;
import org.teiid.core.util.CoreArgCheck;
import org.teiid.designer.core.validation.rules.StringNameValidator;
import org.teiid.designer.metamodels.relational.BaseTable;


/**
 * This naming strategy wraps another and ensures that the resulting name is considered a valid
 * Relational name.
 */
public class ValidatingRelationalObjectNameStrategy implements RelationalObjectNamingStrategy {

    private final RelationalObjectNamingStrategy delegate;
    private final StringNameValidator validator;

    /**
     * Construct an instance of ValidatingRelationalObjectNameStrategy.
     * @param strategy the actual strategy that will produce the name; may not be null
     */
    public ValidatingRelationalObjectNameStrategy(final RelationalObjectNamingStrategy strategy) {
        super();
        CoreArgCheck.isNotNull(strategy);
        this.delegate = strategy;
        this.validator = new StringNameValidator();
    }

    /**
     * @see org.teiid.designer.modelgenerator.uml2.util.RelationalObjectNamingStrategy#getNameForPrimaryKey(org.eclipse.uml2.Class, org.teiid.designer.metamodels.relational.BaseTable)
     */
    @Override
	public String getNameForPrimaryKey(Classifier klass, BaseTable table) {
        final String origName = this.delegate.getNameForPrimaryKey(klass,table);
        if ( origName == null ) {
            return null;
        }
        final String newName = this.validator.createValidName(origName,true);
        return newName != null ? newName : origName;
    }

    /**
     * @see org.teiid.designer.modelgenerator.uml2.util.RelationalObjectNamingStrategy#getNameForClassBaseTable(org.eclipse.uml2.Class)
     */
    @Override
	public String getNameForClassBaseTable(Classifier klass) {
        final String origName = this.delegate.getNameForClassBaseTable(klass);
        if ( origName == null ) {
            return null;
        }
        final String newName = this.validator.createValidName(origName,true);
        return newName != null ? newName : origName;
    }

    /**
     * @see org.teiid.designer.modelgenerator.uml2.util.RelationalObjectNamingStrategy#getNameForDatatypeTable(org.eclipse.uml2.Property, org.eclipse.uml2.DataType)
     */
    @Override
	public String getNameForDatatypeTable(Property referringProperty, DataType datatype) {
        final String origName = this.delegate.getNameForDatatypeTable(referringProperty,datatype);
        if ( origName == null ) {
            return null;
        }
        final String newName = this.validator.createValidName(origName,true);
        return newName != null ? newName : origName;
    }

    /**
     * @see org.teiid.designer.modelgenerator.uml2.util.RelationalObjectNamingStrategy#getNameForDatatypeValueColumn(org.eclipse.uml2.Property, org.eclipse.uml2.DataType)
     */
    @Override
	public String getNameForDatatypeValueColumn(Property referringProperty, DataType datatype, final String namingSuffix) {
        final String origName = this.delegate.getNameForDatatypeValueColumn(referringProperty,datatype, namingSuffix);
        if ( origName == null ) {
            return null;
        }
        final String newName = this.validator.createValidName(origName,true);
        return newName != null ? newName : origName;
    }

    /**
     * @see org.teiid.designer.modelgenerator.uml2.util.RelationalObjectNamingStrategy#getNameForCopiedPKColumn(org.teiid.designer.metamodels.relational.BaseTable, int)
     */
    @Override
	public String getNameForCopiedPKColumn(BaseTable fromTable, int i) {
        final String origName = this.delegate.getNameForCopiedPKColumn(fromTable,i);
        if ( origName == null ) {
            return null;
        }
        final String newName = this.validator.createValidName(origName,true);
        return newName != null ? newName : origName;
    }

    /**
     * @see org.teiid.designer.modelgenerator.uml2.util.RelationalObjectNamingStrategy#getNameForForeignKey(org.teiid.designer.metamodels.relational.BaseTable)
     */
    @Override
	public String getNameForForeignKey(BaseTable toTable) {
        final String origName = this.delegate.getNameForForeignKey(toTable);
        if ( origName == null ) {
            return null;
        }
        final String newName = this.validator.createValidName(origName,true);
        return newName != null ? newName : origName;
    }

    /**
     * @see org.teiid.designer.modelgenerator.uml2.util.RelationalObjectNamingStrategy#getNameForForeignKey(org.eclipse.uml2.Property, org.teiid.designer.metamodels.relational.BaseTable)
     */
    @Override
	public String getNameForForeignKey(Property property, BaseTable table) {
        final String origName = this.delegate.getNameForForeignKey(property,table);
        if ( origName == null ) {
            return null;
        }
        final String newName = this.validator.createValidName(origName,true);
        return newName != null ? newName : origName;
    }

    /**
     * @see org.teiid.designer.modelgenerator.uml2.util.RelationalObjectNamingStrategy#getNameForUnidirectionalIntersectTable(org.teiid.designer.metamodels.relational.BaseTable, org.teiid.designer.metamodels.relational.BaseTable, org.eclipse.uml2.Property)
     */
    @Override
	public String getNameForUnidirectionalIntersectTable( BaseTable fromTable, BaseTable toTable,
                                                          Property fromProperty) {
        final String origName = this.delegate.getNameForUnidirectionalIntersectTable(fromTable,toTable,fromProperty);
        if ( origName == null ) {
            return null;
        }
        final String newName = this.validator.createValidName(origName,true);
        return newName != null ? newName : origName;
    }

    /**
     * @see org.teiid.designer.modelgenerator.uml2.util.RelationalObjectNamingStrategy#getNameForColumn(org.eclipse.uml2.Property)
     */
    @Override
	public String getNameForColumn(Property property) {
        final String origName = this.delegate.getNameForColumn(property);
        if ( origName == null ) {
            return null;
        }
        final String newName = this.validator.createValidName(origName,true);
        return newName != null ? newName : origName;
    }

    /**
     * @see org.teiid.designer.modelgenerator.uml2.util.RelationalObjectNamingStrategy#getNameForArtificialPKColumn(int)
     */
    @Override
	public String getNameForArtificialPKColumn(int i) {
        final String origName = this.delegate.getNameForArtificialPKColumn(i);
        if ( origName == null ) {
            return null;
        }
        final String newName = this.validator.createValidName(origName,true);
        return newName != null ? newName : origName;
    }

    /**
     * @see org.teiid.designer.modelgenerator.uml2.util.RelationalObjectNamingStrategy#getNameForIntersectTableRepresentingAssociation(org.eclipse.uml2.Association)
     */
    @Override
	public String getNameForIntersectTableRepresentingAssociation(Association association) {
        final String origName = this.delegate.getNameForIntersectTableRepresentingAssociation(association);
        if ( origName == null ) {
            return null;
        }
        final String newName = this.validator.createValidName(origName,true);
        return newName != null ? newName : origName;
    }

}
