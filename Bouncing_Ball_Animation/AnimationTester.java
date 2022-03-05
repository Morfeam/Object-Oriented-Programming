
/**
 * Write a description of class a here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
public class AnimationTester
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        Moveable shape = new SpecialShape(0,0, SpecialWidth);
        
        ShapeIcon icon = new ShapeIcon(shape, 400, 100);
        
        final JLabel label = new JLabel(icon);
        label.setBackground(new Color(51,204,255));
        label.setOpaque(true);
        frame.setLayout(new FlowLayout());
        frame.add(label);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        
        final int DELAY = 100; 
        Timer t = new Timer(DELAY, new 
        ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                shape.translate(1,0);
                label.repaint();
            }
        });
        t.start();
    }
    private static final int SpecialWidth = 100; 
}
