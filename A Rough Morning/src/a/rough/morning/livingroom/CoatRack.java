/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.rough.morning.livingroom;

import a.rough.morning.Interactable;
import java.util.ArrayList;

/**
 *
 * @author Bob
 */
public class CoatRack extends Interactable {
    
    public CoatRack() {
        name        = "Coat Rack";
        description = "A coat rack with your father's coat hanging on it.";
        aliases     = new ArrayList();
        actions     = new ArrayList();
        setAliases();
        setActions();
    }
    
    private void setAliases() {
        aliases.add("coat");
        aliases.add("rack");
        aliases.add("jacket");
        aliases.add("pocket");
    }
    
    private void setActions() {
        actions.add("search");
        actions.add("pocket");
    }
    
    
    
    @Override
    public String act(String command) {
        
        command = command.toLowerCase();
        
        for (String s : actions) {
            if (command.contains(s)) {
                return "POCKET";
            }
        }
        
        return "0";
        
    }    
    
}
