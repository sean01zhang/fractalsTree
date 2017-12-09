/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.shape.Line;
import javax.swing.Timer;

/**
 *
 * @author seanzhang
 */
public class MainPanel extends javax.swing.JPanel {
    Pencil p;
    double depth = 5;
    int width;
    int startx,startAngle;
    int starty;
    Timer t;
    double scaleFactor=1;
    
    
    /**
     * Creates new form FractalsPanel
     */
    public MainPanel() {
        
        initComponents();
        startx = 0;
        startAngle =0;
        t = new Timer(5, new TimerListener());
    }

    public void startTimer() {
        t.start();
        
        starty=this.getHeight()-10;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        thingFractal(g,(int)depth,this.getWidth(),new Pencil(startx,starty,startAngle));
    }

    public void thingFractal(Graphics g, int depth, int size, Pencil p) {
        if (depth < 1) {
            p.drawForward(scaleFactor*size, g);
        } else {
            thingFractal(g,depth-1,size/3,p);
            p.turnCClockwise(-60);
            thingFractal(g,depth-1,size/3,p);
            p.turnCClockwise(120);
            thingFractal(g,depth-1,size/3,p);
            p.turnCClockwise(-60);
            thingFractal(g,depth-1,size/3,p);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                formMouseWheelMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 632, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_formMouseWheelMoved
        scaleFactor+=((double)evt.getWheelRotation()/10);
        System.out.println(scaleFactor);
        if(evt.getWheelRotation()>0) {
            depth+= 0.035;
        } else {
            depth-=0.035;
        }
    }//GEN-LAST:event_formMouseWheelMoved

    
    int initX,initY;
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        startx += evt.getX()-initX;
        starty += evt.getY()-initY;
        initX=evt.getX();
        initY=evt.getY();
    }//GEN-LAST:event_formMouseDragged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased

    }//GEN-LAST:event_formMouseReleased

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        initX=evt.getX();
        initY=evt.getY();
    }//GEN-LAST:event_formMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
            
        }
        
}
}
