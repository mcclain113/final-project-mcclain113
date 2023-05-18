package edu.wctc.maze.NintendoCharacter;

import edu.wctc.maze.Companion;
import edu.wctc.maze.PushObserver;
import org.w3c.dom.ls.LSOutput;

public class Mario implements Companion {


    @Override
    public String getName() {
        return "Mario";
    }

    @Override
    public void updateItem(String item) {

        System.out.println("MARIO says: Good work getting " + item+"!");
    }

    @Override
    public void updatePoints(int points) {
        String stringPoints = Integer.toString(points);
        if(points < 0){
            System.out.println("MARIO says: shucks... " + stringPoints +" points!");
        }

        else {

            System.out.println("MARIO says: Score, " + stringPoints + " points!");
        }
    }


}
