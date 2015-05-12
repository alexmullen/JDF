package uk.ac.tees.aia.mullen.draughts.research;

import java.util.ArrayList;
import java.util.List;

import uk.ac.tees.aia.mullen.draughts.common.ArtificialPlayer;
import uk.ac.tees.aia.mullen.draughts.common.BasicBoardEvaluator;
import uk.ac.tees.aia.mullen.draughts.common.Game;
import uk.ac.tees.aia.mullen.draughts.common.Move;
import uk.ac.tees.aia.mullen.draughts.common.Game.GameResult;
import uk.ac.tees.aia.mullen.draughts.common.search.
                                            MinimaxAlphaBetaDepthLimited;
import uk.ac.tees.aia.mullen.draughts.common.search.MinimaxTimeLimited;
import uk.ac.tees.aia.mullen.draughts.common.search.MoveSearch;
import uk.ac.tees.aia.mullen.draughts.english.EnglishDraughtsGame;

/**
 * A class used for automating the benchmarking of two AI {@link MoveSearch}
 * algorithms.
 *
 * @author  Alex Mullen
 *
 */
public final class SearchComparisonBenchmark {
    /** Holds the number of games to play in the benchmark. */
    private static final int GAME_ITERATIONS_COUNT = 100;
    /**
     * Creates a new instance.
     */
    private SearchComparisonBenchmark() {
        // Empty.
    }
    /**
     * Main program entry point.
     *
     * @param args  supplied program arguments
     */
    public static void main(final String... args) {
        final MoveSearch searchAlgo1 =
                new MinimaxAlphaBetaDepthLimited(new BasicBoardEvaluator(), 4);
        final MoveSearch searchAlgo2 =
                new MinimaxTimeLimited(new BasicBoardEvaluator(), 25);

        final ArtificialPlayer ai1 =
                new ArtificialPlayer(searchAlgo1, "AI-1");
        final ArtificialPlayer ai2 =
                new ArtificialPlayer(searchAlgo2, "AI-2");

        final List<GameStatistics> gameStatsList = new ArrayList<>();

        for (int currentGameIteration = 0;
                currentGameIteration < GAME_ITERATIONS_COUNT;
                currentGameIteration++) {
            /*
             * Create a statistics object for holding statistics about the
             * current game.
             */
            final GameStatistics stats =
                    new GameStatistics(currentGameIteration);
            gameStatsList.add(stats);
            // Create the next game.
            final Game gameContext = new EnglishDraughtsGame(ai1, ai2);

            // Record the time the game starts at.
            final long gameStartTime = System.currentTimeMillis();

            // Play it until it finishes.
            while (gameContext.getResult() == null) {
                /*
                 * Ask the current AI player for its move then input it into
                 * the game.
                 */
                final ArtificialPlayer aiTurnOwner =
                        (ArtificialPlayer) gameContext.getTurnOwner();
                final Move aiMove = aiTurnOwner.getMove(gameContext);
                gameContext.performMove(aiMove);
                // Increment the number of moves made.
                stats.setMovesMade(stats.getMovesMade() + 1);
            }
            // The game has ended so print the result.
            final GameResult result = gameContext.getResult();

            stats.setGameTime(System.currentTimeMillis() - gameStartTime);
            stats.setWinner(result.getWinner());
            stats.setLoser(gameContext.getOpponent(result.getWinner()));

            System.out.println(stats);
        }
    }
}
