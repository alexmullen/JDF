package mullen.alex.jdf.variant.english;

import mullen.alex.jdf.common.Game;
import mullen.alex.jdf.common.GameBuilder;

/**
 * A game builder implementation for English draughts.
 *
 * @author  Alex Mullen
 *
 */
public class EnglishDraughtsGameBuilder implements GameBuilder {
    @Override
    public final String getName() {
        return "English";
    }
    @Override
    public final boolean isForcedCapturesConfigurable() {
        return false;
    }
    @Override
    public final boolean isFirstTurnConfigurable() {
        return false;
    }
    @Override
    public final Game build(final Config config) {
        return new EnglishDraughtsGame(config.getLightPlayer(),
                config.getDarkPlayer());
    }
    @Override
    public final String toString() {
        return getName();
    }
}
