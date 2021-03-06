import java.util.Scanner; //Scanner
/* program to test the expression evaluator; evaluates input arithmetic expressions, each
   represented as a string with or without blanks, and with negative numbers indicated by '_'.
   Declare an expression using either ExprEvaluator exp = new ExprEvaluator() 
   (and respond to the prompt), or as ExprEvaluator exp = new ExprEvaluator("expression string").
   The expression can be returned as a String using exp.getExpression().
   The expression can be evaluated using exp.evaluator(), which also displays the result
   rounded to 7 decimal places, supressing a decimal point if the result is an integer. 
   The computed value is also returned as a double.
   
   Name: Matthew Morfea
   Date: 9/10/20
   
*/

public class ExprEvaluatorTest
{
 
   public static void main(String[] args)
   {
    Scanner in =  new Scanner(System.in);
    //initialize several expressions, but do not evaluate them immediately
    ExprEvaluator expr1; //construct an expression via keyboard
    
    //Prompt/Instructions for User
    System.out.println("Hello this is a Mathematical Expression Evaluator. ");
    System.out.println("Here is some basic information on how to this evaluator properly:"); 
    System.out.println("Operators: "  + "\n" + " '+' = Addition \n '-' = Negation \n '*' = Multiplication"); 
    System.out.println(" '/' = Division \n '^' = Exponentiation   \nUse '_' to respresent negative numbers."); 
    System.out.println("This program can hanlde a wide variety of numbers \nincluding numbers with decimals. \nto signify a decimal point please use '.'"); 
    
    //While loop, while i doesnt equal '0' which is the choice for no in the user prompt, the user is prompted to enter an expression
    //where the expression is then evaluated
    int i = 1; 
    while(i != 0)
    {
        System.out.println("Is there an expression to evaluate? Type '1' for Yes or '0' for No:");
        i = in.nextInt(); 
        if(i == 1)
        { 
            expr1 = new ExprEvaluator();
            System.out.println("Expression: " + expr1.getExpression() + '\n');
            expr1.evaluator();
        }else{
            System.out.println("Goodbye."); 
        }
    }
   
  }

}


