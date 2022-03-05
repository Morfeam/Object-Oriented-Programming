import java.util.Scanner;

public class Complex  //illustrates overloading the constructor
{
  Scanner kb = new Scanner(System.in);

  private double re;
  private double im;

  
  public Complex()
  {
    System.out.println("enter real part: ");
    re = kb.nextDouble();
    System.out.println("enter imaginary  part: ");
    im = kb.nextDouble();
  }

  public Complex(double x, double y)
  {
    re = x;
    im = y;
  }

  public double getRe()
  {
    return re;
  }

  public void setRe(double x)
  {
    re = x;
  } 

  public double getIm()
  {
   return im;
  }

 public void setIm(double y)
 {
    im = y;
 }

 
 public void complexPrint()
 {
   System.out.println(re + " + " + im + "I");
 } 

 public Complex complexMult(Complex z, Complex w)
 {
  double a = z.getRe();
  double b = z.getIm();
  double c = w.getRe();
  double d = w.getIm();
  Complex u = new Complex(a*c - b*d, a*d + b*c);
  return u;
 }

}     