/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.utils;

/**
 * Holds a pair of double values for any purpose.
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.2 $
 */
public class DoublePair {
    /** The first value. */
    public double first;
    /** The second value. */
    public double second;
    
    /**
     * Constructor.
     */
    public DoublePair() {
    }

    /**
     * Constructor.
     * @param first the first value
     * @param second the second value
     */
    public DoublePair(double first, double second) {
        this.first = first;
        this.second = second;
    }
    
    /**
     * Constructor.
     * @param other the pair to copy
     */
    public DoublePair(DoublePair other) {
        this.first = other.first;
        this.second = other.second;
    }

    /**
     * Returns the first value.
     * @return the first value
     */
    public double getFirst() {
        return first;
    }

    /**
     * Sets the first value.
     * @param first the value
     */
    public void setFirst(double first) {
        this.first = first;
    }

    /**
     * Returns the second value.
     * @return the second value
     */
    public double getSecond() {
        return second;
    }

    /**
     * Sets the second value.
     * @param second the value
     */
    public void setSecond(double second) {
        this.second = second;
    }
}
