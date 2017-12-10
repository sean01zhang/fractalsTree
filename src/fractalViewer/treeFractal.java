/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractalViewer;

import java.awt.Graphics;

/**
 *
 * @author seanz
 */
public class treeFractal {
    private int startX,startY,initAngle;
    private double length,sizeFactor,angle,scaleFactor=1,depth;
    
    
    public treeFractal(double depth, double length, double sizeFactor, double angle, int startX, int startY, int initAngle) {
        this.depth=depth;
        this.length=length;
        this.sizeFactor = sizeFactor;
        this.angle= angle;
        this.startX=startX;
        this.startY= startY;
        this.initAngle=initAngle;
           
    }

    public double getScaleFactor() {
        return scaleFactor;
    }

    public void setScaleFactor(double scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getInitAngle() {
        return initAngle;
    }

    public void setInitAngle(int initAngle) {
        this.initAngle = initAngle;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getSizeFactor() {
        return sizeFactor;
    }

    public void setSizeFactor(double sizeFactor) {
        this.sizeFactor = sizeFactor;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
    
    public void treeFractal(Graphics g, int depth, double length, double sizeFactor, double angle, int startX, int startY, int initAngle) {

        //calculate the ending x,y coordinates for this line segment.
        //As we are moving up, we subtract from the current base coordinates 
        //The formula used to determine end points by definition of sin and cos
        //actually draw the line
        //this is the old x and y coordinates of the point, before moving forward
        int x0 = startX;
        int y0 = startY;
        //find new coordinates
        startX += length * scaleFactor * Math.cos(Math.toRadians(initAngle));
        startY += length * scaleFactor * Math.sin(Math.toRadians(initAngle));

        g.drawLine(x0, y0, startX, startY);

        System.out.println(startX);
        //if we have more depth to go, recurse
        if (depth > 0) {
            treeFractal(g, depth - 1, length * sizeFactor, sizeFactor, angle, startX, startY, initAngle + (int) angle);
            treeFractal(g, depth - 1, length * sizeFactor, sizeFactor, -angle, startX, startY, initAngle - (int) angle);
        }
    }
    
    public void drawTree(Graphics g) {
        treeFractal(g,(int)depth,length,sizeFactor,angle,startX,startY,initAngle);
    }
    
    
}
