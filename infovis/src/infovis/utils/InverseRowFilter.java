/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.utils;

/**
 * Inverse a RowFilter.
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.2 $
 */
public class InverseRowFilter implements RowFilter {
    protected RowFilter filter;
    
    /**
     * Constructor.
     * @param filter the filter to inverse.
     */
    public InverseRowFilter(RowFilter filter) {
        this.filter = filter;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isFiltered(int row) {
        return ! filter.isFiltered(row);
    }

}
