package sample.transport.delivery;

public class DeliveryDecorator implements DeliveryOptions {
    DeliveryOptions wrap;

    public DeliveryDecorator(DeliveryOptions deliveryOptions) {
        this.wrap = deliveryOptions;
    }

    @Override
    public void load() {
        wrap.load();
    }

    @Override
    public void unload() {
        wrap.unload();
    }
}
