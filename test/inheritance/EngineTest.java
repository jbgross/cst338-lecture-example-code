package inheritance;

import static org.junit.jupiter.api.Assertions.*;

class EngineTest {
    Engine fiveCyl;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        fiveCyl = new Engine(5);
    }

    @org.junit.jupiter.api.Test
    void getCylinders() {
        assertEquals(5, fiveCyl.getCylinders());
    }

    @org.junit.jupiter.api.Test
    void isRunning() {
        assertFalse(fiveCyl.isRunning());
        fiveCyl.start();
        assertTrue(fiveCyl.isRunning());
        fiveCyl.stop();
        assertFalse(fiveCyl.isRunning());
    }

    @org.junit.jupiter.api.Test
    void start() {
        fiveCyl.start();
        assertThrows(IllegalStateException.class, () -> fiveCyl.start());
    }

    @org.junit.jupiter.api.Test
    void stop() {
        assertThrows(IllegalStateException.class, () -> fiveCyl.stop());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        assertEquals("Engine{cylinders=5, isRunning=false}", fiveCyl.toString());
        fiveCyl.start();
        assertEquals("Engine{cylinders=5, isRunning=true}", fiveCyl.toString());
    }
}