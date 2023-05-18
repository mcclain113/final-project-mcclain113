package edu.wctc.maze;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Player implements PushObserverable {
    private boolean playing = true;

    private int score = 0;

    private List<String> inventory = new ArrayList<>();

    private List<String> companion = new ArrayList<>();
    private List<PushObserver> observers = new ArrayList<>();


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
        notifyObserverItem(item);


    }

    public void addToScore(int points) {
        score += points;
        notifyObserverPoints(points);

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

    @Override
    public void addObserver(PushObserver observer) {
        observers.add(observer);}

    @Override
    public void removeObserver(PushObserver observer) {observers.remove(observer);}

    @Override
    public void notifyObserverItem(String item) {
        for(PushObserver observer : observers){
            observer.updateItem(item);}
    }

    @Override
    public void notifyObserverPoints(int points) {
        for(PushObserver observer : observers){
            observer.updatePoints(points);}
    }
}
