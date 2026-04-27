package inheritance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car c;
    @BeforeEach
    void setUp() {
        c = new Car(4,5);
    }

    @Test
    void start() {
        assertThrows(IllegalStateException.class, () -> c.start()); // no fuel
        c.refill();
        c.start();
        assertThrows(IllegalStateException.class, () -> c.start()); // already started
    }


    @Test
    void stop() {
        assertThrows(IllegalStateException.class, () -> c.stop()); //already stopped
        c.refill();
        c.start();
        c.stop();
    }

    @Test
    void accelerate() {
        assertThrows(IllegalStateException.class, () -> c.accelerate()); // not started
        c.refill();
        c.start();
        c.accelerate();
        assertEquals(1, c.getSpeed());
        for(int i = 0; i < 4; i++) {
            c.accelerate();
            assertEquals(i + 2, c.getSpeed());
        }
        c.stop();
        c.refill();
        for(int i = 0; i < 9; i++) {
            c.start();
            c.stop();
        }
        c.start();
        assertThrows(IllegalStateException.class, () -> c.accelerate()); // not started
    }

    @Test
    void brake() {
        c.refill();
        c.start();
        for(int i = 0; i < 5; i++) {
            c.accelerate();
        }
        for(int i = 4; i >= 0; i--) {
            c.brake();
            assertEquals(i, c.getSpeed());
        }
        // make sure that we stop decelerating at zero
        c.brake();
        assertEquals(0, c.getSpeed());
    }

    @Test
    void getFuelLevel() {
        assertEquals(0, c.getFuelLevel());
        c.refill();
        assertEquals(10, c.getFuelLevel());
    }

    @Test
    void getSpeed() {
        assertEquals(0, c.getSpeed());
        c.refill();
        c.start();
        assertEquals(0, c.getSpeed());
    }

    @Test
    void getDoors() {
        assertEquals(4, c.getDoors());
    }

    @Test
    void refill() {
        c.refill(1);
        assertEquals(1, c.getFuelLevel());
        c.start();
        c.stop();
        assertEquals(0, c.getFuelLevel());
        c.refill();
        assertEquals(10, c.getFuelLevel());
        c.start();
        c.stop();
        assertEquals(9, c.getFuelLevel());
        c.refill(5);
        assertEquals(10, c.getFuelLevel());
    }

    @Test
    void testToString() {
        assertEquals( "Car{doors=4, engine=Engine{cylinders=5, isRunning=false}, " +
                "fuelLevel=0, speed=0}", c.toString());
    }
}