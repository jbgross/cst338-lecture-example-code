package inheritance;

public class Engine {
    private final int cylinders;
    private boolean isRunning;

    public Engine(int cylinders) {
        this.cylinders = cylinders;
        this.isRunning = false;
    }

    public int getCylinders() {
        return this.cylinders;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void start() {
        if(isRunning) {
            throw new IllegalStateException("cannot start a running engine");
        }
        isRunning = true;
    }

    public void stop() {
        if(! isRunning) {
            throw new IllegalStateException("cannot stop a stopped engine");
        }
        isRunning = false;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "cylinders=" + cylinders +
                ", isRunning=" + isRunning +
                '}';
    }

}
