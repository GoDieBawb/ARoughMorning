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
public class Teddy extends Interactable {
    
    public Teddy() {
        name        = "Teddy";
        description = "Your teddy bear. Mom made it for you. It's all you have left.";
        aliases     = new ArrayList();
        actions     = new ArrayList();
        setAliases();
        setActions();
    }
    
    private void setAliases() {
        aliases.add("teddy");
        aliases.add("bear");
        aliases.add("stuffed");
        aliases.add("animal");
        aliases.add("toy");
    }
    
    private void setActions() {
        actions.add("take");
        actions.add("grab");
        actions.add("get");
        actions.add("pick");
        actions.add("hug");
    }
    
    
    
    @Override
    public String act(String command) {
        
        command = command.toLowerCase();
        
        for (String s : actions) {
            if (command.contains(s)) {
                return "TEDDY";
            }
        }
        
        return "0";
        
    }      
    
}
