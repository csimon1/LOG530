/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.panel;

import infovis.Table;
import infovis.column.BooleanColumn;

import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Display the Label "Attributes" and the number of selected items in
 * the top left corner of a scrolled DetailTable.
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.4 $
 */
public class TableAttributesHeader extends JLabel implements ChangeListener {
    protected Table table;
    protected BooleanColumn selection;
    
    /**
     * Constructor.
     * @param table the table
     * @param selection the selection column
     */
    public TableAttributesHeader(Table table, BooleanColumn selection) {
        super();
        setHorizontalAlignment(CENTER);
        this.selection = selection;
        this.table = table;
        this.selection.addChangeListener(this);
        stateChanged(null);
    }
    
    /**
     * {@inheritDoc}
     */
    public void stateChanged(ChangeEvent e) {
        setText(""+selection.getSelectedCount()+"/"+table.getRowCount());
    }

}
