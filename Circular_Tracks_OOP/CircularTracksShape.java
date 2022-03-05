
/**
 * Circular Tracks Part 1 Code
 * Implementation based on Circular tracks word document with some of my own "smooth" features.
 *
 * @author (Matthew Morfea)
 * @version (11/10/20)
 */
//Java imports
import java.awt.*;
import java.util.*;
import java.awt.Color;
import java.awt.geom.*;
import javax.swing.*;

public class CircularTracksShape implements Moveable
{
    //Used with old constructor
  private int xx;
  private int yy;
  private int width;
  int n;
  
  //Arrays to hold values for all 20 cars on the 20 tracks
  double[] theta = new double[20];
  int[] radius = new int[20];
  double[] a = new double[20];
  double[] b = new double[20];
  
 //colors for tracks (hexadecimal format)
 Color[] cc = {Color.decode("#ADFFFA"), Color.decode("#FFADE1"), Color.decode("#F2FFAD"), Color.decode("#FFE0AD"),
               Color.decode("#ADB4FF"), Color.decode("#ADFFB0"), Color.decode("#FFA998"), Color.decode("#A9FA6D"),
               Color.decode("#ADFFFA"), Color.decode("#FFADE1"), Color.decode("#F2FFAD"), Color.decode("#FFE0AD"),
               Color.decode("#ADB4FF"), Color.decode("#ADFFB0"), Color.decode("#FFA998"), Color.decode("#E9FA6D")};
 
 //constructor
  public CircularTracksShape(int x0, int y0, int w)
  {
      //old constructor variables 
    xx = x0;
    yy = y0;
    width = w;
    n = width/40;     

    
    //Setting of radius, theta, and postition variables:
    //Radius is set to the radius of the track proportional to the car.
    //theta is set to a value arbitarily
    //a and b arrays are set to calculate the movement of theta around the radii
    for(int i = 0; i<=n-1;i++)
    {
        radius[i] = 20 * i + 10;
        theta[i] = Math.PI / 30;
        a[i] = 300 + radius[i] * Math.cos(theta[i]);
        b[i] = 300 + radius[i] * Math.sin(theta[i]);
    }
 }//end constructor

 //implementation of Moveable

 public void translate(int dx, int dy)
 {
     int delx = dx; //horizontal increment or decrement (depending on current position)
     int dely = dy; //vertical displacement
     
     
     //position clockwise trains
  for (int i=0; i<= n-1; i= i+2){
     //compute next position
     theta[i] = theta[i] -  Math.PI/500;
     a[i] = 300 + radius[i] * Math.cos(theta[i]);
        b[i] = 300 + radius[i] * Math.sin(theta[i]);
  } //for

  // position counter-clockwise trains
  for (int i=1; i<= n-1; i= i+2){
    theta[i] = theta[i] +  Math.PI/500;
    a[i] = 300 + radius[i] * Math.cos(theta[i]);
        b[i] = 300 + radius[i] * Math.sin(theta[i]);
  } //for
 }



 
  public void draw(Graphics2D g2)
  {   
   //paint tracks via superimposed shrinking rectangles
     for(int i= 0; i<=n-1; i++){
      Ellipse2D.Double circ = new Ellipse2D.Double(20*i, 20*i ,width-(40*i),width-(40*i));
      g2.setColor(cc[i]);
      g2.fill(circ);
    }

    Random gen = new Random();
    
    //paint trains
     for (int i=0; i<= n-1; i= i+1){
      Color c = new Color(Math.abs(gen.nextInt()) % 255, Math.abs(gen.nextInt()) % 255, Math.abs(gen.nextInt()) % 255);
      g2.setColor(c);
      //Setting x and y positions to the respective and b arrays - 10 to fit on track nicely.
      Ellipse2D.Double ball = new Ellipse2D.Double(a[i]-10, b[i]-10, 20, 20);
      g2.fill(ball);     
      g2.draw(ball);
     }

  } //end draw

}
