/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.visualization;

import infovis.Visualization;

import javax.swing.JComponent;

/**
 * Class VisualizationInteractor
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.2 $
 */
public interface VisualizationInteractor {
    public abstract void install(JComponent comp);
    public abstract void uninstall(JComponent comp);
    public abstract Visualization getVisualization();
    public abstract void setVisualization(Visualization vis);
    public abstract JComponent getJComponent();
}