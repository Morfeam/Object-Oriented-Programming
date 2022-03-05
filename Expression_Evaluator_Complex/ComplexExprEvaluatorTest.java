

/* program to test the complex expression evaluator; more comments ....
*/

public class ComplexExprEvaluatorTest
{
 
   public static void main(String[] args)
   {
 
    //initialize several expressions, but do not evaluate them immediately
    ComplexExprEvaluator expr1 = new ComplexExprEvaluator(); //construct a complex expression via keyboard
    ComplexExprEvaluator expr2 = new ComplexExprEvaluator(); //construct a complex expression via keyboard
    expr1.exprOut();
    expr2.exprOut();

    Stack1gen<Complex> C = new Stack1gen<Complex>();

    //test the Complex class
    Complex z = new Complex(3,4); //use the paramerterized constructor to build a Complex object
    z.complexPrint();
    C.push(z); //push onto the stack of Complex objects
    
    Complex w = new Complex(); 
    w= C.pop(); //pop z into w
    w.complexPrint();
   
    ComplexExprEvaluator expr3 = new ComplexExprEvaluator("8+9I"); //use the parameterized constructor
    expr3.exprOut();
  
  }

}



