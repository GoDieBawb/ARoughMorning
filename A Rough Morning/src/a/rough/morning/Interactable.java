/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.rough.morning;

import java.util.ArrayList;

/**
 *
 * @author Bob
 */
public abstract class Interactable {
    
    public String name;
    public ArrayList<String> aliases;
    public ArrayList<String> actions;
    public String description;
    
    public abstract String act(String action);
    
}
