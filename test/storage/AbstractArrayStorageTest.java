package storage;

import exeption.ExistStorageExeption;
import exeption.NotExistStorageExeption;
import exeption.StorageExeption;
import model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class AbstractArrayStorageTest {

    protected final int STORAGE_LIMIT = 10000;
    protected Storage storage;
    protected static final String UUID_1 = "uuid1";
    protected static final String UUID_2 = "uuid2";
    protected static final String UUID_3 = "uuid3";

    protected static final Resume R1 = new Resume(UUID_1);
    protected static final Resume R2 = new Resume(UUID_2);
    protected static final Resume R3 = new Resume(UUID_3);

    public AbstractArrayStorageTest (Storage storage){
        this.storage = storage;
    }


    @BeforeEach
    public void setUP() {
        storage.clear();
        storage.save(R1);
        storage.save(R2);
        storage.save(R3);
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
        storage.clear();
        Assertions.assertThrows(StorageExeption.class, () -> {
            for (int i = 0; i <= STORAGE_LIMIT; i++) {
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
    void testUpdateStorageExeption() {
        Resume r4 = new Resume("uuid4");
        Assertions.assertThrows(StorageExeption.class, () -> storage.update(r4));
    }

    @Test
    void testUpdateNotExistStorageExeption() {
        Resume r4 = new Resume();
        Assertions.assertThrows(NotExistStorageExeption.class, () -> storage.update(r4));

    }

    @Test
    void testClear() {
        storage.clear();
        Assertions.assertEquals(0, storage.size());
    }

    @Test
    void testDelete() {
        storage.delete(UUID_1);
        Assertions.assertEquals(2, storage.size());
    }

    @Test
    void testDeleteNotExist() {
        Assertions.assertThrows(NotExistStorageExeption.class, () -> storage.delete("uuid4"));
    }

    @Test
    void testGet() {
        Assertions.assertEquals(R1, storage.get(UUID_1));
    }

    @Test
    void testGetNotExist() {
        Assertions.assertThrows(NotExistStorageExeption.class, () -> storage.get("uuid4"));
    }

    @Test
    void testGetAll() {
        Resume[] expected = storage.getAll();
        Assertions.assertEquals(3, expected.length);
        Assertions.assertEquals(R2, expected[1]);
    }
}