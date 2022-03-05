
/**
 * Object Oriented Programming: Clock Animation Project (Part 2)
 * This is the calling class of the Clock shape object creating in the ClockShape class. 
 * 
 * @author (Matthew Morfea)
 * @version (10/27/20)
 */
//Imports needed to draw portions of the object and moving parts.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
public class ClockTester//implements ActionListener
{
    //Variables to control hour and minute text fields.
    private JTextField hField;
    private JTextField mField;

    public static void main(String[] args)
    {
        //Creation of JFrame and initalization pf ClockIcon() object
        JFrame frame = new JFrame();
        ClockIcon shape = new ClockIcon(0,0,100, 0,0,0);
        ShapeIcon icon = new ShapeIcon(shape, 600, 600);
        
        frame.setLayout(new BorderLayout());
        
        //printing of JLabel for background color and setting of ClockIcon() object
        final JLabel label = new JLabel(icon);
        label.setBackground(new Color(51,204,255));
        label.setOpaque(true);
        frame.add(label,BorderLayout.NORTH);
        
        JTextField hField;
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new FlowLayout());
        textPanel.setBackground(Color.MAGENTA);
        hField = new JTextField("Enter Starting Hour");
        
        textPanel.add(hField); //add ioField as a component of the panel
        frame.add(textPanel, BorderLayout.SOUTH);
        
        JTextField mField;
        textPanel.setLayout(new FlowLayout());
        mField = new JTextField("Enter Starting Minute");
        
        textPanel.add(mField); //add ioField as a component of the panel
        frame.add(textPanel, BorderLayout.SOUTH);
        
        //Delay to set the proper speed of the clock object and creation of ActionListener()
        final int DELAY = 1000; 
        Timer t = new Timer(DELAY, new 
        ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //Calling the movement of the ClockIcon() obejct - Translate
                // and repainting label to simulate movement of clock object
                shape.translate(1,0);
                label.repaint();
            }
        });
        
        //Set button handling
        JButton setButton = new JButton("Set");
        setButton.addActionListener(new 
        ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String actionCommand = e.getActionCommand();
                //If button is pressed set clock hours and minutes to textField variables.
                //Set count = 0 and reset textField variables.
                if(actionCommand.equals("Set"))
                {
                    shape.setH(Integer.parseInt(hField.getText()));
                    shape.setM(Integer.parseInt(mField.getText()));
                    shape.setC(0);
                    hField.setText("Enter Starting Hour");
                    mField.setText("Enter Starting Minute"); 
                    //Start animation
                    t.start();
                }
                else{
                    hField.setText("error");
                }
            }
        });
        textPanel.add(setButton);

        //Reset button handling
        JButton resButton = new JButton("Reset");
        resButton.addActionListener(new 
        ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String actionCommand = e.getActionCommand();
                //If button is pressed set clock hours and minutes to 0.
                //Set count = 0 and reset textField variables.
                if(actionCommand.equals("Reset"))
                {
                    shape.setH(0);
                    shape.setM(0);
                    shape.setC(0);
                    //Resesting and Painting clock
                    shape.translate(0,0);
                    label.repaint();
                    //Stop animation after painting reset
                    t.stop();
                    hField.setText("Enter Starting Hour");
                    mField.setText("Enter Starting Minute");
                }
                else{
                    hField.setText("error");
                }
            }
        });
        textPanel.add(resButton);
        
        //Setting default closing for JFrame and setting it visible when run
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
