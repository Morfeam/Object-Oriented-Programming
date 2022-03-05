
/**
 * Object Oriented Programming: Clock Animation Project (Part 2)
 * This is the design of a simple animated clock object with moving minutes, hours, and seconds hands.
 * 
 * @author (Matthew Morfea)
 * @version (10/27/20)
 */

//Imports needed to draw portions of the object and moving parts.
import java.awt.*;
import java.util.*;
import java.awt.geom.*;
import java.awt.Color;
import java.awt.Stroke;

//This clock shape implements Moveable interface allowing objects to move and have access to Graphics g.
public class ClockIcon implements Moveable
{
    //private initalization variables
    private int x; 
    private int y;
    private int width;
    private int h;
    private int m;
    private int count;
    
    //Constructor for ClockShape Object
    public ClockIcon(int xx, int yy, int ww, int hh, int mm, int cc)
    {
        x = xx;
        y = yy; 
        width = ww;
        h = hh;
        m = mm;
        count = cc;
    } 
    
    //Different starting variables for varying hours, minutes, and seconds hands.
    double theta = -Math.PI / 2; //Second hand
    double alpha = -Math.PI / 2; //Minute hand
    double gamma = -Math.PI / 2; // Hour hand
    
    //translate or Rotation method that allow hands to rotate around the point of origin.
    //Movement is done through constructed count variable and every 60 seconds the minute hand is moved.
    //Every 720 seconds the hour hand is moved 1/5th of the position to the next hour, 60 minutes in an hour (12 * 5 = 60). 
    public void translate(int dx, int dy)
    {   
        
        //If count = 0, then re-initalize the theta, alpha, and gamma variables,
        //used to define the clocks movement. 
        if(count == 0)
        {
            theta = -Math.PI / 2;
            alpha = (-Math.PI / 2) + m * (Math.PI /30);
            gamma = (-Math.PI / 2) + h * (Math.PI /6);
            
        }
        
        //translate portion of code from part 1
        theta = theta + (Math.PI /30);
        count += 1; 
        if(count % 60 == 0)
        {
            alpha = alpha + (Math.PI /30); 
            if(count % 720 == 0)
            {
                gamma = gamma + (Math.PI /30);
            }
        }
    }
    
    //Set Methods to set amount of hours, minutes, and count. 
    public void setH(int hour)
    {
        h = hour; 
    }
    public void setM(int minute)
    {
        m = minute; 
    }
    public void setC(int cnt)
    {
        count = cnt; 
    }
    
    //Draw method which creates the clock shape icon
    public void draw(Graphics2D g2)
    {
        //Point of origin 
        Point2D.Double origin = new Point2D.Double(300,300);
        
        //Creation of the second hand drawn as a 2D line.
        Point2D.Double endSecond = new Point2D.Double(300+110*Math.cos(theta),300 + 110 * Math.sin(theta));
        Shape seconds = new Line2D.Double(origin,endSecond);
        
        //Creation of the minute hand drawn as a 2D line.
        Point2D.Double endMinutes = new Point2D.Double(300+110*Math.cos(alpha),300 + 120 * Math.sin(alpha));
        Shape minutes = new Line2D.Double(origin,endMinutes);
        
        //Creation of the hour hand drawn as a 2D line.
        Point2D.Double endHours = new Point2D.Double(300+110*Math.cos(gamma),300 + 140 * Math.sin(gamma));
        Shape hours = new Line2D.Double(origin,endHours);
        
        //Ball which covers the center of the clock shape and the start point / origin of the hands 2D lines. 
        Ellipse2D.Double ball = new Ellipse2D.Double(295,295,10,10);
        
        //For loop used to create the marks on the outside of the clock shape object.
        for(int j = 0; j <= 59; j++)
        {
            if(j % 5 == 0)
            {
                //Creation of hour marks in red placed for every 1 in 5 minute marks.
                Ellipse2D.Double hourMark = new Ellipse2D.Double(295 + 170 * Math.cos(j * Math.PI/30),295 + 170 * Math.sin(j * Math.PI/30),10,10);
                g2.setColor(Color.RED);
                g2.fill(hourMark);
                g2.draw(hourMark);
            }else{
                //Creation of minute marks in black.
                Ellipse2D.Double minMark = new Ellipse2D.Double(298 + 170 * Math.cos(j * Math.PI/30),298 + 170 * Math.sin(j * Math.PI/30),4,4);
                g2.setColor(Color.BLACK);
                g2.fill(minMark);
                g2.draw(minMark);
            }
        }
        
        //Drawing of hour hand in gray set to a thick line using Stroke import
        g2.setStroke(new BasicStroke(7));
        g2.setColor(Color.GRAY);
        g2.fill(hours);
        g2.draw(hours);
        
        //Drawing of minute hand in blue set to a semi-thick line using Stroke import
        g2.setStroke(new BasicStroke(6));
        g2.setColor(Color.BLUE);
        g2.fill(minutes);
        g2.draw(minutes);
        
        //Drawing of second hand in red set to a thin line using Stroke import
        g2.setStroke(new BasicStroke(3));
        Color c = Color.BLUE;
        g2.setColor(Color.RED);
        g2.fill(seconds);
        g2.draw(seconds);
        
        //Drawing of center / origin ball set in black
        g2.setColor(Color.BLACK);
        g2.fill(ball);
        g2.draw(ball);
    }
}
