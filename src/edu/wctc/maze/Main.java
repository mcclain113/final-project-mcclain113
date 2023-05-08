package edu.wctc.maze;


import edu.wctc.maze.io.ConsoleInputService;
import edu.wctc.maze.io.ConsoleOutputService;
import edu.wctc.maze.io.InputService;
import edu.wctc.maze.io.OutputService;
import edu.wctc.maze.mazeimp.BeginnerMazeConstructionStrategy;
import edu.wctc.maze.mazeimp.DangerousMazeConstructionStrategy;
import edu.wctc.maze.mazeimp.TowerMazeConstructionStrategy;
import edu.wctc.maze.roomimpl.BasicRoom;
import edu.wctc.maze.roomimpl.DarkRoom;
import edu.wctc.maze.roomimpl.SimpleRoom;

public class Main {
    // Create Room objects and link them together to
    // form a maze
/*    private static Room createRooms() {
        Room startingRoom = new BasicRoom();

        Room anotherRoom = new DarkRoom();
        startingRoom.setNorth(anotherRoom);
        anotherRoom.setSouth(startingRoom);

        Room thirdRoom = new SimpleRoom();
        anotherRoom.setDown(thirdRoom);
        thirdRoom.setUp(anotherRoom);

        Room finalRoom = new BasicRoom();
        anotherRoom.setEast(finalRoom);
        finalRoom.setWest(anotherRoom);

        // Return the starting room
        return startingRoom;
    }*/

    public static void main(String[] args) {
        PrintQueue printQueue = PrintQueue.INSTANCE;
        InputService in = new ConsoleInputService();

        OutputService out = new ConsoleOutputService();

        // TODO Module 7: Create a companion factory and pass it to the construction strategy


/*        BeginnerMazeConstructionStrategy beginnerMaze = new BeginnerMazeConstructionStrategy();
        Maze maze = new Maze(beginnerMaze.createRooms());*/

        DangerousMazeConstructionStrategy dangerMaze = new DangerousMazeConstructionStrategy();
        Maze maze = new Maze(dangerMaze.createRooms());

/*        TowerMazeConstructionStrategy towerMaze = new TowerMazeConstructionStrategy();
        Maze maze = new Maze(towerMaze.createRooms());*/


        while (maze.isPlaying()) {
            out.print(maze.getCurrentRoomName());

            out.print(maze.getCurrentRoomDescription());

            out.print(maze.getCurrentRoomPossibleDirections());

            char command = in.getInput();
            maze.performAction(command);

            System.out.println(printQueue.flush());
        }

        out.print("GAME OVER");
        out.print("Score: " + maze.getScore());
    }
}
