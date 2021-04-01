/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.rough.morning.dining;

import a.rough.morning.Interactable;
import java.util.ArrayList;

/**
 *
 * @author Bob
 */
public class Pancakes extends Interactable {
    
    public Pancakes() {
        name        = "Pancakes";
        description = "A plate of pancakes.";
        aliases     = new ArrayList();
        actions     = new ArrayList();
        setAliases();
        setActions();
    }
    
    private void setAliases() {
        aliases.add("pancakes");
        aliases.add("plate");
        aliases.add("food");
    }
    
    private void setActions() {
        actions.add("eat");
    }
    
    @Override
    public String act(String command){
        
        command = command.toLowerCase();
        for (String s : actions) {
            if (command.contains(s)) {
                return "EAT PANCAKES";
            }
        }        
        
        return "0";
        
    }
    
}
