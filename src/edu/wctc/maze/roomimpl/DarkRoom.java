package edu.wctc.maze.roomimpl;

import edu.wctc.maze.InvalidActionException;
import edu.wctc.maze.Player;
import edu.wctc.maze.PrintQueue;
import edu.wctc.maze.Room;

public class DarkRoom extends Room {
    PrintQueue printQueue = PrintQueue.INSTANCE;
    public DarkRoom() {
        super("Dark Room",
                "This room is pitch dark. You are likely to be eaten by a grue.");
    }

    @Override
    public void performAction(char action, Player player) throws InvalidActionException {
        if (action == 'i') {
            player.addToScore(-5);
            player.addToInventory("Club");
            printQueue.enqueue("Does stumbling around bumping into things count as interacting?");
        } else {
            throw new InvalidActionException();
        }
    }
}
