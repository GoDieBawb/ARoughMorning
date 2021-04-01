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
public class Appliances extends Interactable {
    
    public Appliances() {
        name        = "Appliances";
        description = "A series of standard kitchen appliances can be seen around the room.";
        aliases     = new ArrayList();
        actions     = new ArrayList();
        setAliases();
        setActions();
    }
    
    private void setAliases() {
        aliases.add("oven");
        aliases.add("washer");
        aliases.add("sink");
        aliases.add("coffee");
        aliases.add("stove");
        aliases.add("fridge");
    }
    
    private void setActions() {
        actions.add("use");
        actions.add("on");
        actions.add("off");
        actions.add("cook");
        aliases.add("open");
        aliases.add("close");
    }
    
    
    
    @Override
    public String act(String command) {
        
        command = command.toLowerCase();
        
        for (String s : actions) {
            if (command.contains(s)) {
                return "You're not supposed to use the appliances. It's already a bad day.";
            }
        }
        
        return "0";
        
    }    
    
}
