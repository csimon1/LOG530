/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.utils;

/**
 * Row iterator over an array of ints.
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.4 $
 */

public class ArrayChildrenIterator extends AbstractRowIterator {
    protected int index;
    protected int[] children;

    /**
     * Constructor.
     * @param index the initial index
     * @param children the array
     */
    public ArrayChildrenIterator(int index, int[] children) {
        this.index = index;
        this.children = children;
    }

    /**
     * Constructor.
     * @param children the array
     */
    public ArrayChildrenIterator(int[] children) {
        this(0, children);
    }

    /**
     * {@inheritDoc}
     */
    public boolean hasNext() {
        return index < children.length;
    }

    /**
     * {@inheritDoc}
     */
    public void remove() {
        throw new RuntimeException("Cannot remove tree node");
    }

    /**
     * {@inheritDoc}
     */
    public int nextRow() {
        if (index >= children.length)
            return -1;
        return children[index++];
    }

    /**
     * {@inheritDoc}
     */
    public int peekRow() {
        if (index >= children.length)
            return -1;
        return children[index];
    }
    /**
     * {@inheritDoc}
     */
    public RowIterator copy() {
        return new ArrayChildrenIterator(index, children);
    }

}