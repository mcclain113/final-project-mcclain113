package edu.wctc.maze.SegaCharacter;

import edu.wctc.maze.Companion;

public class DrEggman implements Companion {
    @Override
    public String getName() {
        return "Dr. Eggman";
    }
    @Override
    public void updateItem(String item) {

        System.out.println("DR EGGMAN says: " +item + ", Ha ha ha. Just what I needed!");
    }

    @Override
    public void updatePoints(int points) {
        String stringPoints = Integer.toString(points);
        if(points < 0){
            System.out.println("DR EGGMAN says: Good for you loser. Good bye to " + stringPoints +" points!");
        }

        else {
        System.out.println("DR EGGMAN says: " +stringPoints + " points. Ha, pocket change!");}
    }
}
