
package rpncalculator;

/**
 *
 * @author Shifeng Yuan 
 * GWID：G32115270
 */
public interface RPNStack {
    public void push(double num);
    
    public double pop();
    
    public double peek();
    
}

class Stack implements RPNStack{
    int size;
    double [] stack;
    int top;
      
    public Stack(int arraySize){
        top = -1;
        size = arraySize;
        stack = new double [size];
        
    }
    
    public boolean isEmpty(){
        if (top == -1){
            return false;
        }
        else{
            return true;
        }
    }
    
    
    public void push(double num){
        stack[++top] = num;
        }

    public double pop(){
        return stack[top--];
    }
    
    public double peek(){
        //return the first number of the stack
        return stack[top];
    }
    
}