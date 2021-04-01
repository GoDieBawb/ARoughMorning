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
public class Fireplace extends Interactable {
    
    public Fireplace() {
        name        = "Fireplace";
        description = "A fireplace with a small fire your father lit this morning.";
        aliases     = new ArrayList();
        actions     = new ArrayList();
        setAliases();
        setActions();
    }
    
    private void setAliases() {
        aliases.add("fire");
        aliases.add("fireplace");
        aliases.add("hearth");
        aliases.add("mantle");
        aliases.add("flames");
    }
    
    private void setActions() {
        actions.add("stoke");
        actions.add("extinguish");
        actions.add("put out");
        actions.add("water");
        actions.add("grab");
        actions.add("take");
        actions.add("put");
        actions.add("burn");
    }
    
    
    
    @Override
    public String act(String command) {
        
        command = command.toLowerCase();
        
        for (String s : actions) {
            if (command.contains(s)) {
                return "Don't play with fire. It's the Devil's only friend.";
            }
        }
        
        return "0";
        
    }    
    
}
