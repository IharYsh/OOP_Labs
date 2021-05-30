package sample.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.transport.engine.Engine;
import sample.transport.engine.HeavyEngine;
import sample.transport.engine.LightEngine;
import sample.transport.vehicle.*;

import java.io.*;

public class Controller {
    @FXML
    ListView<Vehicle> listView;
    ObservableList<Vehicle> listItems;

    @FXML
    ComboBox<Vehicle> cb_transport;
    ObservableList<Vehicle> transport;

    @FXML
    Button btn_add;

    @FXML
    RadioButton radio_engine1;
    Engine engine1 = LightEngine.getEngine();

    @FXML
    RadioButton radio_engine2;
    Engine engine2 = HeavyEngine.getEngine();

    @FXML
    TextField tf_model;

    @FXML
    public void initialize() throws IOException, ClassNotFoundException {
        ToggleGroup group = new ToggleGroup();
        radio_engine1.setToggleGroup(group);
        radio_engine2.setToggleGroup(group);

        transport = FXCollections.observableArrayList(
                new Car(), new Bus(), new Truck(), new Train(), new Boat(),
                new Ship(), new Helicopter(), new Plain());
        cb_transport.setItems(transport);

        btn_add.setOnMousePressed(event -> {
            String model = tf_model.getText();
            if (cb_transport.getValue() != null && model != null) {
                Engine engine = engine1;
                if (radio_engine2.isSelected())
                    engine = engine2;
                Vehicle newTransport = cb_transport.getValue().create(model, engine);
                listItems.add(newTransport);
            }
        });

        listItems = FXCollections.observableArrayList();
        load();
        listView.setItems(listItems);
        listView.setCellFactory(param -> new XCell());
    }

    public void shutdown() {
        try {
            File text = new File("text.txt");
            text.createNewFile();
            OutputStream outputStream = new FileOutputStream(text);
            DataOutputStream output = new DataOutputStream(outputStream);
            File binary = new File("binary.txt");
            binary.createNewFile();
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(binary));
            out.writeInt(listItems.size());
            out.flush();
            int num = 0;
            for (Vehicle vehicle : listItems) {
                out.writeObject(vehicle);
                out.flush();
                vehicle.saveXML(num++);
                vehicle.saveJSON(num);
                vehicle.saveText(output);
            }
        } catch (Exception e) {
        }
    }

    private void load() throws IOException, ClassNotFoundException {
        File binary = new File("binary.txt");
        if (!binary.exists()) return;

        InputStream inputStream = new FileInputStream("text.txt");
        DataInputStream input = new DataInputStream(inputStream);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(binary));
        int len = in.readInt();

        for (int i = 0; i < len; i++) {
            listItems.add((Vehicle) in.readObject());
//            listItems.add(Vehicle.loadXML(i));
//            listItems.add(Vehicle.loadText(input));
        }
    }
}
