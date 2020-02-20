package allbros.google.hashcode.file.contract;

public interface StringSerializer<TSerialize>  {


    String serialize(TSerialize objectToSerialize);
}

