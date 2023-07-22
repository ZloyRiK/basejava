package storage;

import exeption.ExistStorageException;
import exeption.NotExistStorageException;
import exeption.StorageException;
import model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class AbstractArrayStorageTest {

    protected Storage storage;
    protected static final String UUID_1 = "uuid1";
    protected static final String UUID_2 = "uuid2";
    protected static final String UUID_3 = "uuid3";
    protected static final String UUID_4 = "uuid4";

    protected static final Resume R1 = new Resume(UUID_1);
    protected static final Resume R2 = new Resume(UUID_2);
    protected static final Resume R3 = new Resume(UUID_3);
    protected static final Resume R4 = new Resume(UUID_4);

    public AbstractArrayStorageTest (Storage storage){
        this.storage = storage;
    }


    @BeforeEach
    public void setUp() {
        storage.clear();
        storage.save(R1);
        storage.save(R2);
        storage.save(R3);
    }

    @Test
    void testSize() {
        assertSize(3);
    }


    @Test
    void testSave() {
        storage.save(R4);
        assertSize(4);
        assertGet(R4);
    }

    @Test
    void testSaveExist() {
        Assertions.assertThrows(ExistStorageException.class, () -> storage.save(R1));
        assertSize(3);

    }

    @Test
    void testSaveStorageOverflow() {
        storage.clear();
        try{
            for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
//                storage.save(new Resume(String.valueOf(i)));
                storage.save(new Resume());
            }
        } catch (StorageException e){
            Assertions.fail(e);
//            System.out.println(e);
        }
        storage.save(new Resume());
    }

    @Test
    void testUpdate() {
        storage.update(R1);
        Assertions.assertEquals(R1, storage.get(UUID_1));
    }

    @Test
    void testUpdateStorageException() {
        Assertions.assertThrows(StorageException.class, () -> storage.update(R4));
    }

    @Test
    void testUpdateNotExistStorageException() {
        Resume r = new Resume();
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.update(r));

    }

    @Test
    void testClear() {
        Resume[] expected = new Resume[0];
        storage.clear();
        assertSize(0);
        Assertions.assertArrayEquals(expected, storage.getAll());
    }

    @Test
    void testDelete() {
        storage.delete(UUID_1);
        assertSize(2);
        Assertions.assertThrows(NotExistStorageException.class, ()->storage.get(UUID_1));
    }

    @Test
    void testDeleteNotExist() {
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.delete(UUID_4));
    }

    @Test
    void testGet() {
        assertGet(R1);
        assertGet(R2);
        assertGet(R3);
    }


    @Test
    void testGetNotExist() {
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.get(UUID_4));
    }

    @Test
    void testGetAll() {
        Resume[] expected = new Resume[]{R1,R2,R3};
        Assertions.assertArrayEquals(expected, storage.getAll());
    }
    private void assertSize(int size) {
        Assertions.assertEquals(size, storage.size());
    }
    private void assertGet(Resume r) {
        Assertions.assertEquals(r, storage.get(r.getUuid()));
    }
}
