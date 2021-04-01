/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.rough.morning.study;

import a.rough.morning.GameManager;
import a.rough.morning.Room;
import java.util.HashMap;

/**
 *
 * @author Bob
 */
public class Study extends Room {
    
    public Study() {
        name          = "Study";
        interactables = new HashMap();
        doors         = new HashMap();
        description   = "You're in a study. There is a piano in the corner of the room, the stool is missing.\n"
                      + "A radio plays loudly against the South wall. A heavily filled bookcase sits in the\n"
                      + "corner opposite the piano. A broken glass litters the floor near a small bar with a\n"
                      + "half empty bottle open on the counter. There are doors on the South and West sides of\n"
                      + "the room.";
        createInteractables();
        createDoors();
    }
    
    private void createInteractables() {
        interactables.put("Piano", new Piano());
        interactables.put("Bookcase", new Bookcase());
        interactables.put("Radio", new Radio());
        interactables.put("Bar", new Bar());
        interactables.put("Glass", new Glass());
    }
    
    private void createDoors() {
        doors.put("south", "DINING");
        doors.put("west", "LIVING");
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public void act(String action, GameManager gm) {
        switch (action) {
            case "MOVE DINING":
                gm.currentRoom = gm.diningRoom;
                System.out.println(gm.currentRoom.description);
                break;
            case "MOVE LIVING":
                gm.currentRoom = gm.livingRoom;
                System.out.println(gm.currentRoom.description);                
                break;
            case "BLOOD":
                if (gm.player.inventory.contains("Blood")) {
                    System.out.println("You don't want to touch the glass again.");
                }
                else {
                    System.out.println("You attempt to pick up the broken glass. You cut your fingers and your"
                         + "blood drips onto the shards as you drop it back to the floor.");
                    gm.player.inventory.add("Blood");
                    gm.study.interactables.get("Glass").description = "Blood covered shards from a broken glass sit on the floor.";
                    gm.study.description = gm.study.description.replace("A broken glass", "A blood stained broken glass");
                }
                break;
            case "ON":   
            case "UP":
            case "INCREASE":
                if (gm.player.inventory.contains("Radio")) {
                    System.out.println("You turn knobs on the radio until the music plays loudly.");
                    description = description.replace("is silent", "plays loudly");
                    gm.player.inventory.remove("Radio");
                }
                else {
                    System.out.println("The radio can't get any louder. The noise is deafening");
                }
                break;
            case "OFF":
            case "DOWN":
            case "LOWER":
                if (gm.player.inventory.contains("Radio")) {
                    System.out.println("The radio isn't making noise anymore.");
                }
                else {
                    System.out.println("You turn knobs on the radio until it goes silent.");
                    description = description.replace("plays loudly", "is silent");
                    gm.player.inventory.add("Radio");
                }                
                break;
            default:
                System.out.println(action);
                break;                
        }
    }    
    
}
