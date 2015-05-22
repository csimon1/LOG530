/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.panel;

import infovis.Visualization;
import infovis.graph.visualization.MatrixAxisVisualization;
import infovis.graph.visualization.MatrixVisualization;
import infovis.utils.BasicFactory;
import infovis.visualization.DefaultAxisVisualization;
import infovis.visualization.Orientable;
import infovis.visualization.inter.InteractorFactory;
import infovis.visualization.render.DefaultVisualLabel;
import infovis.visualization.render.VisualLabel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import org.apache.log4j.Logger;

/**
 * ControlPanelFactory create a control panel associated with a specified
 * visualization.
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.21 $
 */
public class ControlPanelFactory extends BasicFactory {
    static ControlPanelFactory instance;

    static Logger logger = Logger.getLogger(ControlPanelFactory.class);

    Map creators = new HashMap();

    /**
     * Constructor for ControlPanelFactory.
     */
    public ControlPanelFactory() {
        addDefaultCreators("controlpanelfactory");
    }

    /**
     * Returns the instance.
     * @return the instance
     */
    public static ControlPanelFactory getInstance() {
        if (instance == null) {
            instance = new ControlPanelFactory();
        }
        return instance;
    }

    /**
     * Sets the global instance.
     * @param shared the new instance.
     */
    public static void setInstance(ControlPanelFactory shared) {
        instance = shared;
    }

    /**
     * Creates a Control Panel from a Visualization.
     * 
     * @param visualization
     *            The Visualization.
     * 
     * @return A Control Panel.
     */
    public ControlPanel create(Visualization visualization) {
        ControlPanel ret = null;

        Creator creator = findCreator(visualization);
        if (creator != null) {
            ret = creator.create(visualization);
        }
        return ret;
    }

    /**
     * Returns a creator for that visualization.
     * @param visualization the visualization
     * @return a creator for that visualization
     */
    public Creator findCreator(Visualization visualization) {
        // Firs try the visualization itelf
        Class visClass = Visualization.class;
        for (Class c = visualization.getClass(); visClass
                .isAssignableFrom(c); c = c.getSuperclass()) {
            Creator creator = getCreator(c);
            if (creator != null) {
                return creator; // ok, we have it
            }
        }
        // Then, search for sub visualizations
        for (int i = 0; visualization.getVisualization(i) != null; i++) {
            Creator creator = findCreator(visualization.getVisualization(i));
            if (creator != null) {
                return creator;
            }
        }

        return null;
    }

    /**
     * Creates a control panel for the specified visualization.
     * @param visualization the visualization
     * @return a control panel for the specified visualization
     */
    public static ControlPanel createControlPanel(
            Visualization visualization) {
        return getInstance().create(visualization);
    }

    /**
     * Creates a split pane for the control panel and
     * the visualization it contains.
     * @param cp the control panel
     * @return a split pane for the control panel and
     * the visualization it contains
     */
    public static JSplitPane createSplitVisualization(ControlPanel cp) {
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                new VisualizationPanel(cp.getVisualization()), cp);
        InteractorFactory.installInteractor(cp.getVisualization());
        split.setResizeWeight(1.0);
        return split;
    }

    /**
     * Creates a split pane for the control panel 
     * created from the visualization.
     * 
     * @param visualization the visualization
     * @return a split pane for the control panel 
     * created from the visualization
     */
    public static JSplitPane createSplitVisualization(
            Visualization visualization) {
        return createSplitVisualization(createControlPanel(visualization));
    }

    /**
     * Creates a split pane containing a scrolled pane
     * for the control panel and
     * the visualization it contains.
     * @param cp the control panel
     * @return a split pane containing a scrolled pane
     * for the control panel and
     * the visualization it contains
     */
    public static JSplitPane createScrollVisualization(ControlPanel cp) {
        JScrollPane scroll = new JScrollPane(new VisualizationPanel(cp
                .getVisualization()));
        Visualization vis = cp.getVisualization();
        InteractorFactory.installInteractor(vis);
        MatrixVisualization mat = 
            (MatrixVisualization)vis.findVisualization(MatrixVisualization.class);
        if (mat != null) {
            MatrixAxisVisualization column = mat.getColumnVisualization();
            column.setOrientation(Orientable.ORIENTATION_NORTH);
            InteractorFactory.installInteractor(column);
            VisualLabel vl = VisualLabel.get(column);
            if (vl instanceof DefaultVisualLabel) {
                DefaultVisualLabel dvl = (DefaultVisualLabel)vl;
                dvl.setOrientation(Orientable.ORIENTATION_NORTH);
            }
            scroll.setColumnHeaderView(new VisualizationPanel(column));
            
            MatrixAxisVisualization row = mat.getRowVisualization();
            row.setOrientation(Orientable.ORIENTATION_EAST);
            InteractorFactory.installInteractor(row);
            vl = DefaultVisualLabel.get(row);
            if (vl instanceof DefaultVisualLabel) {
                DefaultVisualLabel dvl = (DefaultVisualLabel)vl;
                dvl.setOrientation(Orientable.ORIENTATION_EAST);
            }
            scroll.setRowHeaderView(new VisualizationPanel(row));
            
            scroll.setCorner(
                    JScrollPane.UPPER_LEFT_CORNER,
                    new JPanner(scroll));            
        }
        else if (vis.getRulerTable() != null) {
            DefaultAxisVisualization column = new DefaultAxisVisualization(
                    vis,
                    Orientable.ORIENTATION_NORTH);
            InteractorFactory.installInteractor(column);
            VisualLabel vl = VisualLabel.get(column);
            if (vl instanceof DefaultVisualLabel) {
                DefaultVisualLabel dvl = (DefaultVisualLabel)vl;
                dvl.setOrientation(Orientable.ORIENTATION_NORTH);
            }
            scroll.setColumnHeaderView(new VisualizationPanel(column));
            DefaultAxisVisualization row = new DefaultAxisVisualization(
                    vis,
                    Orientable.ORIENTATION_EAST);
            InteractorFactory.installInteractor(row);
            vl = VisualLabel.get(row);
            if (vl instanceof DefaultVisualLabel) {
                DefaultVisualLabel dvl = (DefaultVisualLabel)vl;
                dvl.setOrientation(Orientable.ORIENTATION_EAST);
            }
            scroll.setRowHeaderView(new VisualizationPanel(row));
            
            scroll.setCorner(
                    JScrollPane.UPPER_LEFT_CORNER,
                    new JPanner(scroll));
        }
        else {
            cp.getTabs().add("Panner", new JPanner(scroll));
        }
        scroll.setWheelScrollingEnabled(false);
        scroll.setDoubleBuffered(false);
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                scroll, cp);
        split.setResizeWeight(1.0);
        return split;
    }

    /**
     * Creates a split pane containing a scrolled pane
     * for the control panel created from
     * the visualization.
     * @param visualization the visualization
     * @return a split pane containing a scrolled pane
     * for the control panel created from
     * the visualization
     */
    public static JSplitPane createScrollVisualization(
            Visualization visualization) {
        return createScrollVisualization(createControlPanel(visualization));
    }

    /**
     * Adds a named creator.
     * @param name the name
     * @param creator the creator
     */
    public void add(String name, Creator creator) {
        creators.put(name, creator);
    }

    /**
     * {@inheritDoc}
     */
    public void add(String className, String controlClassName,
            String data) {
        add(className, new DefaultCreator(controlClassName));
    }
    
    /**
     * Adds a creator.
     * @param className the visualization class name
     * @param controlClassName the control panel class name
     */
    public void add(String className, String controlClassName) {
        add(className, new DefaultCreator(controlClassName));
    }

    /**
     * Registers a control panel creator.
     * @param c the visualization class
     * @param creator the creator
     */
    public static void addControlPanel(Class c, Creator creator) {
        getInstance().add(c.getName(), creator);
    }

    /**
     * Returns the creator given a visualization class.
     * @param c the class
     * @return the creator given a visualization class
     */
    public Creator getCreator(Class c) {
        return (Creator) creators.get(c.getName());
    }

    /**
     * Returns the creator given a name.
     * @param name the name
     * @return the creator given a name
     */
    public Creator getCreator(String name) {
        return (Creator) creators.get(name);
    }

    /**
     * Specify the default control panel class
     * for the visualization class.
     * @param visClass the visualization class
     * @param cpClass the control panel class
     */
    public void setDefault(Class visClass, Class cpClass) {
        if (getCreator(visClass) == null)
            add(visClass.getName(), cpClass.getName(), null);
    }

    /**
     * Interface of control panel creators.
     * 
     * @author Jean-Daniel Fekete
     * @version $Revision: 1.21 $
     */
    public interface Creator {
        /**
         * Create a control panel for the specified visualization.
         * @param visualization the visualization
         * @return a control panel for the specified visualization
         */
        ControlPanel create(Visualization visualization);
    }

    /**
     * Default implementation of the control panel interface.
     * 
     * @author Jean-Daniel Fekete
     * @version $Revision: 1.21 $
     */
    public static class DefaultCreator implements Creator {
        String controlPanelClassName;
        Class controlPanelClass;

        /**
         * Constructor.
         * @param controlPanelClassName the control panel class
         */
        public DefaultCreator(
                String controlPanelClassName) {
            this.controlPanelClassName = controlPanelClassName;
        }

        /**
         * Returns the control panel class
         * @return the control panel class
         * @throws ClassNotFoundException when the class cannot be found
         */
        Class getControlPanelClass() throws ClassNotFoundException {
            if (controlPanelClass == null) {
                controlPanelClass = Class
                        .forName(controlPanelClassName);
            }
            return controlPanelClass;
        }

        /**
         * {@inheritDoc}
         */
        public ControlPanel create(Visualization visualization) {
            try {
                Class[] parameterTypes = { Visualization.class };
                Constructor cons;
                Class cpClass = getControlPanelClass();
                cons = cpClass.getConstructor(parameterTypes);
                Object[] args = { visualization };
                return (ControlPanel) cons.newInstance(args);
            } catch (NoSuchMethodException e) {
                logger.error(
                        "Cannot find control panel constructor for "
                                + controlPanelClassName, e);
                return null;
            } catch (ClassNotFoundException e) {
                logger.error("Cannot find class named "
                        + controlPanelClassName, e);
                return null;
            } catch (InvocationTargetException e) {
                logger.error("Cannot instantiate control panel for "
                        + controlPanelClassName, e);
            } catch (Exception e) {
                logger.error("Cannot instantiate control panel for "
                        + controlPanelClassName, e);
            }
            return null;
        }

    }
}