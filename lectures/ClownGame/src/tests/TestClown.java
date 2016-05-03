package tests;

import model.Clown;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestClown {

    // Test that a single clown works like you expect, when it starts out sitting
    @Test
    public void testOneClownSitting() {
        Clown c = new Clown(false);
        assertFalse(c.getIsStanding());
        c.flip();
        assertTrue(c.getIsStanding());
    }

    // Test that a single clown works like you expect, when it starts out standing
    @Test
    public void testOneClownStanding() {
        Clown c = new Clown(true);
        assertTrue(c.getIsStanding());
        c.flip();
        assertFalse(c.getIsStanding());
    }
}
