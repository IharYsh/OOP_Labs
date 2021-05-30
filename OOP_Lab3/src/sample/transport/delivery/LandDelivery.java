package sample.transport.delivery;

public class LandDelivery implements DeliveryOptions {
    @Override
    public void load() {
        System.out.println("load land transport");
    }

    @Override
    public void unload() {
        System.out.println("unload land transport");
    }
}
