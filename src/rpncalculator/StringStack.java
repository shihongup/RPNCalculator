
package rpncalculator;

/**
 *
 * @author Shifeng Yuan 
 * GWID：G32115270
 */
public class StringStack {
    int size;
    String [] stack;
    int top;
    
    public StringStack(int arraySize){
        top = -1;
        size = arraySize;
        stack = new String [size];
        
    }
    
    public boolean isEmpty(){
        if (top == -1){
            return true;
        }
        else{
            return false;
        }
    }
    
    
    public void push(String num){
        stack[++top] = num;
        }

    public String pop(){
        return stack[top--];
    }
    
    public String peek(){
        if(!isEmpty()){
            return stack[top];
        }
        else{
            return "EMPTYSTACK";
        }
    }
    
}
