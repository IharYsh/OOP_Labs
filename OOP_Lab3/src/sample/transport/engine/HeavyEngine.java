package sample.transport.engine;

public class HeavyEngine implements Engine {
    private static Engine engine;

    private HeavyEngine() {

    }

    public static Engine getEngine() {
        if (engine != null)
            return engine;
        engine = new HeavyEngine();
        return engine;
    }

    @Override
    public int getSpeed() {
        return 20;
    }
}
