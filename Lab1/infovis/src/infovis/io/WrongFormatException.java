/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.io;

/**
 * Exception sent by Readers when witnessing a wrong format.
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision$
 */
public class WrongFormatException extends RuntimeException {
    /**
     * Object witnessing the format was wrong.
     */
    public Object witness;
    /**
     * Constructor for WrongFormatException.
     */
    public WrongFormatException() {
        super();
    }

    /**
     * Constructor for WrongFormatException.
     * @param message
     */
    public WrongFormatException(String message) {
        super(message);
    }

    /**
     * Constructor for WrongFormatException.
     * @param message
     * @param cause
     */
    public WrongFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor for WrongFormatException.
     * @param cause
     */
    public WrongFormatException(Throwable cause) {
        super(cause);
    }

}
