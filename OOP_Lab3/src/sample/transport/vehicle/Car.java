package sample.transport.vehicle;

import sample.transport.delivery.DeliveryDecorator;
import sample.transport.delivery.WaterDelivery;
import sample.transport.engine.Engine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Car")
public class Car extends LandVehicle {
    private final static String TYPE = "Car";

    public Car(){
        super(TYPE, null, null);
    }

    public Car(String model, Engine engine) {
        super(TYPE, model, engine);
    }

    @Override
    public Vehicle create(String vehicleModel, Engine engine) {
        return new Car(vehicleModel, engine);
    }

    @Override
    public void deliver() {
        DeliveryDecorator delivery = new DeliveryDecorator(new WaterDelivery());
        delivery.load();
        go();
        delivery.unload();
    }

    @Override
    public void go() {
        System.out.println("Car go");

    }
}
