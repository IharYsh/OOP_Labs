package sample.transport.delivery;

public class WaterDelivery implements DeliveryOptions {
    @Override
    public void load() {
        System.out.println("load water transport");
    }

    @Override
    public void unload() {
        System.out.println("unload water transport");
    }
}
