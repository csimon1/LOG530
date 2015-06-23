/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.utils;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Shape managing a list of non-overlaping shapes.
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.3 $
 */
public class CompositeShape implements Shape {
    protected ArrayList shapes;
    
    /**
     * Constructor.
     */
    public CompositeShape() {
        this.shapes = new ArrayList();
    }

    /**
     * Adds a shape.
     * @param s the shape
     */
    public void addShape(Shape s) {
        //assert(! intersects(s.getBounds2D()));
        shapes.add(s);
    }

    /**
     * Returns the shape at the specified index.
     * @param i the index
     * @return the shape at the specified index
     */
    public Shape getShape(int i) {
        return (Shape)shapes.get(i);
    }
    
    /**
     * Returns the number of shapes contained in
     * that composite.
     * @return the number of shapes contained in
     * that composite
     */
    public int getShapeCount() {
        return shapes.size();
    }

    /**
     * {@inheritDoc}
     */
    public boolean contains(double x, double y) {
        for (int i = 0; i < shapes.size(); i++) {
            if (getShape(i).contains(x, y)) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public boolean contains(double x, double y, double w, double h) {
        for (int i = 0; i < shapes.size(); i++) {
            if (getShape(i).contains(x, y, w, h)) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public boolean intersects(double x, double y, double w, double h) {
        for (int i = 0; i < shapes.size(); i++) {
            if (getShape(i).intersects(x, y, w, h)) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public Rectangle getBounds() {
        Rectangle rect = getShape(0).getBounds();
        for (int i = 1; i < shapes.size(); i++) {
            rect.add(getShape(i).getBounds());
        }
        return rect;
    }

    /**
     * {@inheritDoc}
     */
    public boolean contains(Point2D p) {
        for (int i = 0; i < shapes.size(); i++) {
            if (getShape(i).contains(p)) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public Rectangle2D getBounds2D() {
        Rectangle2D rect = getShape(0).getBounds2D();
        for (int i = 1; i < shapes.size(); i++) {
            rect.add(getShape(i).getBounds2D());
        }
        return rect;
    }

    /**
     * {@inheritDoc}
     */
    public boolean contains(Rectangle2D r) {
        for (int i = 0; i < shapes.size(); i++) {
            if (getShape(i).contains(r)) {
                return true;
            }
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public boolean intersects(Rectangle2D r) {
        for (int i = 0; i < shapes.size(); i++) {
            if (getShape(i).intersects(r)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Iterator class over the paths in this composite.
     * 
     * @author Jean-Daniel Fekete
     * @version $Revision: 1.3 $
     */
    public class CompositePathIterator implements PathIterator {
        protected int currentPath;
        protected PathIterator current;
        protected AffineTransform at;
        protected double flatness;
        
        /**
         * Constructor.
         * @param at the transform
         * @param flatness the flatness
         */
        public CompositePathIterator(AffineTransform at, double flatness) {
            this.at = at;
            this.flatness = flatness; 
            currentPath = 0;
            if (flatness == -1)
                current = getShape(currentPath++).getPathIterator(at);
            else
                current = getShape(currentPath++).getPathIterator(at, flatness);
        }
        
        /**
         * Constructor.
         * @param at the transform
         */
        public CompositePathIterator(AffineTransform at) {
            this(at, -1);
        }

        /**
         * {@inheritDoc}
         */
        public int currentSegment(double[] coords) {
            return current.currentSegment(coords);
        }
        /**
         * {@inheritDoc}
         */
        public int currentSegment(float[] coords) {
            return current.currentSegment(coords);
        }
        /**
         * {@inheritDoc}
         */
        public int getWindingRule() {
            return current.getWindingRule();
        }
        /**
         * {@inheritDoc}
         */
        public boolean isDone() {
            if (current.isDone()) {
                if (currentPath == getShapeCount()) {
                    return true;
                }
                if (flatness == -1)
                    current = getShape(currentPath++).getPathIterator(at);
                else
                    current = getShape(currentPath++).getPathIterator(at, flatness);
            }
            return false;
        }
        /**
         * {@inheritDoc}
         */
        public void next() {
            if (isDone()) return;
            current.next();
        }
    }

    /**
     * {@inheritDoc}
     */    
    public PathIterator getPathIterator(AffineTransform at) {
        return new CompositePathIterator(at);
    }

    /**
     * {@inheritDoc}
     */
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return new CompositePathIterator(at, flatness);
    }
}
