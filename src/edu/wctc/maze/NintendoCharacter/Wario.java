package edu.wctc.maze.NintendoCharacter;

import edu.wctc.maze.Companion;

public class Wario implements Companion {
    @Override
    public String getName() {
        return "Wario";
    }

    @Override
    public void updateItem(String item) {

        System.out.println("WARIO says: Not another " + item+"!");
    }

    @Override
    public void updatePoints(int points) {
        String stringPoints = Integer.toString(points);
        if(points < 0){
            System.out.println("WARIO says: HaHAHaHA, you lose... " + stringPoints +" points!");
        }

        else {
        System.out.println("WARIO says: "+ stringPoints + " points for me to steal!");
        }
    }
}
