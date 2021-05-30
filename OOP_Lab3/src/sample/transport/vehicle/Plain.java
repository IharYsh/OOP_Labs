package sample.transport.vehicle;

import sample.transport.delivery.AirDelivery;
import sample.transport.delivery.DeliveryDecorator;
import sample.transport.engine.Engine;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Plain")
public class Plain extends AirVehicle {
    private final static String TYPE = "Plain";

    public Plain(){
        super(TYPE, null, null);
    }

    public Plain(String model, Engine engine) {
        super(TYPE, model, engine);
    }

    @Override
    public Vehicle create(String vehicleModel, Engine engine) {
        return new Plain(vehicleModel, engine);
    }

    @Override
    public void deliver() {
        DeliveryDecorator delivery = new DeliveryDecorator(new AirDelivery());
        delivery.load();
        fly();
        delivery.unload();
    }

    @Override
    public void fly() {
        System.out.println("fly plain");
    }
}
