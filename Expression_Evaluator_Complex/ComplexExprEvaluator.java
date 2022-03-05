
import java.util.*;

public class ComplexExprEvaluator extends ExprEvaluator  //illustrates inheritance;
                                                         //the evaluator method for complex expressions
                                                         //is not implemented, so at present we can only
                                                         //call the inherited evaluator() method for 
                                                         //real expressions
{

   private static Stack1gen<Complex> C = new Stack1gen<Complex>();

   private int status; // 0 if the expression is real; 1 if the expression is complex   

   public ComplexExprEvaluator()  //no parameter constructor
   {
     super(); //this calls the no-parameter constructor in the ExprEvaluator class
              //and results in values for e (the expression) and p (the character position)
     System.out.println("enter the expression status (0 ~ real, 1 ~ complex)");
     status = kb.nextInt();  //here we give a value to the third member variable,
                             //status, necessary to complete the ComplexExprEvaluator object
   }

   public ComplexExprEvaluator(String ee)   //parameterized constructor, illustrates overloading
   {
     super(ee); //use the parameterized constructor in the superclass with parameter value ee
     System.out.println("enter the expression status (0 ~ real, 1 ~ complex)");
     status = kb.nextInt(); //complete construction of the object
    }
   public void exprOut()
   {
     if(status == 0)
     {
        System.out.println("real expression " + getExpression());
        System.out.println(evaluator());
     }
     else
     {
        System.out.println("complex expression " + getExpression());
     }
    }

   


}    