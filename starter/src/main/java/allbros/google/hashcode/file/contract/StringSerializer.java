package allbros.google.hashcode.file.contract;

public interface StringSerializer {


    <TDeserialize> String serialize(TDeserialize objectToSerialize);
}

