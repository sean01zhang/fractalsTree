/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fractalViewer;

import java.awt.Graphics;


/**
 * The job of the pencil class is to draw lines of certain distances from its previous point.
 * @author seanz
 */
public class Pencil {
    //the coordinates of the pencil 
    private double x, y;
    //the direction the pencil is facing.
    private double angle;
    
    /**
     * Sets the starting position of the pencil. This is essentially setting where you want to put the pencil down on the canvas.
     * @param x the x value of the 2d coordinate of the pencil
     * @param y the y value of the 2d coordinate of the pencil
     * @param angle the direction the pencil is facing.
     */
    public Pencil(int x, int y, int angle) {
        //sets the given arguments to their corresponding values in the constructor.
        this.x =x;
        this.y = y;
        this.angle= angle;
    }
    
    /**
     * Turns the pencil a certain amount counterclockwise.
     * @param degreesDelta 
     */
    public void turnCClockwise(double degreesDelta) {
        //rotate the direction of drawing counterclockwise by delta degrees
        angle+=degreesDelta;
    }
    
    /**
     * Draws a line of a certain amount on the given component of the graphics object.
     * @param amt the length of the line to be drawn
     * @param g the graphics object.
     */
    public void drawForward(double amt, Graphics g) {
        //this is the old x and y coordinates of the point, before moving forward
        double x0 = x;
        double y0 = y;
        //find new coordinates
        x+=amt*Math.cos(Math.toRadians(angle));
        y+=amt*Math.sin(Math.toRadians(angle));
        //draws the line from the current coordinates of the pencil to the new coordinates.
        g.drawLine((int)Math.round(x0), (int)Math.round(y0), (int)Math.round(x), (int)Math.round(y));
    }
    
}
