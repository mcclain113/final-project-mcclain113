package edu.wctc.maze;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Room {
    PrintQueue printQueue = PrintQueue.INSTANCE;
    private String name, description;
    private Map<Character, Room> connectedRooms = new HashMap<>();
    private Companion companion = null;

    public void setCompanion(Companion companion) {
        this.companion = companion;
    }

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Room getAdjoiningRoom(char direction) throws NoAdjoiningRoomException {
        if (connectedRooms.containsKey(direction)) {
            return connectedRooms.get(direction);
        }

        throw new NoAdjoiningRoomException(direction);
    }

    public String getDescription() {


        if (companion != null){
            return this.description + " " +companion.getName() + " is here.";
        }
        else{return this.description;}
    }

    public String getName() {
        return name;
    }

    public String getPossibleDirections() {
        List<String> directions = connectedRooms.keySet()
                .stream()
                .map(direction -> {
                    switch (direction) {
                        case 'n':
                            return "North";
                        case 's':
                            return "South";
                        case 'e':
                            return "East";
                        case 'w':
                            return "West";
                        case 'u':
                            return "Up";
                        case 'd':
                            return "Down";
                    }
                    return "";
                }).collect(Collectors.toList());

        return directions.isEmpty() ?
                "You don't see any exits." :
                "The exits are: " + String.join(", ", directions);
    }

    public abstract void performAction(char action, Player player) throws InvalidActionException;

    public void recruitCompanion(Player player) {
        if (companion != null){
            player.addToCompanion(companion.getName());
            printQueue.enqueue(companion.getName() + " joins you");
            companion=null;
        }
        else{printQueue.enqueue("Recruit who? There is no one else here.");}
    }
    public void setDown(Room room) {
        connectedRooms.put('d', room);
    }

    public void setEast(Room room) {
        connectedRooms.put('e', room);
    }

    public void setNorth(Room room) {
        connectedRooms.put('n', room);
    }

    public void setSouth(Room room) {
        connectedRooms.put('s', room);
    }

    public void setUp(Room room) {
        connectedRooms.put('u', room);
    }

    public void setWest(Room room) {
        connectedRooms.put('w', room);
    }
}
