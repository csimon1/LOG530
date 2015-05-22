/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.utils;

/**
 * Row iterator filtered.
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.2 $
 */
public class FilteredRowIterator extends RowIteratorProxy {
    protected RowFilter filter;
    protected int next;
   
    /**
     * Constructor.
     * @param iterator the original iterator
     * @param filter the filter
     */
    public FilteredRowIterator(RowIterator iterator, RowFilter filter) {
        this(iterator,filter, -1);
        findNext();
    }
    
    protected FilteredRowIterator(
            RowIterator iterator, 
            RowFilter filter,
            int next) {
        super(iterator);
        this.filter = filter;
        this.next = next;
    }
    
    
    protected void findNext() {
        next = -1;
        while (super.hasNext()) {
            next = super.nextRow();
            if (! filter.isFiltered(next)) {
                break;
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public int nextRow() {
        int ret = next;
        findNext();
        return ret;
    }
    
    /**
     * {@inheritDoc}
     */
    public Object next() {
        return new Integer(nextRow());
    }

    /**
     * {@inheritDoc}
     */
    public boolean hasNext() {
        return next != -1;
    }

    /**
     * {@inheritDoc}
     */
    public int peekRow() {
        return next;
    }

    /**
     * {@inheritDoc}
     */
    public RowIterator copy() {
        return new FilteredRowIterator(iterator.copy(), filter, next);
    }
    
    /**
     * {@inheritDoc}
     */
    public void remove() {
        throw new RuntimeException("cannot remove from a FilteredRowIterator");
    }
}
