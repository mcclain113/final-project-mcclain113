package edu.wctc.maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Player {
    private boolean playing = true;

    private int score = 0;

    private List<String> inventory = new ArrayList<>();

    private List<String> companion = new ArrayList<>();

    public void addToCompanion(String item) {
        companion.add(item);
    }

    public void removeToCompanion(String item) {
                int index = IntStream.range(0, companion.size())
                .filter(i -> Objects.equals(companion.get(i), item))
                .findFirst()
                .orElse(-1);
      companion.remove(index);
    }

    public void addToInventory(String item) {
        inventory.add(item);

        // TODO Module 8: Notify all companions the player acquired a new item

    }

    public void addToScore(int points) {
        score += points;

        // TODO Module 8: Notify all companions the player's score changed

    }

    public String getInventory() {
        if (inventory.isEmpty()) {
            return "Your pockets are empty!";
        }

        String inv = "You are carrying: ";
        inv += String.join(", " , inventory);

        return inv;
    }

    public int getScore() {
        return score;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void quit() {
        playing = false;
    }

}
