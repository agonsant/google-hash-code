package allbros.google.hashcode.model.process;

import allbros.google.hashcode.file.contract.StringDeserializer;
import allbros.google.hashcode.model.Pizzeria;


public class PizzeriaDeserializer implements StringDeserializer<Pizzeria> {
    @Override
    public Pizzeria deserialize(String stringToDeserialize) {
        String[] lines = stringToDeserialize.split(System.getProperty("line.separator"));
        Pizzeria inputDataLoaded = instanceInput(lines[0]);
        loadPizzaSlice(lines[1],inputDataLoaded);
        return inputDataLoaded;
    }

    private Pizzeria instanceInput(String problemDefinition) {
        String[] problemDefinitionSplitData = problemDefinition.split(" ");
        int maxSlices = Integer.parseInt(problemDefinitionSplitData[0]);
        int pizzaTypes = Integer.parseInt(problemDefinitionSplitData[1]);
        return new Pizzeria(maxSlices, pizzaTypes);
    }

    private void loadPizzaSlice(String pizzaSliceData, Pizzeria pizzaProblemDefinition)
    {
        String[] pizzaSliceSplitData  = pizzaSliceData.split(" ");
        for (String pizzaSlice : pizzaSliceSplitData) {
            pizzaProblemDefinition.addPizza(0,Integer.parseInt(pizzaSlice));
        }
    }
}
