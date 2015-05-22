/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.utils;

/**
 * Manages free indexes in a table.
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.8 $
 */
public class IdManager extends IntIntSortedMap {
    protected int timeStamp = 0;
    protected int minId;
    protected int maxId;

    /**
     * Creates an empty manager.
     */
    public IdManager() {
        minId = 0;
        maxId = -1;
        assert (checkInvariant());
    }

    /**
     * Creates a manager for a table of a specified size.
     * 
     * @param size
     *            the size
     */
    public IdManager(int size) {
        minId = 0;
        maxId = size - 1;
        assert (checkInvariant());
    }

    /**
     * Creates a manager from another manager.
     * 
     * @param other
     *            the other manager
     */
    public IdManager(IdManager other) {
        super(other);
        minId = other.minId;
        maxId = other.maxId;
        assert (checkInvariant());
    }

    /**
     * Sets the manager to empty.
     */
    public void clear() {
        minId = 0;
        maxId = -1;
        super.clear();
        assert (checkInvariant());
    }

    /**
     * Returns the minimum managed index.
     * 
     * @return the minimum managed index
     */
    public int getMinId() {
        return minId;
    }

    /**
     * Returns the maximum managed index.
     * 
     * @return the maximum managed index
     */
    public int getMaxId() {
        return maxId;
    }

    /**
     * Returns true if a specified index is free.
     * 
     * @param id
     *            the index
     * @return true if a specified index is free
     */
    public boolean isFree(int id) {
        return id >= 0 && (id < minId || id > maxId || containsKey(id));
    }

    /**
     * Testing method.
     * 
     * @return true if the manager is valid.
     */
    public boolean checkInvariant() {
        if (isEmpty()) {
            return minId <= maxId || (minId == 0 && maxId == -1);
        }
        if (minId >= maxId)
            return false;
        for (RowIterator iter = keyIterator(); iter.hasNext();) {
            int f = iter.nextRow();
            if (f <= minId || f >= maxId)
                return false;
        }
        return true;
    }

    /**
     * Frees and index.
     * 
     * @param id
     *            the index
     */
    public void free(int id) {
        assert (checkInvariant());
        if (isFree(id))
            return;
        if (id == maxId) {
            while (!isEmpty() && lastKey() == (maxId - 1)) {
                maxId--;
                remove(maxId);
            }
            maxId--;
            if (isEmpty() && minId > maxId) {
                minId = 0;
                maxId = -1;
            }
        }
        else if (id == minId) {
            while (!isEmpty() && firstKey() == (minId + 1)) {
                minId++;
                remove(minId);
            }
            minId++;
            if (isEmpty() && minId > maxId) {
                minId = 0;
                maxId = -1;
            }
        }
        else {
            put(id, timeStamp++);
        }
        assert (checkInvariant());
    }

    /**
     * Allocates a new index.
     * 
     * @return the new index
     */
    public int newId() {
        int newId;
        if (isEmpty()) {
            if (minId == 0) {
                newId = ++maxId;
            }
            else
                newId = --minId;
        }
        else {
            newId = firstKey();
            remove(newId);
        }
        assert (checkInvariant());
        return newId;
    }

    /**
     * Returns the number of managed indexes.
     * 
     * @return the number of managed indexes
     */
    public int getIdCount() {
        return maxId - minId + 1 - size();
    }

    /**
     * Returns a RowIterator over the valid indexes.
     * 
     * @return a RowIterator over the valid indexes
     */
    public RowIterator iterator() {
        return new IdManagerIterator(this, true);
    }

    /**
     * Returns a RowIterator over the valid indexes in inverse order.
     * 
     * @return a RowIterator over the valid indexes in inverse order
     */
    public RowIterator reverseIterator() {
        return new IdManagerIterator(this, false);
    }

    /**
     * RowIterator over the valid indexes of an IdManager.
     * 
     * @author Jean-Daniel Fekete
     * @version $Revision: 1.8 $
     */
    public static class IdManagerIterator extends TableIterator {
        protected IdManager idManager;
        protected int       last = -1;

        IdManagerIterator(IdManager idManager, int first, int end, boolean up) {
            super(first, end, up);
            this.idManager = idManager;
        }

        IdManagerIterator(IdManager idManager, int first, int end) {
            this(idManager, first, end, first < end);
        }

        /**
         * Constructs an iterator from an IdManager.
         * 
         * @param idManager
         *            the IdManager
         * @param up
         *            true if going up
         */
        public IdManagerIterator(IdManager idManager, boolean up) {
            this(
                    idManager,
                    up ? idManager.getMinId() : idManager.getMaxId(),
                    up
                            ? (idManager.getMaxId() + 1)
                            : (idManager.getMinId() - 1),
                    up);
        }

        /**
         * {@inheritDoc}
         */
        public int nextRow() {
            last = row;
            do {
                super.nextRow();
            } while (idManager.containsKey(row));
            return last;
        }

        /**
         * {@inheritDoc}
         */
        public void remove() {
            idManager.free(last);
        }

    }
}
