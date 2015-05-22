/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.utils;

/**
 * Row comparator for comparing the row indices.
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.2 $
 */
public class IdRowComparator implements RowComparator {
    private static final IdRowComparator instance = new IdRowComparator();

    /**
     * Returns the instance.
     * @return the instance
     */
    public static IdRowComparator getInstance() {
        return instance;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isValueUndefined(int row) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public int compare(int a, int b) {
        return a-b;
    }

}
