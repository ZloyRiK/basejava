package exeption;

public class ExistStorageExeption extends StorageExeption{
    public ExistStorageExeption(String uuid) {
        super(uuid, "Резюме "+uuid+" уже в базе");
    }
}
