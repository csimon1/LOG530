/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.utils;

/**
 * Interface for filtering rows.
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.3 $
 */
public interface RowFilter {
    /**
     * Returns true if the specified row is
     * filtered out.
     * @param row the row
     * @return true if the specified row is
     * filtered out
     */
    boolean isFiltered(int row);
}
