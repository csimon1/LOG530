/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.panel.color;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.Icon;

import org.apache.log4j.Logger;

/**
 * Manage Color ramps by name and load/save them from resource
 * files.
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.4 $
 */
public class ColorScheme implements Icon {
    /** Name of the resource for loading color schemes. */
    public static final String RESOURCE_NAME = "colorschemes";
    private static Logger logger = Logger.getLogger(ColorScheme.class);
    protected String name;
    protected Color [] ramp;
    private static ColorScheme[] schemes;
   
    /**
     * Constructs a named color scheme.
     * @param name the name
     * @param start the starting color
     * @param end the ending color
     */
    public ColorScheme(String name, Color start, Color end) {
        this.name = name;
        ramp = new Color[2];
        ramp[0] = start;
        ramp[1] = end;
    }

    /**
     * Constructs a named color scheme.
     * @param name the name
     * @param ramp a table or colors
     */
    public ColorScheme(String name, Color[] ramp) {
        this.name = name;
        this.ramp = (Color[])ramp.clone();
    }

    /**
     * Parses a string containing the specification of
     * a color as three integers separated by a comma.
     * 
     * @param spec the color specification
     * @return a color
     */
    public static Color parseColor(String spec) {
        String[] fields = spec.split(",");
        if (fields.length != 3) {
            logger.error("Expected 3 integer fields for color, received "+spec);
            return null;
        }
        try {
            int r = Integer.parseInt(fields[0].trim());
            int g = Integer.parseInt(fields[1].trim());
            int b = Integer.parseInt(fields[2].trim());
            return new Color(r, g, b);
        }
        catch(Exception e) {
            logger.error("Error parsing color spec "+spec);
        }
        return null;
    }
    
    /**
     * Parses a color ramp from a string and returns
     * a table of colors.
     * @param spec the string specifying a list of colors
     * as a space separated list or r,g,b triples
     * @return a table of colors
     */
    public static Color[] parseColorRamp(String spec) {
        String[] colors = spec.split(" ");
        if (colors.length < 2) {
            logger.error("Expected at most 2 colors, received "
                    +colors.length+" in "+spec);
            return null;
        }
        Color[] ramp = new Color[colors.length];
        for (int i = 0; i < ramp.length; i++) {
            Color c = parseColor(colors[i]);
            if (c == null) return null;
            ramp[i] = c;
        }
        return ramp;
    }
    
    /**
     * Loads a property file contaianing color schemes.
     * @param colorName the proprty file
     * @return a Properties
     */
    public static Properties loadProperties(String colorName) {
        String resourceName = "resources/"+colorName+".properties";
        InputStream in = 
            ColorScheme.class.getClassLoader().getResourceAsStream(resourceName);
        if (in != null)
            try {
            Properties props = new Properties();
            props.load(in);
            return props;
        }
        catch(FileNotFoundException e) {
            logger.error("Cannot find color scheme file "+resourceName, e);
        }
        catch(IOException e) {
            logger.error("Exception reading color scheme file "+resourceName, e);
        }                
        return null;
    }

    /**
     * Load an array of ColorSchemes from a named resource.
     * @param colorName the named resource
     * @return an array of ColorSchemes.
     */
    public static ColorScheme[] loadColorSchemes(String colorName) {
        Properties props = loadProperties(colorName);
        if (props == null) {
            logger.error("Cannot read color schemes from "+colorName);
            throw new RuntimeException("Cannot read color schemes from "+colorName);
        }
        ArrayList colorSchemes = new ArrayList();
        for (int i = 0; i < 1000; i++) {
            String suffix = "." + i;
            String name = props.getProperty("name" + suffix);
            if (name == null) {
                break;
            }
            String rampSpec = props.getProperty("colors" + suffix);

            colorSchemes.add(new ColorScheme(
                    name.trim(), 
                    parseColorRamp(rampSpec)));
        }
        ColorScheme[] ret = new ColorScheme[colorSchemes.size()];
        colorSchemes.toArray(ret);
        return ret;
    }
    
    /**
     * Returns the color schemes.
     * @return the color schemes.
     */
    public static ColorScheme[] findColorSchemes() {
        if (schemes == null) {
            schemes = loadColorSchemes(RESOURCE_NAME);            
        }
        return schemes;
    }
    
    /**
     * Returns a color scheme by name.
     * @param name the name
     * @return the color scheme or null
     */
    public static ColorScheme getColorScheme(String name) {
        ColorScheme[] schemes = findColorSchemes();
        for (int i = 0; i < schemes.length; i++) {
            ColorScheme s = schemes[i];
            if (name.equals(s.getName())) {
                return s;
            }
        }
        return null;
    }
    
    /**
     * Returns the last color of the ColorScheme ramp.
     * @return the last color of the ColorScheme ramp
     */
    public Color getEnd() {
        return ramp[ramp.length-1];
    }
    
    /**
     * Returns the name.
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * Returns the first color of the ColorScheme ramp.
     * @return the first color of the ColorScheme ramp
     */
    public Color getStart() {
        return ramp[0];
    }
    
    /**
     * Returns the color ramp.
     * @return the color ramp
     */
    public Color[] getRamp() {
        return ramp;
    }
    
    /**
     * {@inheritDoc}
     */
    public int getIconHeight() {
        return 32;
    }

    /**
     * {@inheritDoc}
     */
    public int getIconWidth() {
        return 64;
    }
    
    /**
     * {@inheritDoc}
     */
    public void paintIcon(Component c, Graphics g, int x, int y) {
        float dx = 64 / ramp.length;
        for (int i = 0; i < ramp.length; i++) {
            g.setColor(ramp[i]);
            g.fillRect(x, y, (int)dx, 32);
            x += (int)dx;
        }
        //g.setColor(end);
        //g.fillRect(x+32, y, 32, 32);
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        return getName();
    }
}

