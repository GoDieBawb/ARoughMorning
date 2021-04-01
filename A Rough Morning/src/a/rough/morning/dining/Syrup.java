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
public class Syrup extends Interactable {
    
    public Syrup() {
        name        = "Syrup";
        description = "A bottle of syrup.";
        aliases     = new ArrayList();
        actions     = new ArrayList();
        setAliases();
        setActions();
    }
    
    private void setAliases() {
        aliases.add("bottle");
        aliases.add("syrup");
    }
    
    private void setActions() {
        actions.add("use");
        actions.add("open");
        actions.add("pour");
        actions.add("eat");
    }
    
    
    
    @Override
    public String act(String command) {
        
        command = command.toLowerCase();
        
        for (String s : actions) {
            if (command.contains(s)) {
                return "USE SYRUP";
            }
        }
        
        return "0";
        
    }
    
}
