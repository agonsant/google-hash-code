package allbros.google.hascode.file.contract;

public interface StringDeserializer {
    <TSerialize> TSerialize deserialize(String stringToDeserialize);
}
