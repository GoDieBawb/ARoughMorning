/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.rough.morning.study;

import a.rough.morning.Interactable;
import java.util.ArrayList;

/**
 *
 * @author Bob
 */
public class Glass extends Interactable {
    
    public Glass() {
        name        = "Bookcase";
        description = "A broken glass sits on the floor.";
        aliases     = new ArrayList();
        actions     = new ArrayList();
        setAliases();
        setActions();
    }
    
    private void setAliases() {
        aliases.add("glass");
        aliases.add("cup");
        aliases.add("broken");
        aliases.add("shatter");
    }
    
    private void setActions() {
        actions.add("take");
        actions.add("grab");
        actions.add("touch");
        actions.add("hold");
    }
    
    
    
    @Override
    public String act(String command) {
        
        command = command.toLowerCase();
        
        for (String s : actions) {
            if (command.contains(s)) {
                return "BLOOD";
            }
        }
        
        return "0";
        
    }      
    
}
