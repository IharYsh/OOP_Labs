package sample.transport.vehicle;

import sample.transport.delivery.DeliveryDecorator;
import sample.transport.delivery.LandDelivery;
import sample.transport.engine.Engine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Truck")
public class Truck extends LandVehicle {
    private final static String TYPE = "Truck";

    public Truck() {
        super(TYPE, null, null);
    }

    public Truck(String model, Engine engine) {
        super(TYPE, model, engine);
    }

    @Override
    public Vehicle create(String vehicleModel, Engine engine) {
        return new Truck(vehicleModel, engine);
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
        System.out.println("truck go");
    }
}
