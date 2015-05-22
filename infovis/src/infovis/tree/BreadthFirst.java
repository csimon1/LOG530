/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.tree;

import infovis.Tree;
import infovis.utils.IntStack;
import infovis.utils.RowIterator;


/**
 * Breadth First traversal algorithm for trees.
 *
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.9 $
 */
public class BreadthFirst {
    /**
     * Traverse the tree starting at a node with a breadth first traversal,
     * calling the visitor at each node.
     *
     * @param tree the Tree.
     * @param visitor the <code>BreadthFirst.Visitor</code>
     * @param node the root node.
     * @param Q an IntVector used as a queue.
     */
    public static void visit(Tree tree, Visitor visitor, int node, IntStack Q) {
        if (visitor.discover(node)) {
            Q.add(node);
        }

        while (!Q.isEmpty()) {
            int n = Q.pop();
            visitor.examine(n);

            for (RowIterator iter = tree.childrenIterator(n); iter.hasNext(); ) {
                int child = iter.nextRow();
                if (visitor.discover(child)) {
                    Q.add(child);
                }
            }

            visitor.finish(n);
        }
    }
    
    public static void visit(Tree tree, Visitor visitor, int node) {
        visit(tree, visitor, node, new IntStack());
    }

    /**
     * Class for traversing a tree breadth first.
     *
     * TODO
     */
    public interface Visitor {
        public boolean discover(int node);

        public void examine(int node);

        public void finish(int node);
    }
}
