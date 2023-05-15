package edu.wctc.maze.mazeimp;

import edu.wctc.maze.CompanionFactory;
import edu.wctc.maze.MazeConstructionStrategy;
import edu.wctc.maze.Room;
import edu.wctc.maze.roomimpl.BasicRoom;
import edu.wctc.maze.roomimpl.DarkRoom;
import edu.wctc.maze.roomimpl.SimpleRoom;

public class BeginnerMazeConstructionStrategy implements MazeConstructionStrategy {

    //The original
    @Override
    public Room createRooms(CompanionFactory companionFactory) {
        Room startingRoom = new BasicRoom();

        Room anotherRoom = new DarkRoom();
        startingRoom.setNorth(anotherRoom);
        anotherRoom.setSouth(startingRoom);

        Room thirdRoom = new SimpleRoom();
        anotherRoom.setDown(thirdRoom);
        thirdRoom.setUp(anotherRoom);
        thirdRoom.setCompanion(companionFactory.getFriendlyCompanion());

        Room finalRoom = new BasicRoom();
        anotherRoom.setEast(finalRoom);
        finalRoom.setWest(anotherRoom);

        // Return the starting room
        return startingRoom;
    }
}
