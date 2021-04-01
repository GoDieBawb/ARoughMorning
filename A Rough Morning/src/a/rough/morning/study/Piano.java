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
public class Piano extends Interactable {
    
    public Piano() {
        name        = "Piano";
        description = "A piano that's been there as long as you can remember. The stool is missing...";
        aliases     = new ArrayList();
        actions     = new ArrayList();
        setAliases();
        setActions();
    }
    
    private void setAliases() {
        aliases.add("piano");
        aliases.add("keyboard");
    }
    
    private void setActions() {
        actions.add("play");
        actions.add("song");
    }
    
    
    
    @Override
    public String act(String command) {
        
        command = command.toLowerCase();
        
        for (String s : actions) {
            if (command.contains(s)) {
                return "You play a simple tune on the piano. One you learned from your mother.";
            }
        }
        
        return "0";
        
    }
    
}
