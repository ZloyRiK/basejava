package storage;

import exeption.ExistStorageExeption;
import exeption.NotExistStorageExeption;
import exeption.StorageExeption;
import model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AbstractArrayStorageTest {

    protected final int STORAGE_LIMIT = 10000;
    protected Storage storage;
    protected static final String UUID_1 = "uuid1";
    protected static final String UUID_2 = "uuid2";
    protected static final String UUID_3 = "uuid3";


    @BeforeEach
    public void setUP() {
        storage = new SortedArrayStorage();
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    void testSize() {
        Assertions.assertEquals(3, storage.size());
    }

    @Test
    void testSave() {
        storage.save(new Resume("uuid4"));
        Assertions.assertEquals(4, storage.size());

    }

    @Test
    void testSaveExist() {
        Assertions.assertThrows(ExistStorageExeption.class, () -> storage.save(new Resume("uuid1")));

    }

    @Test
    void testSaveStorageOverFlow() {
        Assertions.assertThrows(StorageExeption.class, () -> {
            for (int i = 0; i < 10000; i++) {
                storage.save(new Resume(String.valueOf(i)));
            }
        });
    }

    @Test
    void testUpdate() {
        Resume r = new Resume("uuid1");
        storage.update(r);
        Assertions.assertEquals(r, storage.get("uuid1"));
    }

    @Test
    void testUpdateStorageExeption(){
        Resume r4 = new Resume("uuid4");
        Assertions.assertThrows(StorageExeption.class, () -> storage.update(r4));
    }

    @Test
    void testUpdateNotExistStorageExeption(){
        Resume r3 = new Resume();
        Assertions.assertThrows(NotExistStorageExeption.class, () -> storage.update(r3));

    }

    @Test
    void testClear() {

    }

    @Test
    void testDelete() {
    }

    @Test
    void testGet() {
    }

    @Test
    void testGetAll() {
    }

//    protected abstract Storage createStorage();

//    public abstract int findIndex(String uuid);
}