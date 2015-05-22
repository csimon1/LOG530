/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.utils;

import java.util.Iterator;


/**
 * Iterator over rows on Columns or Tables.
 * 
 * Two new methods provide a faster access to the rows, instead of
 * creating an Integer object at each invocation.
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.8 $
 */
public interface RowIterator extends Iterator {
    /**
     * Returns the next row after incrementing the iterator.
     *
     * @return the next row.
     */
    int nextRow();

    /**
     * Returns the next row without incrementing the iterator.
     *
     * @return the next row.
     */
    int peekRow();
    
    /**
     * Clone myself with the right type returned.
     * 
     * @return a copy of myself.
     */
    RowIterator copy();
}
