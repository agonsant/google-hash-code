package allbros.google.hashcode.model.process;

import allbros.google.hashcode.file.contract.StringSerializer;
import allbros.google.hashcode.model.Delivery;

public class DeliverySerializer implements StringSerializer<Delivery> {

    @Override
    public String serialize(Delivery objectToSerialize) {
        StringBuilder deliveryString = new StringBuilder();
        deliveryString.append(objectToSerialize.getOrderedPizzaTypes());
        deliveryString.append(System.getProperty("line.separator"));
        for (boolean isPizzaOrdered : objectToSerialize.getPizzaOrdered()) {
            deliveryString.append(isPizzaOrdered);
            deliveryString.append(" ");
        }
        return deliveryString.toString();
    }
}
