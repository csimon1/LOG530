/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.utils;

/**
 * Proxy over a RowIterator.
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.2 $
 */
public class RowIteratorProxy implements RowIterator {
    protected RowIterator iterator;

    /**
     * Create the proxy.
     * @param iterator the original iterator
     */
    public RowIteratorProxy(RowIterator iterator) {
        this.iterator = iterator;
    }

    /**
     * {@inheritDoc}
     */
    public RowIterator copy() {
        return new RowIteratorProxy(iterator.copy());
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean hasNext() {
        return iterator.hasNext();
    }
    /**
     * {@inheritDoc}
     */
    public Object next() {
        return iterator.next();
    }
    /**
     * {@inheritDoc}
     */
    public int nextRow() {
        return iterator.nextRow();
    }
    /**
     * {@inheritDoc}
     */
    public int peekRow() {
        return iterator.peekRow();
    }
    /**
     * {@inheritDoc}
     */
    public void remove() {
        iterator.remove();
    }
    /**
     * {@inheritDoc}
     */
    public String toString() {
        return iterator.toString();
    }
}
