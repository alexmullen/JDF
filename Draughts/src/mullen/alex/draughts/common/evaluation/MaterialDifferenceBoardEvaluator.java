package mullen.alex.draughts.common.evaluation;

import mullen.alex.draughts.common.Board;
import mullen.alex.draughts.common.Piece;
import mullen.alex.draughts.common.Player;

/**
 * A basic board evaluator implementation that simply returns the difference in
 * the scores given to how many pieces and crowned pieces each player has.
 *
 * @author  Alex Mullen
 *
 */
public class MaterialDifferenceBoardEvaluator implements BoardEvaluator {
    /**
     * Creates a new instance.
     */
    public MaterialDifferenceBoardEvaluator() {
        // Empty constructor.
    }
    @Override
    public final float evaluate(final Board board, final Player owner) {
        int ownerPieceCrownedCount = 0;
        int ownerPieceNonCrownedCount = 0;
        int opponentPieceCrownedCount = 0;
        int opponentNonCrownedPieceCount = 0;
        // Go through each square and count the pieces.
        for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                final Piece foundPiece = board.getPieceAt(x, y);
                if (foundPiece != null) {
                    if (foundPiece.getOwner().equals(owner)) {
                        // Owner piece.
                        if (foundPiece.isCrowned()) {
                            ownerPieceCrownedCount++;
                        } else {
                            ownerPieceNonCrownedCount++;
                        }
                    } else {
                        // Opponent piece.
                        if (foundPiece.isCrowned()) {
                            opponentPieceCrownedCount++;
                        } else {
                            opponentNonCrownedPieceCount++;
                        }
                    }
                }
            }
        }
        return ((ownerPieceNonCrownedCount + ownerPieceCrownedCount)
                - (opponentNonCrownedPieceCount + opponentPieceCrownedCount));
    }
    @Override
    public final String toString() {
        return getClass().getSimpleName() + " []";
    }
}