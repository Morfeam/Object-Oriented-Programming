
public class NumericStringEval extends StringEval  //example of inheritance and of ovrriding;
                                                   //includes new methods for valuing
                                                   //numeric strings
{
  
     private int maxDigit;//largest digit in a string of 3 digits

     private int largestDigit()  //compute the largest digit
     {  
       String x =  getString();
       char max = x.charAt(0);
       for(int j = 1; j < 3; j++)
       {
         if(x.charAt(j) >= max)
          {
           max = x.charAt(j);
          }
       
       } 
   
      return max - '0';
     }
     
     //constructors

     public NumericStringEval()
     {
       super(); //use the no-parameter StringEval constructor to build e and p
       maxDigit = largestDigit();//compute the third member variable
     }

     public NumericStringEval(String ee)  //overload the above 
                                          //constructor with a parameterized constructor
     {
       super(ee);//use the parameterized StringEval constructor using e = ee
       maxDigit = largestDigit();
     }

    //valuation

    public int value(int k)  //the value of a string of digits is the int value
                             //this method overrides the parameterized value method in StringEval,
                             //which gives the lexicographic order position of the string among
                             //all alphanumeric words of the same length.
    {
      String x = getString();
      return((x.charAt(0) - '0')*100 + (x.charAt(1) - '0')*10 + x.charAt(2) - '0');
    }
}
     