/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.utils;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Case insensitive comparator for strings.
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.5 $
 */
public class CaseInsensitiveComparator implements Comparator, Serializable {
    /** The static instance. */
    public static final CaseInsensitiveComparator instance = new CaseInsensitiveComparator();
    
    /**
     * Returns the static instance.
     * @return the static instance
     */
    public static CaseInsensitiveComparator getInstance() {
        return instance;
    }
    
    /**
     * Compares the two strings.
     * @param o1 the first string as object
     * @param o2 the second string as object
     * @return a positive value if the first string
     * is greater than the second, 0 if they are equal,
     * a negative value if the first is less.
     */
    public int compare(Object o1, Object o2) {
        String s1 = (String) o1;
        String s2 = (String) o2;
        
        return s1.compareToIgnoreCase(s2);
    }
}
