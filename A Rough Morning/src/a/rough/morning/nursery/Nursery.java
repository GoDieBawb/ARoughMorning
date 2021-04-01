/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.rough.morning.nursery;

import a.rough.morning.GameManager;
import a.rough.morning.Room;
import a.rough.morning.livingroom.CoatRack;
import a.rough.morning.livingroom.Fireplace;
import java.util.HashMap;

/**
 *
 * @author Bob
 */
public class Nursery extends Room {
    
    public Nursery() {
        name          = "Nursery";
        interactables = new HashMap();
        doors         = new HashMap();
        description   = "This is your bedroom. You don't spend much time in here since dad got rid of\n"
                      + "all your toys. He said ten years old was time to grow up. You wish mom were here\n"
                      + "to tell him. The only toy left in the room was the teddy bear mom sewed for you\n"
                      + "before she died. I guess dad couldn't bring himself to get rid of it. It still\n"
                      + "sits on the bed where you left it this morning. A doorway leads out of the room\n"
                      + "to the West.";
        createInteractables();
        createDoors();
    }
    
    private void createInteractables() {
        interactables.put("Teddy", new Teddy());
        interactables.put("Bed", new Bed());
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
            case "MOVE HALL":
                gm.currentRoom = gm.hall;
                System.out.println(gm.currentRoom.description);
                break;
            case "TEDDY":
                if (gm.player.inventory.contains("Teddy")) {
                }
                else {
                    System.out.println("You pick up your teddy bear.");
                    description = description.replace("The only toy left in the room was", "You're holding");
                    gm.player.inventory.add("Teddy");
                }
                break;
            default:
                System.out.println(action);
                break;                
        }
    }       
    
}
