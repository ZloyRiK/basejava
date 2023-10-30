package storage;

import storage.strategy.JsonStrategy;

class JsonPathStorageTest extends AbstractStorageTest {

    public JsonPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new JsonStrategy()));
    }
}