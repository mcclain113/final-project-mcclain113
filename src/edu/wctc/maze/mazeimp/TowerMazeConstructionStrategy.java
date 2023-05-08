package edu.wctc.maze.mazeimp;

import edu.wctc.maze.MazeConstructionStrategy;
import edu.wctc.maze.Room;
import edu.wctc.maze.roomimpl.BasicRoom;
import edu.wctc.maze.roomimpl.DarkRoom;
import edu.wctc.maze.roomimpl.SimpleRoom;

public class TowerMazeConstructionStrategy implements MazeConstructionStrategy {
    @Override
    public Room createRooms() {
        Room startingRoom = new SimpleRoom();

        Room secondFloorRoom = new DarkRoom();
        startingRoom.setUp(secondFloorRoom);
        secondFloorRoom.setDown(startingRoom);

        Room thirdFloorRoom = new SimpleRoom();
        secondFloorRoom.setUp(thirdFloorRoom);
        thirdFloorRoom.setDown(secondFloorRoom);

        Room pentHouseRoom = new BasicRoom();
        thirdFloorRoom.setUp(pentHouseRoom);
        pentHouseRoom.setDown(thirdFloorRoom);

        // Return the starting room
        return startingRoom;
    }
}
