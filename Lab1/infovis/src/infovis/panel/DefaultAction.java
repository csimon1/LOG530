/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.panel;

import javax.swing.AbstractAction;
import javax.swing.Action;

/**
 * Default implementation of AbstractAction.
 * @author Jean-Daniel Fekete
 * @version $Revision$
 */
public abstract class DefaultAction extends AbstractAction {
    /**
     * Constructor for DefaultAction.
     * @param name the action name
     * @param mnemonic the mnemonic
     */
    public DefaultAction(String name, int mnemonic) {
        super(name);
        putValue(Action.MNEMONIC_KEY, new Integer(mnemonic));
    }


}
