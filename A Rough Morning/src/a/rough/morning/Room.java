 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.rough.morning;

import java.util.HashMap;

/**
 *
 * @author Bob
 */
public abstract class Room {
    
    public    HashMap<String, Interactable> interactables;
    public    HashMap<String, String>       doors;
    public    String                        description;
    protected String                        name;
    
    public String getDescription() {
        return description;
    }
    
    public HashMap<String, Interactable> getInteractables() {
        return interactables;
    }
    
    public String check(String command) {
        
        command = command.toLowerCase();
        
        for (String s : GameManager.MOVES) {
            if (command.contains(s)) {
                for (String d : doors.keySet()) {
                    if (command.contains(d)) {
                        return "MOVE " + doors.get(d);
                    }
                }
                return "You can't go that way.";
            }
        }        
        
        for (String s : GameManager.CHECKS) {
            if (command.contains(s)) {
                for (Interactable i : interactables.values()) {
                    for (String a : i.aliases) {
                        if (command.contains(a)) {
                            return i.description;
                        }
                    }
                }
                return description;
            }
        }
        
        for (Interactable i : interactables.values()) {
            for (String a : i.aliases) {
                if (command.contains(a)) {
                    String result = i.act(command);
                    if (!result.equals("0")) {
                        return result;
                    }
                    return "I don't understand what you want with the " + i.name;
                }
            }
        }
        return "I don't understand.";
    }
    
    public abstract void act(String action, GameManager gm);
    
}
