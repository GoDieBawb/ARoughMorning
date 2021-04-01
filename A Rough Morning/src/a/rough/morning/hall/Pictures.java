/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.rough.morning.hall;

import a.rough.morning.Interactable;
import java.util.ArrayList;

/**
 *
 * @author Bob
 */
public class Pictures extends Interactable {
    
    public Pictures() {
        name        = "Pictures";
        description = "Pictures of your family.";
        aliases     = new ArrayList();
        actions     = new ArrayList();
        setAliases();
        setActions();
    }
    
    private void setAliases() {
        aliases.add("picture");
        aliases.add("frame");
        aliases.add("photo");
        aliases.add("wall");
    }
    
    private void setActions() {
        actions.add("admire");
        actions.add("look");
        actions.add("view");
    }
    
    
    
    @Override
    public String act(String command) {
        
        command = command.toLowerCase();
        
        for (String s : actions) {
            if (command.contains(s)) {
                return "Pictures of your family during various special occasions.";
            }
        }
        
        return "0";
        
    }        
    
}
