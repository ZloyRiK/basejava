package storage;

import exeption.ExistStorageException;
import exeption.NotExistStorageException;
import exeption.StorageException;
import model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


abstract class AbstractStorageTest {

    protected Storage storage;
    protected static final String UUID_1 = "uuid1";
    protected static final String UUID_2 = "uuid2";
    protected static final String UUID_3 = "uuid3";
    protected static final String UUID_4 = "uuid4";

    protected static final String NAME_1 = "name1";
    protected static final String NAME_2 = "name2";
    protected static final String NAME_3 = "name3";
    protected static final String NAME_4 = "name4";

    protected static final Resume R1 = new Resume(UUID_1, NAME_1);
    protected static final Resume R2 = new Resume(UUID_2, NAME_2);
    protected static final Resume R3 = new Resume(UUID_3, NAME_3);
    protected static final Resume R4 = new Resume(UUID_4, NAME_4);

    protected AbstractStorageTest (Storage storage){
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
    public void testSize() {
        assertSize(3);
    }


    @Test
    public void testSave() {
        storage.save(R4);
        assertSize(4);
        assertGet(R4);
    }

    @Test
    public void testSaveExist() {
        Assertions.assertThrows(ExistStorageException.class, () -> storage.save(R1));
        assertSize(3);

    }

    @Test
    public void testUpdate() {
        storage.update(R1);
        Assertions.assertEquals(R1, storage.get(UUID_1));
    }

    @Test
    public void testUpdateStorageException() {
        Assertions.assertThrows(StorageException.class, () -> storage.update(R4));
    }

    @Test
    public void testUpdateNotExistStorageException() {
        Resume r = new Resume("New Name");
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.update(r));

    }

    @Test
    public void testClear() {
//        List<Resume> expected = new ArrayList<>();
        storage.clear();
        assertSize(0);
//        Assertions.assertArrayEquals(expected, storage.getAllSorted());
    }

    @Test
    public void testDelete() {
        storage.delete(UUID_1);
        assertSize(2);
        Assertions.assertThrows(NotExistStorageException.class, ()->storage.get(UUID_1));
    }

    @Test
    public void testDeleteNotExist() {
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.delete(UUID_4));
    }

    @Test
    public void testGet() {
        assertGet(R1);
        assertGet(R2);
        assertGet(R3);
    }


    @Test
    public void testGetNotExist() {
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.get(UUID_4));
    }


    @Test
    public void testGetAllSorted(){
        List<Resume> expected = new ArrayList<>();
        expected.add(R1);
        expected.add(R2);
        expected.add(R3);
        Assertions.assertIterableEquals(expected, storage.getAllSorted());
    }

    private void assertSize(int size) {
        Assertions.assertEquals(size, storage.size());
    }
    private void assertGet(Resume r) {
        Assertions.assertEquals(r, storage.get(r.getUuid()));
    }
}