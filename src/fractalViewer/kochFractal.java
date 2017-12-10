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
public class kochFractal {
    //essential variables in determining the nature of the koch curve.
    double depth;
    int width;
    int startx, startAngle,starty;
    double scaleFactor;
    
    /**
     * Initializes all the values essential to drawing a koch curve.
     * @param depth how many steps do you want to go
     * @param startx the starting x value of the koch curve.
     * @param starty the starting y value of the koch curve.
     * @param startAngle the inital angle of the koch curve.
     * @param width the width of the koch curve.
     */
    public kochFractal(double depth, int startx, int starty, int startAngle,int width) {
        this.startx = startx;
        this.starty=starty;
        this.startAngle=startAngle;
        this.depth = depth;
        scaleFactor=1;
        this.width=width;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getStartx() {
        return startx;
    }

    public void setStartx(int startx) {
        this.startx = startx;
    }

    public int getStartAngle() {
        return startAngle;
    }

    public void setStartAngle(int startAngle) {
        this.startAngle = startAngle;
    }

    public int getStarty() {
        return starty;
    }

    public void setStarty(int starty) {
        this.starty = starty;
    }
    
    public void kochFractal(Graphics g, int depth, int size, Pencil p) {
        if (depth < 1) {
            p.drawForward(scaleFactor * size, g);
        } else {
            kochFractal(g, depth - 1, size / 3, p);
            p.turnCClockwise(-60);
            kochFractal(g, depth - 1, size / 3, p);
            p.turnCClockwise(120);
            kochFractal(g, depth - 1, size / 3, p);
            p.turnCClockwise(-60);
            kochFractal(g, depth - 1, size / 3, p);
        }
    }
    
    public void drawCurve(Graphics g) {
        kochFractal(g, (int) depth, width, new Pencil(startx, starty, startAngle));
    }
}
