/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.rough.morning;

import a.rough.morning.bedroom.Bedroom;
import a.rough.morning.dining.DiningRoom;
import a.rough.morning.hall.Hall;
import a.rough.morning.kitchen.Kitchen;
import a.rough.morning.livingroom.LivingRoom;
import a.rough.morning.nursery.Nursery;
import a.rough.morning.study.Study;
import java.util.Scanner;

/**
 *
 * @author Bob
 */
public class GameManager {
    
    public static String CHECKS[]  = {"look", "check", "see", "look at", "examine", "observe", "room"};
    public static String MOVES[]  = {"move", "travel", "go", "enter", "exit", "leave", "walk", "run"};
    
    public Room    currentRoom, diningRoom, study, livingRoom, kitchen, hall, nursery, bedroom;    
    
    public Player  player;
    Scanner scanner;
    
    public GameManager() {
        player      = new Player();
        diningRoom  = new DiningRoom();
        study       = new Study();
        kitchen     = new Kitchen();
        livingRoom  = new LivingRoom();
        hall        = new Hall();
        nursery     = new Nursery();
        bedroom     = new Bedroom();
        currentRoom = diningRoom;
    }
    
    public void startGame() {
        
        
        System.out.printf("\n\nIt's been a rough morning. You need to eat your pancakes before you leave.\n"
                        + "It doesn't have to get any worse.\n");
        
        scanner = new Scanner(System.in);
        
        System.out.printf("\n%s\n\n", currentRoom.description);
        
        OUTER:
        while (true) {
            System.out.print("Command: ");
            String input  = scanner.nextLine();
            switch (input.toLowerCase()) {
                case "help":
                    System.out.println("Move: \"move\", \"travel\", \"go\", \"enter\", \"exit\", \"leave\", \"walk\", \"run\"");
                    System.out.println("Info: \"look\", \"check\", \"see\", \"look at\", \"examine\", \"observe\", \"room\"");
                    System.out.println("Interact with things in the room by typing commands.");
                    System.out.println("Type \"q\" or \"quit\" to exit the game.");
                    break;
                case "q":
                case "quit":
                    break OUTER;
                default:
                    System.out.printf("\n");
                    currentRoom.act(currentRoom.check(input), this);
                    break;
            }
            System.out.println("");
            if (player.inventory.contains("WIN")) {
                break;
            }
        }
        
        if (player.inventory.contains("WIN")) {
            System.out.printf("It's over...\n\n");
            try {Thread.sleep(5000); } 
            catch (InterruptedException ex) {}
        }
        else 
        System.out.println("Goodbye...");
        
    }
    
}
