package edu.wctc.maze.NintendoCharacter;

import edu.wctc.maze.Companion;
import edu.wctc.maze.CompanionFactory;

public class NintendoCharacterFactory implements CompanionFactory {
    @Override
    public Companion getFriendlyCompanion() {
        return new Mario();
    }

    @Override
    public Companion getSurlyCompanion() {
        return new Wario();
    }
}
