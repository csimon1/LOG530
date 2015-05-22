/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.panel;

import infovis.Visualization;
import infovis.column.ColumnFilter;
import infovis.visualization.LinkShaper;
import infovis.visualization.LinkVisualization;
import infovis.visualization.linkShapers.LinkShaperFactory;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Default visual panel for Links.
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.8 $
 */
public class DefaultLinkVisualPanel extends DefaultVisualPanel {
    protected JCheckBox       showExcentric;
    protected JComboBox       linkShapers;
    
    /**
     * Constructor.
     * @param visualization the link visualization
     * @param filter the column filter
     */
    public DefaultLinkVisualPanel(
        LinkVisualization visualization,
        ColumnFilter filter) {
        super(visualization, filter);
    }

    protected void createAll() {
        addShowExcentric(getVisualization());
        super.createAll();
        addLinkShapers(getVisualization());
    }
    
    /**
     * Returns the link visualization.
     * @return the link visualization
     */
    public LinkVisualization getLinkVisualization() {
        return (LinkVisualization)getVisualization();
    }
    
    protected void addLinkShapers(Visualization visualization) {
        Vector v = new Vector();
        for (Iterator iter = LinkShaperFactory.getInstance().iterator();
            iter.hasNext(); ) {
            LinkShaperFactory.Creator c = (LinkShaperFactory.Creator)iter.next();
            v.add(c);
        }
        Object[] o = v.toArray();
        Arrays.sort(o, new Comparator() {
            public int compare(Object arg0, Object arg1) {
                LinkShaperFactory.Creator c0 = (LinkShaperFactory.Creator)arg0;
                LinkShaperFactory.Creator c1 = (LinkShaperFactory.Creator)arg1;
                return c0.getName().compareToIgnoreCase(c1.getName());
            }
        });
        linkShapers = addJCombo("Link Shape", new JComboBox(o));
        linkShapers.setRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(JList list,
                    Object value, int index, boolean isSelected,
                    boolean cellHasFocus) {
                LinkShaperFactory.Creator c = (LinkShaperFactory.Creator)value;
                super.getListCellRendererComponent(list, c.getName(), index,
                        isSelected, cellHasFocus);
                return this;
            }
        });
        linkShapers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LinkShaperFactory.Creator c = (LinkShaperFactory.Creator)linkShapers.getSelectedItem();
                LinkVisualization vis = getLinkVisualization();
                if (! isLinkShaperFromCreator(vis.getLinkShaper(), c)) {
                    vis.setLinkShaper(c.create());
                }
            }
        });
        updateLinkShaper();
    }
    
    /**
     * Returns true if the link shaper is from the specified creator.
     * @param s the link shape
     * @param c the creator
     * @return true if the link shaper is from the specified creator
     */
    public static boolean isLinkShaperFromCreator(LinkShaper s, LinkShaperFactory.Creator c) {
        return s.getClass().getName().equals(c.getLinkShaperClassName());
    }
    
    void updateLinkShaper() {
        LinkShaper s = getLinkVisualization().getLinkShaper();
        ComboBoxModel model = linkShapers.getModel();
        for (int i = 0; i < model.getSize(); i++) {
            LinkShaperFactory.Creator c = (LinkShaperFactory.Creator)model.getElementAt(i);
            if (isLinkShaperFromCreator(s, c)) {
                linkShapers.setSelectedIndex(i);
                return;
            }
        }
    }
    
    protected void addShowExcentric(Visualization visualization) {
        final LinkVisualization vis =(LinkVisualization) visualization; 
        showExcentric = new JCheckBox("Show Excentric");
        showExcentric.setSelected(vis.isShowExcentric());
        showExcentric.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                vis.setShowExcentric(showExcentric.isSelected());
            }
        });
        add(showExcentric);
        vis.addPropertyChangeListener(
                LinkVisualization.PROPERTY_SHOW_EXCENTRIC,
                new PropertyChangeListener() {
                    public void propertyChange(PropertyChangeEvent evt) {
                        showExcentric.setSelected(vis.isShowExcentric());
                    }
                });
    }

    /**
     * Creates and adds a link visualization to an
     * existing control panel.
     * 
     * @param controlPanel the control panel
     * @param linkVisualization the associated link visualization
     * @param filter the column filter
     */
    public static void addVisualPanelTab(
        ControlPanel controlPanel,
        LinkVisualization linkVisualization,
        ColumnFilter filter) {
        int index = controlPanel.indexOfTab("Visual");
        controlPanel.getTabs().insertTab(
            "Links Visual",
            null,
            new DefaultLinkVisualPanel(linkVisualization, filter),
            "Setting of visual attributes for the visualization of links",
            index+1);
    }
}
