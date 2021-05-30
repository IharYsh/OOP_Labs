package sample.transport.vehicle;

import sample.transport.VehicleXmlToJsonConverter;
import sample.transport.engine.Engine;

import javax.xml.bind.*;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.*;

@XmlSeeAlso({Boat.class, Bus.class, Car.class, Helicopter.class, Plain.class, Ship.class, Train.class, Truck.class})
public abstract class Vehicle implements VehicleCommand, Serializable {
    protected String vehicleType;
    protected String vehicleModel;
    protected Engine engine;

    protected Vehicle(String vehicleType, String vehicleModel, Engine engine) {
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;
        this.engine = engine;
    }

    public void saveXML(int nom) {
        try {
            File out = new File("XML/" + nom + ".xml");
            out.createNewFile();
            PrintWriter pw = new PrintWriter(out);
            String xml = getXML();
            pw.write(xml);
            pw.close();
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    public String getXML() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Vehicle.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter sw = new StringWriter();
        marshaller.marshal(this, sw);
        return sw.toString();
    }

    public void saveJSON(int num) throws JAXBException, IOException {
        VehicleXmlToJsonConverter converter = new VehicleXmlToJsonConverter();
        String res = converter.convert(getXML());
        File in = new File("JSON/" + num + ".json");
        PrintWriter pw = new PrintWriter(in);
        pw.write(res);
        pw.close();
    }

    public static Vehicle loadXML(int num) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Vehicle.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            File in = new File("XML/" + num + ".xml");
            return (Vehicle) un.unmarshal(in);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveText(DataOutputStream output) {
        try {
            output.writeUTF(vehicleType);
            output.flush();
            output.writeUTF(vehicleModel);
            output.flush();
            output.writeInt(getSpeed());
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Vehicle loadText(DataInputStream input) {
        try {
            String type = input.readUTF();
            String model = input.readUTF();
            int speed = input.readInt();
            Engine engine = () -> speed;
            switch (type) {
                case "Boat":
                    return new Boat(model, engine);
                case "Bus":
                    return new Bus(model, engine);
                case "Car":
                    return new Car(model, engine);
                case "Helicopter":
                    return new Helicopter(model, engine);
                case "Plain":
                    return new Plain(model, engine);
                case "Ship":
                    return new Ship(model, engine);
                case "Train":
                    return new Train(model, engine);
                case "Truck":
                    return new Truck(model, engine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public abstract Vehicle create(String vehicleModel, Engine engine);

    public String getVehicleType() {
        return vehicleType;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getSpeed() {
        if (engine != null)
            return engine.getSpeed();
        return -1;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
