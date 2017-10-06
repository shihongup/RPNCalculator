/**
 *
 * @author Shifeng Yuan 
 * GWID：G32115270
 */
package rpncalculator;

import java.util.ArrayList;

public class StringDivider {
    
    ArrayList<String> store = new ArrayList<String>();
        
    public ArrayList<String> stringdivider(String input){
        //divide the number and the character
        int j = 0;
        for(int i = 0; i < input.length(); i++){
            
            int n = 0;
            char s = input.charAt(i);
            if(isDigit(s)){
                    if( i == (input.length()-1)){
                        store.add(input.substring(j,i+1));
                    }
                
            }
            else{
                    if (i != 0){
                        
                        char s1 = input.charAt(i-1);
                        if(isDigit(s1)){
                            store.add(input.substring(j,i));  //make digits number
                    }
                    }
                    store.add(input.substring(i,i+1));
                    j = i+1;
            }
            
        }
        return store;
               
    }
    public boolean isDigit(char s){
        //identify the digit
        if((s >= 48 && s <=57) || (s == '.')){
            return true;
        }
        else{
            return false;
        }
    }
}
