package edu.wctc.maze.mazeimp;

import edu.wctc.maze.CompanionFactory;
import edu.wctc.maze.MazeConstructionStrategy;
import edu.wctc.maze.Room;
import edu.wctc.maze.roomimpl.BasicRoom;
import edu.wctc.maze.roomimpl.DangerRoom;
import edu.wctc.maze.roomimpl.DarkRoom;
import edu.wctc.maze.roomimpl.SimpleRoom;

public class DangerousMazeConstructionStrategy implements MazeConstructionStrategy {
    @Override
    public Room createRooms(CompanionFactory companionFactory) {
        Room startingRoom = new BasicRoom();

        Room anotherRoom = new DarkRoom();
        startingRoom.setNorth(anotherRoom);
        anotherRoom.setSouth(startingRoom);
        anotherRoom.setCompanion(companionFactory.getFriendlyCompanion());

        Room dangerRoom = new DangerRoom();
        anotherRoom.setEast(dangerRoom);
        dangerRoom.setWest(anotherRoom);
        dangerRoom.setCompanion(companionFactory.getSurlyCompanion());

        Room thirdRoom = new SimpleRoom();
        dangerRoom.setDown(thirdRoom);
        thirdRoom.setUp(dangerRoom);

        Room finalRoom = new BasicRoom();
        dangerRoom.setEast(finalRoom);
        finalRoom.setWest(dangerRoom);

        // Return the starting room
        return startingRoom;
    }
}
