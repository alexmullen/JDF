package uk.ac.tees.aia.mullen.draughts.research;

import uk.ac.tees.aia.mullen.draughts.common.Player;

/**
 * A class for holding statistical data about a benchmarked gamed.
 *
 * @author  Alex Mullen
 *
 */
public class GameStatistics {
    /** Indicates whether the game was a draw. */
    private boolean draw;
    /** Holds the game ID. */
    private final int gameId;

    /** Holds the number of moves the light player has currently made. */
    public int light_moves_made;
    /** Holds the number of moves the dark player has currently made. */
    public int dark_moves_made;

    public int white_move_time;
    public int dark_move_time;

    /** Holds the winner of the game. */
    private Player winner;
    /** Holds the loser of the game. */
    private Player loser;
    /**
     * Creates a new instance for the specified game iteration ID.
     *
     * @param id  the game iteration ID
     */
    GameStatistics(final int id) {
        gameId = id;
    }
    /**
     * Gets the game ID.
     * @return  the ID
     */
    public final int getGameID() {
        return gameId;
    }
    /**
     * Gets whether the game was a draw or not.
     * @return  <code>true</code> if the game was a draw; else
     *          <code>false</code>
     */
    public final boolean isDraw() {
        return draw;
    }
    /**
     * Sets whether the game was a draw or not.
     * @param value  <code>true</code> if the game was a draw; else
     * <code>false</code>
     */
    public final void setDraw(final boolean value) {
        draw = value;
    }
    /**
     * Gets the winner of the game.
     * @return  the winning player
     */
    public final Player getWinner() {
        return winner;
    }
    /**
     * Sets the winning player.
     * @param winningPlayer  the winning player
     */
    public final void setWinner(final Player winningPlayer) {
        winner = winningPlayer;
    }
    /**
     * Gets the losing player.
     * @return  the losing player
     */
    public final Player getLoser() {
        return loser;
    }
    /**
     * Sets the losing player.
     * @param losingPlayer  the losing player
     */
    public final void setLoser(final Player losingPlayer) {
        loser = losingPlayer;
    }
    @Override
    public final String toString() {
        return "GameStatistics [draw=" + draw + ", gameId=" + gameId
                + ", player1_moves_made=" + light_moves_made
                + ", player2_moves_made=" + dark_moves_made
                + ", player1_move_time=" + white_move_time
                + ", player2_move_time=" + dark_move_time + ", winner="
                + winner + ", loser=" + loser + "]";
    }
}
