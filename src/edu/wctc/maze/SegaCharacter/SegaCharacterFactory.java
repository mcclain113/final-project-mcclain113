package edu.wctc.maze.SegaCharacter;

import edu.wctc.maze.Companion;
import edu.wctc.maze.CompanionFactory;

public class SegaCharacterFactory implements CompanionFactory {
    @Override
    public Companion getFriendlyCompanion() {
        return new SonicTheHedgeHog();
    }

    @Override
    public Companion getSurlyCompanion() {
        return new DrEggman();
    }
}
