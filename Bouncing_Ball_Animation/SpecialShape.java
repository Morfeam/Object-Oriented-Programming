
/**
 * Write a description of class a here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
import java.util.*;
import java.awt.geom.*;
import java.awt.Color;
public class SpecialShape implements Moveable
{
    private int x; 
    private int y;
    private int width;
    
    public SpecialShape(int xx, int yy, int ww)
    {
        x = xx;
        y = yy;
        width = ww;
    }   
    int xchange = 1;
    
    public void translate(int dx, int dy)
    {
        if(x ==350)
        {
            xchange = -1; 
        }else if(x==0)
        {
            xchange = 1; 
        }
        
        x = x + 2 * xchange; 
        
        y = (int) Math.floor(15*Math.sin(.25*x));
    }
    
    public void draw(Graphics2D g2)
    {
        Random gen = new Random();
        Color c = new Color(Math.abs(gen.nextInt()) % 255,Math.abs(gen.nextInt()) % 255,Math.abs(gen.nextInt()) % 255);
        g2.setColor(c);
        Ellipse2D.Double ball = new Ellipse2D.Double(x,(y + width/6) + 20,width/2,width/2);
        
        g2.fill(ball);
        g2.draw(ball);
    }
}
