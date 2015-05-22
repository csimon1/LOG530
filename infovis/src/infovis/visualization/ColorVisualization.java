/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.visualization;

import infovis.Column;

import java.awt.Color;

import javax.swing.event.ChangeListener;


/**
 * Color Visualizations transform the contents of a column into colors.
 *
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.14 $
 */
public abstract class ColorVisualization implements ChangeListener {
    protected Column colorColumn;

    /**
     * Constructor.
     * @param column the column
     */
    public ColorVisualization(Column column) {
        setColumn(column);
    }
    
    /**
     * Returns the managed Column.
     *
     * @return the managed Column.
     */
    public Column getColumn() {
        return colorColumn;
    }

    /**
     * Sets the managed column.
     * 
     * @param c the new column to manage
     */
    public void setColumn(Column c) {
        if (colorColumn == c) return;
        if (colorColumn != null) {
            colorColumn.removeChangeListener(this);
        }
        colorColumn = c;
        if (colorColumn != null) {
            colorColumn.addChangeListener(this);
        }
        stateChanged(null);
    }

    /**
     * Returns the color value omputed for the specified row.
     *
     * <p>Color are coded as a 32bits integers.  If the
     * color is coded with red, green, blue and alpha
     * floating point values between 0 and 1, the
     * returned value is:
     * <code>
     *         ((((int)(a * 255)) & 0xFF) << 24) |
     *         ((((int)(r * 255)) & 0xFF) << 16) |
     *         ((((int)(g * 255)) & 0xFF) << 8) |
     *         ((((int)(b * 255)) & 0xFF) << 0);
     * </code>
     *
     * @param row the row
     * @return the color computed for the specified row.
     */
    public abstract int getColorValue(int row);
    
    /**
     * Returns a color for the specified row.
     * @param row the row
     * @return a color for the specified row
     */
    public Color getColor(int row) {
        return new Color(getColorValue(row), true);
    }

    /**
     * Convert r,g,b,a float values into an int.
     *
     * @param r red component
     * @param g green component
     * @param b blue component
     * @param a alpha component
     *
     * @return the int value for the specified components
     */
    public static int computeColor(double r, double g, double b, double a) {
        return ((((int)(a * 255)) & 0xFF) << 24) |
               ((((int)(r * 255)) & 0xFF) << 16) |
               ((((int)(g * 255)) & 0xFF) << 8) |
               ((((int)(b * 255)) & 0xFF) << 0);
    }
    
    /**
     * Returns the color complement of the specified color.
     * @param c the color
     * @return the color complement of the specified color.
     */
    public static Color colorComplement(Color c) {
        return new Color(255-c.getRed(), 255-c.getGreen(), 255-c.getBlue());
    }
}
