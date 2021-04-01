/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.rough.morning.nursery;

import a.rough.morning.Interactable;
import java.util.ArrayList;

/**
 *
 * @author Bob
 */
public class Bed extends Interactable {
    
    public Bed() {
        name        = "Bed";
        description = "Your bed. It's the only place you can see mom anymore. Dreams come and go.";
        aliases     = new ArrayList();
        actions     = new ArrayList();
        setAliases();
        setActions();
    }
    
    private void setAliases() {
        aliases.add("bed");
        aliases.add("sheet");
        aliases.add("blanket");
    }
    
    private void setActions() {
        actions.add("lay");
        actions.add("lie");
        actions.add("sleep");
        actions.add("hide");
    }
    
    
    
    @Override
    public String act(String command) {
        
        command = command.toLowerCase();
        
        for (String s : actions) {
            if (command.contains(s)) {
                return "You've slept enough today...";
            }
        }
        
        return "0";
        
    }        
    
}
