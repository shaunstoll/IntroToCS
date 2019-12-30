import java.io.*;
import java.util.Scanner;
public class ExpressionTree {
    private ArrayStack<ExpressionNode> a;

    public ExpressionTree(String postfix) {
        a = new ArrayStack<>();
        if (postfix.equals(null) || postfix.equals("")) {
           throw new IllegalArgumentException("Bad postfix expression.");
        }
        
        Scanner s = new Scanner(postfix);

        while (s.hasNext()) {
            if (s.hasNextInt()) {
                a.push(new ExpressionNode(s.next()));  
            }
            
            else {
                
                String str = s.next();
            
                if (str.equals("+") || str.equals("-") ||
                    str.equals("*") || str.equals("/")) {

                    try {
                        a.push(new ExpressionNode(str, a.pop(), a.pop()));
                    }

                    catch (IndexOutOfBoundsException e) {
                        System.out.println(e);
                        System.out.println("Popped an empty stack. Bad postfix expression.");
                        System.exit(0);
                    }
                }

                else {
                    throw new IllegalArgumentException("Bad postfix expression: " + str);
                }
            }
        }
        
        if (a.topOfStack != 0) {
            throw new IllegalArgumentException("Bad postfix expression.");
        }   
    }
   
    public int eval() {  
        
        return evaluate(a.top());
    }
    
    private int evaluate(ExpressionNode t) {
       if (t.left == null && t.right == null)
           return Integer.parseInt(t.element);
       
       else {
           if (t.element.equals("+"))
              return (evaluate(t.left) + evaluate(t.right));
           if (t.element.equals("-"))
               return (evaluate(t.left) - evaluate(t.right));
           if (t.element.equals("/")) {
               int right = evaluate(t.right); // store value to avoid using recursion twice 
               if (right == 0) {
                   throw new IllegalArgumentException("Cannot divide by zero.");
               }
               return (evaluate(t.left) / right);   
           }
           else
               return (evaluate(t.left) * evaluate(t.right));
       }
    }
    
    public String getPostfix() {
       return postfix(a.top(), "").trim();
    }

    private String postfix(ExpressionNode t, String s) {
        if (t.left == null && t.right == null)
            return s += " " + t.element;
        else 
            return (postfix(t.left, s) + postfix(t.right, s) + " " + t.element);
    }
    
    public static class ExpressionNode {
        String element;
        ExpressionNode left;
        ExpressionNode right;
        
        public ExpressionNode(String element) {
            this(element, null, null);
        }
        
        public ExpressionNode(String element, ExpressionNode right, ExpressionNode left) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }
    
    public static void main(String[] args) {
        String s = "34 2 + 5 /";
        ExpressionTree e = new ExpressionTree(s);
        System.out.println(e.getPostfix());
        System.out.println(e.eval());
    }
    
    
    
}