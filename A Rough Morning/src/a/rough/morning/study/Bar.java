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
public class Bar extends Interactable {
    
    public Bar() {
        name        = "Bar";
        description = "A bar with an empty bottle on the counter. You're not supposed to drink this stuff.";
        aliases     = new ArrayList();
        actions     = new ArrayList();
        setAliases();
        setActions();
    }
    
    private void setAliases() {
        aliases.add("bar");
        aliases.add("bottle");
    }
    
    private void setActions() {
        actions.add("take");
        actions.add("grab");
        actions.add("drink");
    }
    
    @Override
    public String act(String command) {
        
        command = command.toLowerCase();
        
        for (String s : actions) {
            if (command.contains(s)) {
                if (s.equals("take") || s.equals("grab")) {
                    return "You're not supposed to touch the bottles on the bar.";
                }
                else {
                    return "You attempt to drink from the bottle. The liquid burns your throat mouth.\n"
                         + "Why does your father drink this stuff so much?";
                }
            }
        }
        
        return "0";
        
    }    
    
}
