package edu.wctc.maze;

public interface PushObserverable {

    void addObserver(PushObserver observer);
    void removeObserver(PushObserver observer);

    void notifyObserverItem(String item);

    void notifyObserverPoints(int points);
}
