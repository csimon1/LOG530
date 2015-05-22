/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.utils;

import cern.colt.function.DoubleFunction;

/**
 * Log function.
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.3 $
 */
public class LogFunction implements DoubleFunction {
    /** The static instance. */
    public static final LogFunction instance = new LogFunction(); 

    /**
     * {@inheritDoc}
     */
    public double apply(double v) {
        return Math.log(v);
    }
}
