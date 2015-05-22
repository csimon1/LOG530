/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.utils;

import infovis.Table;

/**
 * RowObject is used to translate InfoVis table rows into
 * Java objects when required. 
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.2 $
 */

public class RowObject {
    protected Table table;
    protected int row;
    
    /**
     * Creates a reference to a row in a table.
     * @param table the table
     * @param row the row
     */
    public RowObject(Table table, int row) {
        this.table = table;
        this.row = row;
    }
    
    /**
     * Returns the row.
     * @return the row
     */
    public int getRow() {
        return row;
    }
    
    /**
     * Returns the table.
     * @return the table
     */
    public Table getTable() {
        return table;
    }
    
    /**
     * Returns the row associated with a RowObject
     * seen as an Object.
     * @param table the table
     * @param obj the object
     * @return the row associated with a RowObject
     */
    public static int getRow(Table table, Object obj) {
        if (obj instanceof RowObject) {
            RowObject ro = (RowObject) obj;
            assert(table == null || table == ro.getTable());
            return ro.getRow();
        }
        else {
            return Table.NIL;
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean equals(Object obj) {
        if (obj instanceof RowObject) {
            RowObject ro = (RowObject) obj;
            return ro.table == table && ro.row == row;
        }
        return false;
    }
    
    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        return table.hashCode() + row;
    }
}