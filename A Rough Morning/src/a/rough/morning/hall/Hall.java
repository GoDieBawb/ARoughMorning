/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.rough.morning.hall;

import a.rough.morning.GameManager;
import a.rough.morning.Room;
import a.rough.morning.livingroom.CoatRack;
import a.rough.morning.livingroom.Fireplace;
import java.util.HashMap;

/**
 *
 * @author Bob
 */
public class Hall extends Room {
    
    public Hall() {
        name          = "Hall";
        interactables = new HashMap();
        doors         = new HashMap();
        description   = "You find yourself in the hallway at the top of the stairs. On the North\n"
                      + "end of the hall is a doorway to your bedroom. On the South end of the hall\n"
                      + "is the door to father's room. He says I'm not allowed inside. Pictures of a\n"
                      + "once happy family line the walls.";
        createInteractables();
        createDoors();
    }
    
    private void createInteractables() {
        interactables.put("Pictures", new Pictures());
    }
    
    private void createDoors() {
        doors.put("north", "NURSERY");
        doors.put("south", "BEDROOM");
        doors.put("stairs", "LIVING");
        doors.put("down", "LIVING");
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
            case "MOVE BEDROOM":
                if (!gm.player.inventory.contains("Radio")) {
                    System.out.println("You place your ear to the door. You can't hear anything. The music\n"
                            + "is too loud. Dad must be busy.");
                }
                else if (!gm.player.inventory.contains("RoomKey")) {
                    System.out.println("The door is locked. Dad must want to be left alone right now.");
                }
                else if (!gm.player.inventory.contains("Teddy")) {
                    System.out.println("You're too scared to go in alone...");
                }
                else {
                    gm.currentRoom = gm.bedroom;
                    System.out.println(gm.currentRoom.description);        
                }
                break;         
            case "MOVE NURSERY":
                gm.currentRoom = gm.nursery;
                System.out.println(gm.currentRoom.description);                
                break;
            default:
                System.out.println(action);
                break;                
        }
    }       
    
}
