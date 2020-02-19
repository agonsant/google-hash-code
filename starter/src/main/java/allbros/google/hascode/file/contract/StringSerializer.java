package allbros.google.hascode.file.contract;

public interface StringSerializer {


    <TDeserialize> String serialize(TDeserialize objectToSerialize);
}

