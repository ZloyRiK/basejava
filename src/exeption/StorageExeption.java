package exeption;

public class StorageExeption extends RuntimeException{
    private final String uuid;

    public StorageExeption(String uuid, String message) {
        super(message);
        this.uuid = uuid;
    }
}
