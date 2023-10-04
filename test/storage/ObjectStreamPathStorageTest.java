package storage;

import storage.strategy.ObjectStreamPathStrategy;

class ObjectStreamPathStorageTest extends AbstractStorageTest {

    public ObjectStreamPathStorageTest() {
        super(new ObjectStreamPathStorage(STORAGE_DIR.getAbsolutePath(), new ObjectStreamPathStrategy()));
    }
}