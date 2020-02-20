package allbros.google.hashcode.file.contract;

public interface StringDeserializer {
    <TSerialize> TSerialize deserialize(String stringToDeserialize);
}
