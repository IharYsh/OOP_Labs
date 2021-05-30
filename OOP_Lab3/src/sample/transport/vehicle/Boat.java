package sample.transport.vehicle;

import sample.transport.delivery.DeliveryDecorator;
import sample.transport.delivery.WaterDelivery;
import sample.transport.engine.Engine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Boat")
public class Boat extends WaterVehicle {
    private final static String TYPE = "Boat";

    public Boat(){
        super(TYPE, null, null);
    }

    public Boat(String model, Engine engine) {
        super(TYPE, model, engine);
    }

    @Override
    public Vehicle create(String vehicleModel, Engine engine) {
        return new Boat(vehicleModel, engine);
    }

    @Override
    public void deliver() {
        DeliveryDecorator delivery = new DeliveryDecorator(new WaterDelivery());
        delivery.load();
        swim();
        delivery.unload();
    }

    @Override
    public void swim() {
        System.out.println("boat swims");
    }
}
