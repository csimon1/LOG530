/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Base class for factories.
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.7 $
 */
public abstract class BasicFactory {
    private static Logger logger = Logger.getLogger(BasicFactory.class);
    
    /**
     * Loads a properties from a resource name.
     * @param factoryName the factory name
     * @return the properties
     */
    public static Properties loadProperties(String factoryName) {
        String resourceName = "resources/"+factoryName+".properties";
        InputStream in = 
            BasicFactory.class.getClassLoader().getResourceAsStream(resourceName);
        if (in != null)
            try {
            Properties props = new Properties();
            props.load(in);
            return props;
        }
        catch(FileNotFoundException e) {
            logger.error("Cannot find factory file "+resourceName, e);
        }
        catch(IOException e) {
            logger.error("Exception reading factory file "+resourceName, e);
        }        
        return null;
    }
    
    protected void addDefaultCreators(String factoryName) {
        //if (true) return;
        Properties props = loadProperties(factoryName);
        if (props == null) {
            logger.error("Cannot read factory properties from "+factoryName);
            throw new RuntimeException("Cannot read factory properties from "+factoryName);
        }
        for (int i = 0; i < 1000; i++) {
            String suffix = "." + i;
            String name = props.getProperty("name" + suffix);
            if (name == null) {
                break;
            }
            String data = props.getProperty("data1" + suffix);
            String className = props.getProperty("class"
                    + suffix);
            add(name, className, data);
        }
    }
    
    public abstract void add(String name, String className, String data);

}
