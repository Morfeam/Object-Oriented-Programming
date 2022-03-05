
/**
 *
 * @author (Matthew Morfea)
 * @version (11/17/20)
 */
//Java Imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TwoCarsTester
{
  public static void main(String[] args)
  {
      //Init of frame
    JFrame frame = new JFrame();

    final Moveable shape = new TwoCarsIcon(0, 0, 600);

    ShapeIcon icon = new ShapeIcon(shape,600,600);
    
    //Init of Label and window features.
    final JLabel label = new JLabel(icon);
    frame.setLayout(new FlowLayout());
    frame.add(label);
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
    
    //Build of ActionListerner to introduce repaint animation
    final int DELAY = 50;
    Timer t = new Timer(DELAY, new 
       ActionListener()
       {
         public void actionPerformed(ActionEvent event)
         {
           label.repaint();
           shape.translate(1,1);
         }
       });
     t.start();
   }

}


