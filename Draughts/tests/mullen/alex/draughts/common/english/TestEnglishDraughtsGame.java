package mullen.alex.draughts.common.english;

import mullen.alex.draughts.common.ArtificialPlayer;
import mullen.alex.draughts.common.Move;
import mullen.alex.draughts.common.Game.GameResult;
import mullen.alex.draughts.common.evaluation.MaterialDifferenceBoardEvaluator;
import mullen.alex.draughts.common.search.MinimaxAlphaBetaDepthLimited;
import mullen.alex.draughts.common.search.MoveSearch;
import mullen.alex.draughts.english.EnglishDraughtsGame;

public class TestEnglishDraughtsGame {
    static EnglishDraughtsGame game;
    static long startTime;
    public static void main(final String... args) {
        final MoveSearch searchAlgo1 =
                new MinimaxAlphaBetaDepthLimited(new MaterialDifferenceBoardEvaluator(), 2, 0);
        final MoveSearch searchAlgo2 =
                new MinimaxAlphaBetaDepthLimited(new MaterialDifferenceBoardEvaluator(), 12, 0);

        final ArtificialPlayer ai1 =
                new ArtificialPlayer(searchAlgo1, "AI-1");
        final ArtificialPlayer ai2 =
                new ArtificialPlayer(searchAlgo2, "AI-2");

        game = new EnglishDraughtsGame(ai1, ai2);

        int moveCount = 0;
        startTime = System.currentTimeMillis();
        while (game.getResult() == null) {
            final ArtificialPlayer aiTurnOwner =
                    (ArtificialPlayer) game.getTurnOwner();
            final Move aiMove = aiTurnOwner.getMove(game);
            game.performMove(aiMove);
            moveCount++;
        }

        final GameResult result = game.getResult();

        System.out.println(result.getWinner() + " : "
                + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println("total moves performed: " + moveCount);
    }
}