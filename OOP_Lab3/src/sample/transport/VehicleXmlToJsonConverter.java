package sample.transport;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import sample.transport.vehicle.Vehicle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class VehicleXmlToJsonConverter {
    public String convert(String xml) throws JAXBException, JsonProcessingException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Vehicle.class);
        Unmarshaller un = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(xml);
        Vehicle current = (Vehicle) un.unmarshal(reader);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(current);
        jsonString = jsonString.substring(0, jsonString.indexOf("\"xml\"") - 1) + "}";
        return jsonString;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
