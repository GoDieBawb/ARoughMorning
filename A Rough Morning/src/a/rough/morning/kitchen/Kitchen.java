/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.rough.morning.kitchen;

import a.rough.morning.GameManager;
import a.rough.morning.Room;
import java.util.HashMap;

/**
 *
 * @author Bob
 */
public class Kitchen extends Room {
    
    public Kitchen() {
        name          = "Kitchen";
        interactables = new HashMap();
        doors         = new HashMap();
        description   = "You find yourself in the kitchen. Not a lot goes on in here anymore, it\n"
                      + "feels cold and different than it used to. Besides the standard appliances\n"
                      + "around the room nothing is unusual. A set of knives sit in a wooden block\n"
                      + "on the counter.";
        createInteractables();
        createDoors();
    }
    
    private void createInteractables() {
        interactables.put("Knife Set", new KnifeSet());
        interactables.put("Appliances", new Appliances());
    }
    
    private void createDoors() {
        doors.put("north", "LIVING");
        doors.put("east", "DINING");
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public void act(String action, GameManager gm) {
        switch (action) {
            case "MOVE LIVING":
                gm.currentRoom = gm.livingRoom;
                System.out.println(gm.currentRoom.description);
                break;
            case "MOVE DINING":
                gm.currentRoom = gm.diningRoom;
                System.out.println(gm.currentRoom.description);                
                break;
            case "TAKE":
            case "GRAB":
            case "GET":
            case "RETRIEVE":
                if (gm.player.inventory.contains("Knife")) {
                    System.out.println("You already have a knife.");
                }
                else {
                    System.out.println("You take the largest and sharpest knife from the wooden block.");
                    gm.player.inventory.add("Knife");
                }                
                break;
            case "RETURN":
            case "DROP":
            case "PUT":
                if (gm.player.inventory.contains("Knife")) {
                    System.out.println("You carefully place the knife back into the wooden block.");
                    gm.player.inventory.remove("Knife");
                }
                else {
                    System.out.println("You don't have anything put into the knife block.");
                }
                break;                
            default:
                System.out.println(action);
                break;                
        }
    }       
    
}
