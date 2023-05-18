package edu.wctc.maze.SegaCharacter;

import edu.wctc.maze.Companion;

public class SonicTheHedgeHog implements Companion {
    @Override
    public String getName() {
        return "Sonic the Hedgehog";
    }
    @Override
    public void updateItem(String item) {

        System.out.println("SONIC THE HEDGEHOG says: Yesssss! Keep it up!");
    }

    @Override
    public void updatePoints(int points) {
        String stringPoints = Integer.toString(points);
        if(points < 0){
            System.out.println("SONIC THE HEDGEHOG says: Oh Man, you lost... " + stringPoints +" points!");
        }

        else {
        System.out.println("SONIC THE HEDGEHOG says: Congratulations to you for getting those "+ stringPoints + " points!");}
    }
}
