/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.rough.morning.bedroom;

import a.rough.morning.GameManager;
import a.rough.morning.Room;
import java.util.HashMap;

/**
 *
 * @author Bob
 */
public class Bedroom extends Room {
    
    public Bedroom() {
        name          = "Bedroom";
        interactables = new HashMap();
        doors         = new HashMap();
        description   = "You're standing in your parents bedroom. Your father's corpse hangs from a rope tied\n"
                      + "to the ceiling next to a knocked over stool. His feet almost touch the ground as he\n"
                      + "gently sways back and forth. A hand-written note sits on the bed. The door back to the\n"
                      + "hallway is to your West.";
        createInteractables();
        createDoors();
    }
    
    private void createInteractables() {
        interactables.put("Stool", new Stool());
        interactables.put("Body", new Body());
        interactables.put("Note", new Note());
    }
    
    private void createDoors() {
        doors.put("west", "HALL");
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public void act(String action, GameManager gm) {
        switch (action) {
            case "SEARCH":
            case "FIND":
            case "POCKET":
            case "CHECK":
                if (gm.player.inventory.contains("DoorKey")) {
                    System.out.println("There is nothing else in your dead father's pockets.");
                }
                else if (gm.player.inventory.contains("Rope")) {
                    System.out.println("You search your father's pockets... You find the key to the deadbolt.");
                    gm.player.inventory.add("DoorKey");
                }
                else {
                    System.out.println("You're unable to search the body while it's still hanging.");
                }
                break;            
            case "CUT":
            case "SLICE":
            case "STAB":
            case "KNIFE":
            case "LOWER":    
                if (gm.player.inventory.contains("Stool")) {
                    
                    if (gm.player.inventory.contains("Rope")) {
                        System.out.println("You've already cut the rope. There's no need to mutiliate the body.");
                    }
                    else if (gm.player.inventory.contains("Knife")) {
                        System.out.println("Standing on the stool you use the knife to cut the rope. Your\n"
                                          + "father's corpse falls to the floor." );
                        gm.player.inventory.add("Rope");
                    }
                    else {
                        System.out.println("You are unable to get his body down. If only you could cut the rope.");
                    }
                }
                else {
                    System.out.println("You're unable to reach the rope to get the body down.");
                }
                break;
            case "STOOL":
                if (gm.player.inventory.contains("Stool")) {
                    System.out.println("You stand up on the stool.");
                }
                else {
                    System.out.println("You place the stool upright next to your father's body.");
                    description = description.replace("knocked over ", "");
                    gm.player.inventory.add("Stool");
                }
                break;
            case "MOVE HALL":
                gm.currentRoom = gm.hall;
                System.out.println(gm.currentRoom.description);
                break;
            default:
                System.out.println(action);
                break;                
        }
    }       
    
}
