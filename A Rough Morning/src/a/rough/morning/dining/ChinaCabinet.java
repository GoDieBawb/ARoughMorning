/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.rough.morning.dining;

import a.rough.morning.Interactable;
import java.util.ArrayList;

/**
 *
 * @author Bob
 */
public class ChinaCabinet extends Interactable {
    
    public ChinaCabinet() {
        name        = "China Cabinet";
        description = "A cabinet containing various dishes and tableware.";
        aliases     = new ArrayList();
        actions     = new ArrayList();
        setAliases();
        setActions();
    }
    
    private void setAliases() {
        aliases.add("china");
        aliases.add("cabinet");
        aliases.add("cupboard");
        aliases.add("drawers");
    }
    
    private void setActions() {
    }    
    
    @Override
    public String act(String command) {
        
        command = command.toLowerCase();
        
        for (String s : actions) {
            if (command.contains(s)) {
            }
        }
        
        return "You don't want to break anything. Don't make today any worse.";
        
    }
    
}
