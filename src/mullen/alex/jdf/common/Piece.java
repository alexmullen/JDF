package mullen.alex.jdf.common;

/**
 * An abstract implementation that represents a piece on a board.
 *
 * @author  Alex Mullen
 *
 */
public class Piece {
    /** Represents the dark coloured pieces. */
    public static final int DARK = 0;
    /** Represents the light coloured pieces. */
    public static final int LIGHT = 1;
    /** Represents the up direction on a board a piece can move in. */
    public static final int UP = 2;
    /** Represents the down direction on a board a piece can move in. */
    public static final int DOWN = 3;
    /** Represents the up and down directions on a board a piece can move in. */
    public static final int BOTH = 4;
    /** Holds the colour of this piece. */
    public final int colour;
    /** Holds the movement direction this piece can do. */
    private int moveDirection;
    /**
     * Creates a new instance that is of the specified colour and is
     * only to be allowed to move in the specified direction.
     * <p>
     * A <code>direction</code> value of {@link #BOTH} effectively
     * crowns this piece and {@link #isCrowned()} will return <code>true</code>.
     *
     * @param pieceColour  the colour of the piece - either {@link #DARK} or
     *                     {@link #LIGHT}
     * @param direction    the direction this piece is allowed to move in -
     *                     either {@link #UP}, {@link #DOWN} or {@link #BOTH}
     */
    public Piece(final int pieceColour, final int direction) {
        colour = pieceColour;
        moveDirection = direction;
    }
    /**
     * Creates a new instance that is a copy of the specified piece.
     *
     * @param piece  the piece to copy
     *
     * @see #Piece(int, int)
     */
    public Piece(final Piece piece) {
        colour = piece.colour;
        moveDirection = piece.moveDirection;
    }
    /**
     * Gets the opposing colour of the specified colour.
     * <p>
     * The opposing colour of {@link #DARK} is {@link #LIGHT} and vice versa.
     *
     * @param colour  either {@link #DARK} or {@link #LIGHT}
     * @return        the opposing colour
     */
    public static int getOpposingColourOf(final int colour) {
        return colour == DARK ? LIGHT : DARK;
    }
    /**
     * Gets the direction this piece is allowed to move in.
     *
     * @return  the allowed direction
     */
    public final int getMoveDirection() {
        return moveDirection;
    }
    /**
     * Gets whether this piece has been crowned.
     *
     * @return  <code>true</code> if this piece is crowned; <code>false</code>
     *          otherwise
     * @see     #crown()
     */
    public final boolean isCrowned() {
        return moveDirection == BOTH;
    }
    /**
     * Crowns this piece.
     *
     * @see  #isCrowned()
     */
    public final void crown() {
        moveDirection = BOTH;
    }
    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + moveDirection;
        result = prime * result + colour;
        return result;
    }
    /**
     * Indicates whether this piece is equal to the specified piece.
     * <p>
     * Two pieces are equal if they have the same identity or they have the same
     * owner and move direction.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Piece other = (Piece) obj;
        if (moveDirection != other.moveDirection) {
            return false;
        }
        return colour == other.colour;
    }
    @Override
    public final String toString() {
        return "Piece [colour=" + colour + ", getMoveDirection()="
                + getMoveDirection() + ", isCrowned()=" + isCrowned() + "]";
    }
}
