package edu.wctc.maze.roomimpl;

import edu.wctc.maze.*;

public class DangerRoom extends Room {
    PrintQueue printQueue = PrintQueue.INSTANCE;

    public DangerRoom() {
        super("Danger Room", "Watch out for explosions");
    }

    @Override
    public void performAction(char action, Player player) throws InvalidActionException {
        if (action == 'o') {
            player.addToScore(-10);
            printQueue.enqueue("Ouch!");
        } else {
            throw new InvalidActionException();
        }
    }
}
