import java.io.*;
import java.util.Scanner;

public class SymbolBalance {

    public static BalanceError checkFile(String pathToFile) { 
        final File file = new File(pathToFile);
        Scanner scanner = null;
        
        try { 
            scanner = new Scanner(file);
        }    
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(0);
        }

        ArrayStack s = new ArrayStack();
        char[] c = null;
        int lineNumber = 0;
        int stackIntType = 0; //checkout the stackType method for an explanation
       
        while (scanner.hasNextLine()) {
            lineNumber++;
            String line = scanner.nextLine();
            c = line.toCharArray();
            
            for (int i = 0; i < c.length; i++) {
                stackIntType = stackType(s);
            
                switch (stackIntType) {

                    case 1: // " on top of stack
                        if (c[i] == '"') { //check remainder of line for closing quote
                            s.pop();
                            break;
                        }
                        if (i == c.length - 1) { //line doesn't contain closing quote
                            return new NonEmptyStackError((char)s.top(), s.topOfStack + 1);
                        }
                        else {break;}
                    
                        
                    case 2: // * on top of stack
                        if (c[i] == '*' && i != c.length - 1) { //check remainder of file for */
                            if (c[i + 1] == '/') {
                                s.pop();
                                i++; // because we just checked ahead
                                break;
                            }
                        }
               
                        if (!scanner.hasNextLine() && i == c.length - 1) { // at the last char of file
                           return new NonEmptyStackError((char)s.top(), s.topOfStack + 1);
                        }
                        else {break;}
                    
                    case 3: // {, [, ( on top of stack 
                        if (c[i] == '{' || c[i] == '[' || c[i] == '('
                           || c[i] == '"') {
                            s.push(c[i]);
                            break;
                        }
                        if (c[i] == '/' && i != c.length - 1) {
                            if (c[i + 1] == '*') {
                                s.push('*');
                                i++;
                                break;
                            }
                        }
                        if ((s.top().equals('{') && c[i] == '}') || 
                            (s.top().equals('[') && c[i] == ']') ||
                            (s.top().equals('(') && c[i] == ')')) {
                            s.pop();
                            break;
                        }
                        if ((!s.top().equals('{') && c[i] == '}') || 
                            (!s.top().equals('[') && c[i] == ']') ||
                            (!s.top().equals('(') && c[i] == ')')) {
                            return new MismatchError(lineNumber, c[i], (char)s.pop());
                        }
                        else {break;}
                             
                    case 4: // null on top of stack
                        if (c[i] == '{' || c[i] == '[' || c[i] == '(' || c[i] == '"') {
                            s.push(c[i]);
                            break;
                        }
                        if (c[i] == '/' && i != c.length - 1) {
                            if (c[i + 1] == '*') {
                                s.push('*');
                                i++;
                                break;
                            }
                        }
                        if (c[i] == '}' || c[i] == ']' || c[i] == ')') {
                            return new EmptyStackError(lineNumber);
                        }
                        else {break;}
                }
            }
        }
        if (!s.isEmpty()) {return new NonEmptyStackError((char)s.top(), s.topOfStack + 1);}
        else {return null;}
    }
    
    //This method allows me to use a switch switch statement.
    public static int stackType(ArrayStack s) {
        if (s.isEmpty()) {return 4;}
        if (s.top().equals('"')) {return 1;}
        if (s.top().equals('*')) {return 2;}
        else {return 3;}
    }
        
    public static void main(String[] args) {
            
        if (args.length != 1) {
            throw new IllegalArgumentException("Must include a file.");
        }
        
        BalanceError b = checkFile(args[0]);
        
        if (b != null) {
            System.out.println(checkFile(args[0]).toString());
        }  
        else {
            System.out.println("OK");
        }
    }
}                                                    