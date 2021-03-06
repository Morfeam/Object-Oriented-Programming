
/**
 * Write a description of class a here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
import java.util.*;
import javax.swing.*;
public class ShapeIcon implements Icon
{
    private int width;
    private int height;
    private Moveable shape;
    
    public ShapeIcon(Moveable s, int w, int h)
    {
        shape = s;
        width = w;
        height = h;
    }
    public int getIconHeight()
    {
        return height;
    }
    public int getIconWidth()
    {
        return width;
    }
    public void paintIcon(Component c, Graphics g, int x, int y)
    {
        Graphics2D g2 = (Graphics2D) g;
        shape.draw(g2);
    }
}
