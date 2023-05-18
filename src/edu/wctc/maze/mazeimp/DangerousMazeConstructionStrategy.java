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
        Room startingRoom = new BasicRoom(); // X = 100points

        Room anotherRoom = new DarkRoom();  // I = club and -5points
        startingRoom.setNorth(anotherRoom);
        anotherRoom.setSouth(startingRoom);
        anotherRoom.setCompanion(companionFactory.getFriendlyCompanion()); //R = friendly companion

        Room dangerRoom = new DangerRoom(); // O =  -10points
        anotherRoom.setEast(dangerRoom);
        dangerRoom.setWest(anotherRoom);
        dangerRoom.setCompanion(companionFactory.getSurlyCompanion()); //R = surly companion

        Room thirdRoom = new SimpleRoom(); // L = scraps and 100points
        dangerRoom.setDown(thirdRoom);
        thirdRoom.setUp(dangerRoom);

        Room finalRoom = new BasicRoom(); //X = 100points
        dangerRoom.setEast(finalRoom);
        finalRoom.setWest(dangerRoom);

        // Return the starting room
        return startingRoom;
    }
}
