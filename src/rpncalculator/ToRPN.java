/**
 *
 * @author Shifeng Yuan 
 * GWID：G32115270
 */
package rpncalculator;

import java.util.ArrayList;

public class ToRPN {
    StringStack stack = new StringStack(10);
    static ArrayList<String> rpnlist = new ArrayList<String>();
    static int len = 0;
    static int n =0;
    public ArrayList<String> torpn(ArrayList<String> oristring){        
        //transfer the original list to RPN list
        
        
        for(String s:oristring){
            
            len++;
        }
        for(String s:oristring){
            
            ++n;
            reorder(s);
        }
        
        return rpnlist;        
    }

    public ArrayList<String> reorder(String ostr){

        if((ostr.equals("("))||(ostr.equals(")"))||(ostr.equals("+"))||(ostr.equals("-"))||(ostr.equals("*"))||(ostr.equals("/"))){
            
            int prior = priority(ostr);
            
            if(prior == 1){
                // if it is a (
                this.stack.push(ostr);
                
                
            }else if(prior == 4){
                //if it is a )
                String top = this.stack.pop();
                while(!top.equals("(")){
                    rpnlist.add(top);
                    top = this.stack.pop();
      
                }
                
            }else if(prior == 2){
                //if it is a + or -
                this.stack.push(ostr);
                while(true){
                    String first = this.stack.pop();
                    if (!this.stack.isEmpty()){
                        String second = this.stack.pop();
                        int prior1 = priority(first);
                        int prior2 = priority(second);
                        if(prior1<=prior2){
                            rpnlist.add(second);
                            this.stack.push(first);
                            continue;
                            
                        }else{
                            this.stack.push(second);
                            this.stack.push(first);
                            
                        }
                    }else{
                        
                            this.stack.push(first);
                            break;

                    }
                    break;
                    }
            }else{
                //if it is a * or /
                this.stack.push(ostr);
                while(true){
                    String first = this.stack.pop();
                    if (!this.stack.isEmpty()){
                        String second = this.stack.pop();
                        int prior1 = priority(first);
                        int prior2 = priority(second);
                        if(prior1<=prior2){
                            rpnlist.add(second);
                            this.stack.push(first);
                            continue;
                            
                        }else{
                            this.stack.push(second);
                            this.stack.push(first);
                            
                        }
                    }else{
                        
                            this.stack.push(first);
                            break;

                    }
                    break;
                    }                
            }
        }else{
            rpnlist.add(ostr);
            
        }
        if((!this.stack.isEmpty())&&n == len){
            while((!this.stack.isEmpty())){
                    rpnlist.add(this.stack.pop());
            }
        }
        
        return rpnlist;
        }
    public  int priority(String ostr){
        //get the priority
        switch(ostr){
            case "(": return 1;
            case "+": return 2;
            case "-": return 2;
            case "*": return 3;
            case "/": return 3;
            case ")": return 4;
            default: throw new IllegalArgumentException("Operator Error");
        }
        
    }
}
