package inheritance;

public class Car {
    private final int doors;
    private final Engine engine;
    private int fuelLevel;
    private int speed;
    public static final int MAX_FUEL = 10;

    public Car(int doors, int cylinders) {
        this.doors = doors;
        this.engine = new Engine(cylinders);
        this.fuelLevel = 0;
        this.speed = 0;
        System.out.println("I'm a car");
    }

    public void start() {
        if(fuelLevel < 1) {
            throw new IllegalStateException("cannot start car with no fuel");
        }
        this.engine.start();
        this.fuelLevel--;
    }

    public void stop() {
        this.engine.stop();
    }

    public void accelerate() {
        if(! this.engine.isRunning()) {
            throw new IllegalStateException("cannot accelerate a car that is not running");
        }

        if(this.fuelLevel < 1) {
            throw new IllegalStateException("cannot accelerate a car with no fuel");
        }

        this.speed++;
        this.fuelLevel--;
    }

    public void brake() {
        if(this.speed > 0) {
            this.speed--;
        }
    }

    public int getFuelLevel () {
        return this.fuelLevel;
    }


    public int getSpeed() {
        return this.speed;
    }

    public int getDoors() {
        return this.doors;
    }

    public void refill() {
        this.fuelLevel = MAX_FUEL;
    }

    public void refill(int amount) {
        if(amount + this.fuelLevel <= MAX_FUEL) {
            this.fuelLevel += amount;
        } else {
            this.fuelLevel = MAX_FUEL;
        }
    }


    @Override
    public String toString() {
        return "Car{" +
                "doors=" + doors +
                ", engine=" + engine +
                ", fuelLevel=" + fuelLevel +
                ", speed=" + speed +
                '}';
    }

}
