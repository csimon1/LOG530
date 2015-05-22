/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.utils;

/**
 * Generate a double value for a specified row.
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.2 $
 */
public interface RowDoubleValueGenerator {
    /**
     * Generates a value of the specified row.
     * 
     * @param row the row
     * @return a value of the specified row
     */
    double generate(int row);
}
