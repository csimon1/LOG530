/*****************************************************************************
 * Copyright (C) 2003-2005 Jean-Daniel Fekete and INRIA, France              *
 * ------------------------------------------------------------------------- *
 * This software is published under the terms of the X11 Software License    *
 * a copy of which has been included with this distribution in the           *
 * license-infovis.txt file.                                                 *
 *****************************************************************************/
package infovis.panel;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Paner for showing an overview and panning.
 * 
 * @author Jean-Daniel Fekete
 * @version $Revision: 1.3 $
 */
public class JPanner extends JComponent 
    implements 
    ChangeListener, 
    PropertyChangeListener, 
    MouseListener, 
    MouseMotionListener {
    JScrollPane scrollPane;
    Image image;
    int xoffset;
    int yoffset;
    Color viewportColor = Color.BLUE;
    transient Dimension scrollDim;

    /**
     * Creates a JPanner viewing a scroll pane.
     * @param scrollPane the scroll pane
     */
    public JPanner(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
        scrollPane.getViewport().addChangeListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    
    /**
     * {@inheritDoc}
     */
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == scrollPane.getViewport()) {
            repaint();
        }
    }

    /**
     * {@inheritDoc}
     */
    public void propertyChange(PropertyChangeEvent e) {
        if (e.getPropertyName().equals("viewport")) {
            JViewport oldViewport = (JViewport)(e.getOldValue());
            JViewport newViewport = (JViewport)(e.getNewValue());
            
            assert(oldViewport == scrollPane.getViewport()); 
            if (oldViewport != null) {
                oldViewport.removeChangeListener(this);
            }
            
            if (newViewport != null) {
                newViewport.addChangeListener(this);
            }
            invalidate();
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public void validate() {
        image = null;
        super.invalidate();
    }

    /**
     * Returns the current scale.
     * @return the current scale
     */
    public double getScale() {
        JViewport viewport = scrollPane.getViewport();
        Dimension viewSize = viewport.getViewSize();
        double ratio = (double)viewSize.width / viewSize.height;
        if ((ratio * getHeight()) > getWidth()) {
            return (double)getWidth() / viewSize.width;
        }
        else {
            return (double)getHeight() / viewSize.height;
        }
    }
    
    /**
     * Returns the full size. 
     * @return the full size.
     */
    public Dimension getFullSize() {
        JViewport viewport = scrollPane.getViewport();
        Dimension viewSize = viewport.getViewSize();
        double scale = getScale();
        int width  = (int) Math.ceil(viewSize.width * scale);
        int height = (int) Math.ceil(viewSize.height * scale);
        return new Dimension(width, height);
    }
    
    /**
     * Returns the image.
     * @return the image
     */
    public Image getImage() {
        if (image == null) {
            Dimension d = getFullSize();
            image = createImage(d.width, d.height);
            double s = getScale();
            Graphics2D g2 = (Graphics2D)image.getGraphics();
            g2.scale(s, s);
//            g2.setRenderingHint(
//                    RenderingHints.KEY_RENDERING, 
//                    RenderingHints.VALUE_RENDER_QUALITY);
//            g2.setRenderingHint(
//                    RenderingHints.KEY_ANTIALIASING, 
//                    RenderingHints.VALUE_ANTIALIAS_ON);
            JViewport viewport = scrollPane.getViewport();
            viewport.getView().paint(g2);
        }
        return image;
    }
    
    /**
     * {@inheritDoc}
     */
    public Rectangle getVisibleRect() {
        JViewport viewport = scrollPane.getViewport();
        Rectangle rect =  viewport.getViewRect();
        double scale = getScale();
        
        rect.x = (int)(rect.x * scale);
        rect.y = (int)(rect.y * scale);
        rect.width  = (int)(rect.width * scale);
        rect.height = (int)(rect.height * scale);
        return rect;
    }
    
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        if (getImage() != null) {
            g.drawImage(getImage(), 0, 0, null);
        }
        g.setColor(viewportColor);
        Dimension full = getFullSize();
        Rectangle rect = getVisibleRect();
        g.drawRect(0, 0, full.width-1, full.height-1);
        g2.draw(rect);
    }

    /**
     * {@inheritDoc}
     */
    public void mouseClicked(MouseEvent e) {
    }

    /**
     * {@inheritDoc}
     */
    public void mouseEntered(MouseEvent e) {
        image = null;
        repaint();
    }

    /**
     * {@inheritDoc}
     */
    public void mouseExited(MouseEvent e) {
    }

    /**
     * {@inheritDoc}
     */
    public void mousePressed(MouseEvent e) {
        scrollPane.getHorizontalScrollBar().setValueIsAdjusting(true);
        scrollPane.getVerticalScrollBar().setValueIsAdjusting(true);
        Rectangle r = getVisibleRect();
        if (r.contains(e.getPoint())) {
            xoffset = r.x - e.getX();
            yoffset = r.y - e.getY();
        }
        else {
            xoffset = -r.width/2;
            yoffset = -r.height/2;
        }
    }

    /**
     * {@inheritDoc}
     */
    public void mouseReleased(MouseEvent e) {
        mouseDragged(e);
        scrollPane.getHorizontalScrollBar().setValueIsAdjusting(false);
        scrollPane.getVerticalScrollBar().setValueIsAdjusting(false);
    }

    /**
     * {@inheritDoc}
     */
    public void mouseDragged(MouseEvent e) {
        int x = e.getX() + xoffset;
        int y = e.getY() + yoffset;
        Dimension full = getFullSize();
        Dimension view = scrollPane.getViewport().getViewSize();
        scrollPane.getHorizontalScrollBar().setValue(
                x * view.width / full.width);
        scrollPane.getVerticalScrollBar().setValue(
                y * view.height / full.height);
        repaint();
    }

    /**
     * {@inheritDoc}
     */
    public void mouseMoved(MouseEvent e) {
        Color color;
        if (getVisibleRect().contains(e.getPoint())) {
            color = Color.RED;
        }
        else {
            color = Color.BLUE;
        }
        if (color != viewportColor) {
            viewportColor = color;
            repaint();
        }
    }

}
