package sample.transport.delivery;

public class AirDelivery implements DeliveryOptions {
    @Override
    public void load() {
        System.out.println("load air transport");
    }

    @Override
    public void unload() {
        System.out.println("unload air transport");
    }
}
