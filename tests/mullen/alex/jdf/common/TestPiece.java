package mullen.alex.jdf.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import static mullen.alex.jdf.common.Piece.*;

/**
 * Unit tests for {@link Piece}.
 *
 * @author  Alex Mullen
 */
public class TestPiece {
    /**
     * Tests the copy constructor to make sure it produces a copy that is
     * exactly the same and does not change its state when the original
     * changes.
     */
    @SuppressWarnings("static-method")
    @Test
    public final void testCopyConstructor() {
        final Piece originalPiece = new Piece(DARK, DOWN);
        // Now create a clone.
        final Piece clonedPiece = new Piece(originalPiece);
        // Check the fields are the same.
        assertEquals(originalPiece.colour, clonedPiece.colour);
        assertEquals(originalPiece.getMoveDirection(),
                clonedPiece.getMoveDirection());
        assertTrue(originalPiece.isCrowned() == clonedPiece.isCrowned());
        // Crown the original
        originalPiece.crown();
        assertTrue(originalPiece.isCrowned());
        // Assert that the clone has not changed.
        assertEquals(originalPiece.colour, clonedPiece.colour);
        assertTrue(originalPiece.getMoveDirection()
                != clonedPiece.getMoveDirection());
        assertTrue(originalPiece.isCrowned() != clonedPiece.isCrowned());
    }
    /**
     * Tests that the copy constructor throws an NPE if <code>null</code> is
     * passed into it.
     */
    @SuppressWarnings({ "static-method", "unused" })
    @Test (expected = NullPointerException.class)
    public final void testCopyConstructorWithNull() {
        new Piece(null);
    }
    /**
     * Tests that {@link Piece#getMoveDirection()} returns the expected
     * value.
     */
    @SuppressWarnings("static-method")
    @Test
    public final void testGetMoveDirection() {
        final int expectedMoveDirection = DOWN;
        final Piece piece = new Piece(DARK, expectedMoveDirection);
        assertEquals(expectedMoveDirection, piece.getMoveDirection());
        // Test the move direction has changed after crowning.
        piece.crown();
        assertEquals(Piece.BOTH, piece.getMoveDirection());
    }
    /**
     * Tests that {@link Piece#isCrowned()} returns expected values.
     */
    @SuppressWarnings("static-method")
    @Test
    public final void testIsCrowned() {
        final Piece piece = new Piece(DARK, UP);
        assertFalse(piece.isCrowned());
        /*
         * A piece that is not crowned should not be able to move in both
         * directions.
         */
        assertTrue(BOTH != piece.getMoveDirection());
        piece.crown();
        // Should be now crowned.
        assertTrue(piece.isCrowned());
        // A piece that is crowned should be able to move in both directions.
        assertEquals(BOTH, piece.getMoveDirection());
        // Test a piece is crowned when crowned in the constructor.
        final Piece crownedPiece = new Piece(DARK, BOTH);
        // Should be already crowned.
        assertTrue(crownedPiece.isCrowned());
        // A piece that is crowned should be able to move in both directions.
        assertEquals(BOTH, crownedPiece.getMoveDirection());
    }
    /**
     * Tests that {@link Piece#crown()} causes
     * {@link Piece#isCrowned()} to return <code>true</code> and
     * {@link Piece#getMoveDirection()} to return
     * {@link Piece#BOTH}.
     */
    @SuppressWarnings("static-method")
    @Test
    public final void testCrown() {
        final Piece piece = new Piece(DARK, UP);
        // Should not be crowned yet.
        assertFalse(piece.isCrowned());
        piece.crown();
        // Should be now crowned.
        assertTrue(piece.isCrowned());
        // A piece that is crowned should be able to move in both directions.
        assertTrue(BOTH == piece.getMoveDirection());
    }
    /**
     * Tests that {@link Piece#equals(Object)} tests for equality correctly.
     */
    @SuppressWarnings("static-method")
    @Test
    public final void testEquals() {
        final int colour1 = DARK;
        final int colour2 = LIGHT;
        final Piece piece1 = new Piece(colour1, DOWN);
        final Piece piece2 = new Piece(colour2, UP);
        final Piece piece1Copy = new Piece(piece1);
        final Piece piece2Copy = new Piece(piece2);
        // Test null.
        assertFalse(piece1.equals(null));
        assertFalse(piece2.equals(null));
        // Test identity equality.
        assertTrue(piece1.equals(piece1));
        assertTrue(piece2.equals(piece2));
        // Test non-identity equality.
        assertTrue(piece1.equals(piece1Copy));
        assertTrue(piece2.equals(piece2Copy));
        assertTrue(piece1Copy.equals(piece1));
        assertTrue(piece2Copy.equals(piece2));
        // Test non-identity equality after crowning original pieces.
        piece1.crown();
        piece2.crown();
        assertFalse(piece1.equals(piece1Copy));
        assertFalse(piece2.equals(piece2Copy));
        assertFalse(piece1Copy.equals(piece1));
        assertFalse(piece2Copy.equals(piece2));
    }
}
