/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.utils;

/**
 * Inverse the order of a comparator.
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.2 $
 */
public class InverseRowComparator implements RowComparator {
    protected RowComparator comparator;
    
    /**
     * Constructor.
     * @param comparator the comparator to reverse or null.
     */
    public InverseRowComparator(RowComparator comparator) {
        this.comparator = comparator;
    }
    
    /**
     * {@inheritDoc}
     */
    public int compare(int row1, int row2) {
        if (comparator == null) {
            return row2 - row1;
        }
        return comparator.compare(row2, row1);
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean isValueUndefined(int row) {
        if (comparator == null)
            return false;
        return comparator.isValueUndefined(row);
    }
    
    /**
     * Returns the comparator.
     * @return the comparator
     */
    public RowComparator getComparator() {
        return comparator;
    }

}
