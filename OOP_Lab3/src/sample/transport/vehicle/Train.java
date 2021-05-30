package sample.transport.vehicle;

import sample.transport.delivery.DeliveryDecorator;
import sample.transport.delivery.LandDelivery;
import sample.transport.engine.Engine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Train")
public class Train extends LandVehicle {
    private final static String TYPE = "Train";

    public Train(){
        super(TYPE, null, null);
    }

    public Train(String model, Engine engine) {
        super(TYPE, model, engine);
    }

    @Override
    public Vehicle create(String vehicleModel, Engine engine) {
        return new Train(vehicleModel, engine);
    }

    @Override
    public void deliver() {
        DeliveryDecorator delivery = new DeliveryDecorator(new LandDelivery());
        delivery.load();
        go();
        delivery.unload();
    }

    @Override
    public void go() {
        System.out.println("train go");
    }
}
