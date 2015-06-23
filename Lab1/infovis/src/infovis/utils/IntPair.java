/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.utils;

/**
 * Holds a pair of int values for any purpose.
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.2 $
 */
public class IntPair {
    /** The first value. */
    public int first;
    /** The second value. */
    public int second;
    
    /**
     * Constructor.
     */
    public IntPair() {
    }

    /**
     * Constructor.
     * @param first the first value
     * @param second the second value
     */
    public IntPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
    
    /**
     * Constructor.
     * @param other the pair to copy
     */
    public IntPair(IntPair other) {
        this.first = other.first;
        this.second = other.second;
    }

    /**
     * Returns the first value.
     * @return the first value
     */
    public int getFirst() {
        return first;
    }

    /**
     * Sets the first value.
     * @param first the value
     */
    public void setFirst(int first) {
        this.first = first;
    }

    /**
     * Returns the second value.
     * @return the second value
     */
    public int getSecond() {
        return second;
    }

    /**
     * Sets the second value.
     * @param second the value
     */
    public void setSecond(int second) {
        this.second = second;
    }
}