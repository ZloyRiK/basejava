package storage;

import exeption.StorageException;
import model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class AbstractArrayStorageTest extends AbstractStorageTest{


    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test
    public void testSaveStorageOverflow() {
        storage.clear();
        try{
            for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
//                storage.save(new Resume(String.valueOf(i)));
                storage.save(new Resume("Name"+i));
            }
        } catch (StorageException e){
            Assertions.fail(e);
//            System.out.println(e);
        }
//        storage.save(new Resume());
        Assertions.assertThrows(StorageException.class, ()-> storage.save(new Resume("OverFlow")));
    }

}
