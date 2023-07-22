package exeption;

public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
        super(uuid, "Резюме "+uuid+" уже в базе");
    }
}
