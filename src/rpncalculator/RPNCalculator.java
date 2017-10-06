package rpncalculator;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Shifeng Yuan 
 * GWID：G32115270
 */
public class RPNCalculator {
    
    private RPNStack stack = new Stack(104);
    
    public void add(){
         double first = this.stack.pop();
         double second = this.stack.pop();
         this.stack.push(first + second);
    }
    
    public void sub(){
        double first = this.stack.pop();
        double second = this.stack.pop();
        this.stack.push(second - first);
    }
    
    public void div(){
        double first = this.stack.pop();
        double second = this.stack.pop();
        this.stack.push(second / first);
    }
    
    public void mul(){
        double first = this.stack.pop();
        double second = this.stack.pop();
        this.stack.push(first * second);
    }
    
    public void push(double num){
        this.stack.push(num);
    }
    
    public double pop(){
        return this.stack.pop();
    }
    
    public double peek(){
        return this.stack.peek();
    }
    
    public static void main(String[] args) {
        RPNCalculator calc;
        calc = new RPNCalculator();
        Controller cont = new Controller();
        while(true){
            
            Scanner scan = new Scanner(System.in);
            System.out.print("Please Input Your Inflix Expression:");
            String input = scan.nextLine();
            ArrayList<String> list1 = new ArrayList<String>();
            StringDivider stdi = new StringDivider();
            list1 = stdi.stringdivider(input);
            //divide the number and the character
            ToRPN transfer = new ToRPN();     
            ArrayList<String> list2 = transfer.torpn(list1);
            System.out.print("The Postflix Expression:");
            for(String s:list2){
                System.out.print(s + " ");//print postfix notation
            }
            System.out.println(" ");
            for (String s :list2){
                cont.processInput(s);
            }
            
            System.out.println("Result:" + cont.getResult());
            transfer.rpnlist.clear();
            
            
            
            
            
            
        }
        
        
        
        //
    }
    
}











