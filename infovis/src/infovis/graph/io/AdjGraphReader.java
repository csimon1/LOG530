/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.graph.io;

import infovis.Graph;
import infovis.io.WrongFormatException;

import java.awt.geom.Rectangle2D.Float;
import java.io.BufferedReader;
import java.io.InputStream;
import java.util.HashMap;

/**
 * <b>AdjGraphReader</b> reads graphs stored as 
 * adjacency lists.
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.3 $
 * 
 * @infovis.factory GraphReaderFactory adj
 * @infovis.factory GraphReaderFactory el
 */
public class AdjGraphReader extends AbstractGraphReader {
    /**
     * Creates an AdjGraphReader.
     * @param in the input stream
     * @param name the name
     * @param graph the graph
     */
    public AdjGraphReader(InputStream in, String name, Graph graph) {
        super(in, name, graph);
    }

    /**
     * {@inheritDoc}
     */
    public Float getBbox() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public boolean load() throws WrongFormatException {
        HashMap vertexMap = new HashMap();
        graph.setDirected(false);

        try {
            BufferedReader in = getBufferedReader();
            while (true) {
                String line = in.readLine();
                if (line == null) break;
                String[] edges = line.trim().split(" ");
                if (edges.length != 2) {
                    return false;
                }
                String t1 = edges[0];
                int v1;
                if (vertexMap.containsKey(t1)) {
                    v1 = ((Integer)vertexMap.get(t1)).intValue();
                }
                else {
                    v1 = graph.addVertex();
                    vertexMap.put(t1, new Integer(v1));
                }
                String t2 = edges[1];
                int v2;
                if (vertexMap.containsKey(t2)) {
                    v2 = ((Integer)vertexMap.get(t2)).intValue();
                }
                else {
                    v2 = graph.addVertex();
                    vertexMap.put(t2, new Integer(v2));
                }
                graph.findEdge(v1, v2);
            }
        }
        catch(Exception e) {
            return false;
        }
        return true;
    }

}
