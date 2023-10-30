package storage;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

/**
 * JUnit 5 Library
 */
@Suite
@SelectClasses({
        ArrayStorageTest.class,
        SortedArrayStorageTest.class,
        ListStorageTest.class,
        MapUuidStorageTest.class,
        MapResumeStorageTest.class,
        FileStorageTest.class,
        PathStorageTest.class,
        XmlPathStorageTest.class,
        JsonPathStorageTest.class
})
public class AllStorageTest {
}
