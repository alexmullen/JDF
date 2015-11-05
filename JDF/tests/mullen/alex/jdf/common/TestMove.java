package mullen.alex.jdf.common;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * Unit tests for {@link Move}.
 *
 * @author  Alex Mullen
 */
public class TestMove {
    /**
     * Tests the object with some typical expected arguments.
     */
    @SuppressWarnings("static-method")
    @Test
    public final void testWithValidArgs() {
        final BoardPosition fromPos = new BoardPosition(1, 3);
        final BoardPosition toPos = new BoardPosition(1, 5);
        final Move move = new Move(fromPos, toPos);
        assertNotNull(move.from);
        assertNotNull(move.to);
        assertEquals(fromPos, move.from);
        assertEquals(toPos, move.to);
    }
}
