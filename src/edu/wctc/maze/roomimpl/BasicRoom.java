package edu.wctc.maze.roomimpl;

import edu.wctc.maze.InvalidActionException;
import edu.wctc.maze.Player;
import edu.wctc.maze.PrintQueue;
import edu.wctc.maze.Room;

public class BasicRoom extends Room {

    PrintQueue printQueue = PrintQueue.INSTANCE;
    public BasicRoom() {
        super("Boring Room",
                "This room is totally nondescript. There is nothing to do or see here.");
    }


    @Override
    public void performAction(char action, Player player) throws InvalidActionException {
        if (action == 'x') {
            player.addToScore(100);
            player.quit();

            printQueue.enqueue("You can't get out of this boring room fast enough!");

        } else {
            throw new InvalidActionException();
        }
    }
}
