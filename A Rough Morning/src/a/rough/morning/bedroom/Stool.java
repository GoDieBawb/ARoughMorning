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
public class Stool extends Interactable {
    
    public Stool() {
        name        = "Stool";
        description = "A stool taken from the piano.";
        aliases     = new ArrayList();
        actions     = new ArrayList();
        setAliases();
        setActions();
    }
    
    private void setAliases() {
        aliases.add("stool");
        aliases.add("chair");
        aliases.add("piano");
        aliases.add("stand");
    }
    
    private void setActions() {
        actions.add("place");
        actions.add("move");
        actions.add("up");
        actions.add("fix");
        actions.add("stand");
        actions.add("climb");
        actions.add("righten");
        actions.add("arrange");
    }
    
    
    
    @Override
    public String act(String command) {
        
        command = command.toLowerCase();
        
        for (String s : actions) {
            if (command.contains(s)) {
                return "STOOL";
            }
        }
        
        return "0";
        
    }        
    
}
