package storage;

import static org.junit.jupiter.api.Assertions.*;

class MapStorageTest extends AbstractArrayStorageTest {
    public MapStorageTest() {
        super(new MapStorage());
    }
}