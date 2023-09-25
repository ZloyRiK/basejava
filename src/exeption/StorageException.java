package exeption;

import java.io.IOException;

public class StorageException extends RuntimeException{
    private final String uuid;

    public StorageException(String uuid, String message) {
        super(message);
        this.uuid = uuid;
    }

    public StorageException(String message, String uuid, IOException e) {
        super(message, e);
        this.uuid = uuid;
    }
}
