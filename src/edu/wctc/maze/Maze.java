package edu.wctc.maze;

import java.io.Console;

public class Maze {
    PrintQueue printQueue = PrintQueue.INSTANCE;
    private Room currentRoom;

    private Player player = new Player();

    /*
     * Maze receives its starting room from the construction strategy
     * in the Main class.
     */
    public Maze(Room startingRoom) {
        this.currentRoom = startingRoom;
    }

    public String getCurrentRoomDescription() {
        return currentRoom.getDescription();
    }

    public String getCurrentRoomName() {
        return currentRoom.getName().toUpperCase();
    }

    public String getCurrentRoomPossibleDirections() {
        return currentRoom.getPossibleDirections();
    }

    public int getScore() {
        return player.getScore();
    }

    public boolean isPlaying() {
        return player.isPlaying();
    }

    public void performAction(char action) {
        switch (action) {
            case 'u':
            case 'd':
            case 'w':
            case 'e':
            case 's':
            case 'n':
                try {
                    printQueue.enqueue("You leave the " + currentRoom.getName());
                    currentRoom = currentRoom.getAdjoiningRoom(action);
                } catch (NoAdjoiningRoomException e) {
                    printQueue.enqueue(String.valueOf(e));
                }
                break;
            case 'v':
                printQueue.enqueue(player.getInventory());
                break;
            case 'r': // 'r' recruit companion
                currentRoom.recruitCompanion(player);
                break;
            default:
                // 'x' exit
                // 'l' loot
                // 'i' interact
                try {
                    currentRoom.performAction(action, player);
                } catch (InvalidActionException e) {
                    printQueue.enqueue(String.valueOf(e));
                }
                break;
        }
    }
}
