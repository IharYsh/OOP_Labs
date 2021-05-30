package sample.transport;

import sample.transport.vehicle.Car;
import sample.transport.vehicle.Plain;

public class CarAdapter extends Plain {
    Car car;

    public CarAdapter(Car car) {
        this.car = car;
    }

    @Override
    public void fly() {
        System.out.println("car fly");
    }
}
