package allbros.google.hashcode.file.contract;

public interface StringDeserializer<TDeserialize> {
    TDeserialize deserialize(String stringToDeserialize);
}
