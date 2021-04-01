/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.rough.morning.dining;

import a.rough.morning.GameManager;
import a.rough.morning.Room;
import java.util.HashMap;

/**
 *
 * @author Bob
 */
public class DiningRoom extends Room {
    
    public DiningRoom() {
        name          = "Dining Room";
        interactables = new HashMap();
        doors         = new HashMap();
        description   = "You're in a dining room with a kitchen table. There is a China cabinet containing\n"
                      + "dishes up against the wall. There are seats for six people. There is a plate of\n"
                      + "pancakes sitting on the table near a bottle of syrup. There are doors on the North\n"
                      + "and West sides of the room.";
        createInteractables();
        createDoors();
    }
    
    private void createInteractables() {
        interactables.put("Syrup", new Syrup());
        interactables.put("Pancakes", new Pancakes());
        interactables.put("China Cabinet", new ChinaCabinet());
    }
    
    private void createDoors() {
        doors.put("north", "STUDY");
        doors.put("west", "KITCHEN");
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void act(String action, GameManager gm) {
        
        switch (action) {
            case "MOVE STUDY":
                if (gm.player.inventory.contains("Pancakes")) {
                    gm.currentRoom = gm.study;
                    System.out.println(gm.currentRoom.description);
                }
                else {
                    System.out.println("You're not leaving until you've eaten your pancakes.");
                }
                break;
            case "MOVE KITCHEN":
                if (gm.player.inventory.contains("Pancakes")) {
                    gm.currentRoom = gm.kitchen;
                    System.out.println(gm.currentRoom.description);
                }
                else {
                    System.out.println("You can't leave until you've eaten your pancakes.");
                }                
                break;
            case "USE SYRUP":
                if (gm.player.inventory.contains("Syrup")) { 
                    System.out.println("You've already used the syrup.");
                }
                else {
                    System.out.println("You grab the bottle of syrup and pour the it over your panakes.");
                    gm.player.inventory.add("Syrup");
                    gm.diningRoom.description = gm.diningRoom.description.replace("a bottle", "an empty bottle");
                    gm.diningRoom.interactables.get("Syrup").description = "An empty bottle of syrup.";
                }
                break;
            case "EAT PANCAKES":
                if (gm.player.inventory.contains("Pancakes")) {
                    System.out.println("You already ate your pancakes... Hopefully the day goes better now.");
                }
                else if (gm.player.inventory.contains("Syrup")) {
                    System.out.println("You eat the pancakes.");
                    gm.player.inventory.add("Pancakes");
                    gm.diningRoom.description = gm.diningRoom.description.replace("a plate of\npancakes", "an empty plate");
                    gm.diningRoom.interactables.get("Syrup").description = "An empty plate.";                    
                }
                else {
                    System.out.println("This isn't how you like your pancakes. Mom used to put more syrup.");
                }
                
                break;                
            default:
                System.out.println(action);
                break;
        }
        
    }
    
}
