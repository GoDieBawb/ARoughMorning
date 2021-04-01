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
public class Note extends Interactable {
    
        public Note() {
        name        = "Note";
        description = "A note written by your father.";
        aliases     = new ArrayList();
        actions     = new ArrayList();
        setAliases();
        setActions();
    }
    
    private void setAliases() {
        aliases.add("note");
        aliases.add("letter");
        aliases.add("book");
        aliases.add("bed");
        aliases.add("written");
    }
    
    private void setActions() {
        actions.add("read");
        actions.add("search");
        actions.add("examine");
        actions.add("check");
        actions.add("interpret");
        actions.add("judge");
    }
    
    
    
    @Override
    public String act(String command) {
        
        command = command.toLowerCase();
        
        for (String s : actions) {
            if (command.contains(s)) {
                return "You can't read... You hope it says 'I'm sorry son... You know it wasn't an accident.";
            }
        }
        
        return "0";
        
    }    
}
