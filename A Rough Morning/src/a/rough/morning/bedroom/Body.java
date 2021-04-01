/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.rough.morning.bedroom;

import a.rough.morning.Interactable;
import java.util.ArrayList;

/**
 *
 * @author Bob
 */
public class Body extends Interactable {
    
    public Body() {
        name        = "Dad";
        description = "Your father's corpse hangs from a rope. He couldn't take it anymore.";
        aliases     = new ArrayList();
        actions     = new ArrayList();
        setAliases();
        setActions();
    }
    
    private void setAliases() {
        aliases.add("dad");
        aliases.add("body");
        aliases.add("corpse");
        aliases.add("rope");
    }
    
    private void setActions() {
        actions.add("cut");
        actions.add("knife");
        actions.add("stab");
        actions.add("slice");
        actions.add("lower");
        actions.add("search");
        actions.add("pocket");
        actions.add("find");
    }
    
    
    
    @Override
    public String act(String command) {
        
        command = command.toLowerCase();
        
        for (String s : actions) {
            if (command.contains(s)) {
                return s.toUpperCase();
            }
        }
        
        return "0";
        
    }         
    
}
