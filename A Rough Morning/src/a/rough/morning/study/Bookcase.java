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
public class Bookcase extends Interactable {
    
    public Bookcase() {
        name        = "Bookcase";
        description = "A large bookcase filled with books.";
        aliases     = new ArrayList();
        actions     = new ArrayList();
        setAliases();
        setActions();
    }
    
    private void setAliases() {
        aliases.add("case");
        aliases.add("book");
    }
    
    private void setActions() {
        actions.add("take");
        actions.add("grab");
        actions.add("read");
    }
    
    
    
    @Override
    public String act(String command) {
        
        command = command.toLowerCase();
        
        for (String s : actions) {
            if (command.contains(s)) {
                if (s.equals("take") || s.equals("grab")) {
                    return "You don't know which book to choose. There's too many.";
                }
                else {
                    return "You don't know how to read.";
                }
            }
        }
        
        return "0";
        
    }    
    
}
