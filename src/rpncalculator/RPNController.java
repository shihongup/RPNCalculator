
package rpncalculator;

/**
 *
 * @author Shifeng Yuan 
 * GWID：G32115270
 */
public interface RPNController {
    public void processInput(String input);
    
}

class Controller implements RPNController{
    private RPNCalculator calc= new RPNCalculator();
    
    
    public void processInput(String input){
        //make string to double and compute 
        try{
            double num = Double.parseDouble(input);
            this.calc.push(num);            
        }catch(NumberFormatException ex){
                for (int i = 0; i < input.length(); i++){
                this.processInput(input.charAt(i));
            
            }
        }
        
    }
    
    private void processInput(char input){
        //compute then put the result into stack
        if (input == '+'){
            this.calc.add();
        }else if(input == '-'){
            this.calc.sub();
        }else if(input == '*'){
            this.calc.mul();
        }else if(input == '/'){
            this.calc.div();
        }else if(input == '('||input == ')'){
            
        }
    }
    
    public double getResult(){
        //return the result
        double result = this.calc.peek();
        return result;
    }
    
}