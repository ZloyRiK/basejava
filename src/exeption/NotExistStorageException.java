package exeption;

public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        super(uuid, "Объект " + uuid + " не найден\n");
    }
}
