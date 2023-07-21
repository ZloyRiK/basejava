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
    public void setUP() {
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
        Assertions.assertThrows(ExistStorageExeption.class, () -> storage.save(R1));
        assertSize(3);

    }

    @Test
    void testSaveStorageOverFlow() {
        storage.clear();
        try{
            for (int i = 0; i <= AbstractArrayStorage.STORAGE_LIMIT+1; i++) {
                storage.save(new Resume(String.valueOf(i)));
//                storage.save(new Resume());
            }
        } catch (StorageExeption e){
//            Assertions.fail();
            System.out.println(e);
        }
    }

    @Test
    void testUpdate() {
        Resume r = R1;
        storage.update(r);
        Assertions.assertEquals(r, storage.get(UUID_1));
    }

    @Test
    void testUpdateStorageExeption() {
        Assertions.assertThrows(StorageExeption.class, () -> storage.update(R4));
    }

    @Test
    void testUpdateNotExistStorageExeption() {
        Resume r = new Resume();
        Assertions.assertThrows(NotExistStorageExeption.class, () -> storage.update(r));

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
        Assertions.assertThrows(NotExistStorageExeption.class, ()->storage.get(UUID_1));
    }

    @Test
    void testDeleteNotExist() {
        Assertions.assertThrows(NotExistStorageExeption.class, () -> storage.delete(UUID_4));
    }

    @Test
    void testGet() {
        assertGet(R1);
    }


    @Test
    void testGetNotExist() {
        Assertions.assertThrows(NotExistStorageExeption.class, () -> storage.get(UUID_4));
    }

    @Test
    void testGetAll() {
        Resume[] expected = new Resume[3];
        expected[0]=R1;
        expected[1]=R2;
        expected[2]=R3;
        Assertions.assertArrayEquals(expected, storage.getAll());
    }
    private void assertSize(int size) {
        Assertions.assertEquals(size, storage.size());
    }
    private void assertGet(Resume r) {
        Assertions.assertEquals(r, storage.get(r.getUuid()));
    }
}
