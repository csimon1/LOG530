/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.tree.io;

import infovis.Column;
import infovis.Tree;
import infovis.table.io.CSVTableWriter;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Tree Writer in TM3 format.
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.2 $
 */
public class TM3TreeWriter extends CSVTableWriter {
    protected Tree tree;
    protected Column nameColumn;
    
    /**
     * Constructor.
     * @param out the output stream
     * @param name the tree name
     * @param tree the tree
     */
    public TM3TreeWriter(OutputStream out, String name, Tree tree) {
        super(out, name, tree);
        this.tree = tree;
    }
    
    /**
     * Constructor.
     * @param out the output stream
     * @param tree the tree
     */
    public TM3TreeWriter(OutputStream out, Tree tree) {
        this(out, tree.getName(), tree);
        setSeparator('\t');
    }
    
    /**
     * @param nameColumn The nameColumn to set.
     */
    public void setNameColumn(Column nameColumn) {
        this.nameColumn = nameColumn;
    }
    
    /**
     * @return Returns the nameColumn.
     */
    public Column getNameColumn() {
        return nameColumn;
    }
    
    protected void writeLines(ArrayList labels) throws IOException {
        int nrow = table.getRowCount();
        for (int row = 1; row < nrow; row++) {
            if (table.isRowValid(row)) {
                for (int col = 0; col < labels.size(); col++) {
                    if (col != 0)
                        write(getSeparator());
                    Column c = table.getColumn(getColumnLabelAt(col));
                    write(quoteString(c.getValueAt(row)));
                }
                writePath(row);
                write('\n');
            }
        }
    }
    
    protected String getPathElement(int row) {
        if (nameColumn == null) {
            return Integer.toString(row);
        }
        else {
            return nameColumn.getValueAt(row);
        }
    }
    
    protected void writePath(int row) throws IOException {
        ArrayList path = new ArrayList();
        for (;row != Tree.ROOT; row = tree.getParent(row)) {
            path.add(getPathElement(row));
        }
        write(getSeparator());
        for (int i = path.size()-1; i >= 0; i--) {
            write(getSeparator());
            write(quoteString((String)path.get(i)));
        }
    }
}
