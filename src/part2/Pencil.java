/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package part2;

import java.awt.Graphics;


/**
 *
 * @author seanz
 */
public class Pencil {
    private double x, y;
    private double angle;
    
    public Pencil(int x, int y, int angle) {
        this.x =x;
        this.y = y;
        this.angle= angle;
    }
    
    //rotate the direction of drawing counterclockwise by delta degrees
    public void turnCClockwise(double degreesDelta) {
        angle+=degreesDelta;
    }
    
    public void drawForward(double amt, Graphics g) {
        //this is the old x and y coordinates of the point, before moving forward
        double x0 = x;
        double y0 = y;
        //find new coordinates
        x+=amt*Math.cos(Math.toRadians(angle));
        y+=amt*Math.sin(Math.toRadians(angle));
        
        g.drawLine((int)Math.round(x0), (int)Math.round(y0), (int)Math.round(x), (int)Math.round(y));
    }
    
}
