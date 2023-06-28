package exeption;

public class NotExistStorageExeption extends StorageExeption {
    public NotExistStorageExeption(String uuid) {
        super(uuid, "Объект " + uuid + " не найден\n");
    }
}
