/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.rough.morning.livingroom;

import a.rough.morning.GameManager;
import a.rough.morning.Room;
import java.util.HashMap;

/**
 *
 * @author Bob
 */
public class LivingRoom extends Room {
    
    public LivingRoom() {
        name          = "Living Room";
        interactables = new HashMap();
        doors         = new HashMap();
        description   = "This is the living room. Flames crackle in the fireplace in the corner. Memories\n"
                      + "of the accident always haunt you in this room. At least dad calls it an accident.\n"
                      + "Sometimes you wish you could wake up and Mom was here again. She's not coming\n"
                      + "back and you realize that now. A coat rack with dad's coat sits near the front\n"
                      + "door to your West. There are doors to the South and East of the room as well.\n"
                      + "A set of stairs leads up to the second story where dad went after cooking breakfast.";
        createInteractables();
        createDoors();
    }
    
    private void createInteractables() {
        interactables.put("Coat Rack", new CoatRack());
        interactables.put("Fireplace", new Fireplace());
    }
    
    private void createDoors() {
        doors.put("west", "OUTSIDE");
        doors.put("south", "KITCHEN");
        doors.put("east", "STUDY");
        doors.put("stairs", "HALL");
        doors.put("up", "HALL");
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public void act(String action, GameManager gm) {
        switch (action) {
            case "MOVE KITCHEN":
                gm.currentRoom = gm.kitchen;
                System.out.println(gm.currentRoom.description);
                break;
            case "MOVE STUDY":
                gm.currentRoom = gm.study;
                System.out.println(gm.currentRoom.description);                
                break;         
            case "MOVE HALL":
                gm.currentRoom = gm.hall;
                System.out.println(gm.currentRoom.description);                
                break;
            case "MOVE OUTSIDE":
                if (gm.player.inventory.contains("DoorKey")) {
                    System.out.println("You escape the house. Hopefully the day gets better from here.");
                    gm.player.inventory.add("WIN");
                }
                else {
                    System.out.println("The door is deadbolted and needs a key.");
                }
                break;
            case "POCKET":
                if (gm.player.inventory.contains("RoomKey")) {
                    System.out.println("There's nothing else in the jacket pockets.");
                }
                else {
                    System.out.println("You search the jacket pockets. You find the key to your parents bedroom.");
                    gm.player.inventory.add("RoomKey");
                }
                break;
            default:
                System.out.println(action);
                break;                
        }
    }       
    
}
