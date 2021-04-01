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
public class Radio extends Interactable {
    public Radio() {
        name        = "Radio";
        description = "A radio playing loud music. It hurts your ears.";
        aliases     = new ArrayList();
        actions     = new ArrayList();
        setAliases();
        setActions();
    }
    
    private void setAliases() {
        aliases.add("radio");
        aliases.add("stereo");
    }
    
    private void setActions() {
        actions.add("off");
        actions.add("on");
        actions.add("down");
        actions.add("up");
        actions.add("increase");
        actions.add("lower");
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
