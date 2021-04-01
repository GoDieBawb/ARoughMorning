/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.rough.morning.kitchen;

import a.rough.morning.Interactable;
import java.util.ArrayList;

/**
 *
 * @author Bob
 */
public class KnifeSet extends Interactable {
    
    public KnifeSet() {
        name        = "Knife Set";
        description = "A wooden knife block containing a set of sharp knives.";
        aliases     = new ArrayList();
        actions     = new ArrayList();
        setAliases();
        setActions();
    }
    
    private void setAliases() {
        aliases.add("knife");
        aliases.add("knives");
        aliases.add("block");
        aliases.add("set");
    }
    
    private void setActions() {
        actions.add("take");
        actions.add("grab");
        actions.add("get");
        actions.add("retrieve");
        actions.add("return");
        actions.add("drop");
        actions.add("put");
    }
    
    
    
    @Override
    public String act(String command) {
        
        command = command.toLowerCase();
        
        for (String s : actions) {
            if (command.contains(s)) {
                return s.toUpperCase();
            }
        }
        
        return "0";
        
    }
    
}
