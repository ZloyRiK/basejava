package storage;

import exeption.ExistStorageException;
import exeption.NotExistStorageException;
import exeption.StorageException;
import model.*;
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

    protected static String ach1 = "Тестовый навык 1";
    protected static String q1 = "Тестовая квалификация 1";
    protected static Company c1 = new Company(new Period(10, 2013,
            "Тестовая должность",
            "Тестовое описание обязанностей"),
            "Тестовое название компании", "http://example.com/");

    protected static Company c2 = new Company("Тестовое название компании", "http://example.com/",
            new Period(10, 2013, 11, 2014,
                    "Тестовая должность 1",
                    "Тестовое описание обязанностей 1"),
            new Period(10, 2018, 9, 2019,
                    "Тестовая должность 2",
                    "Тестовое описание обязанностей 2"));

    protected static Company e1 = new Company(new Period(3, 2013, 5, 2013,
            "Тестовое название курса"),
            "Тестовое образовательное учреждение", "https://www.example.com");

    protected static String phone = "+7(999) 999-9999";
    protected static String mail = "mail@yandex.ru";
    protected static String messenger = "skype: test_echo";
    protected static String linkedin = "https://www.linkedin.com";
    protected static String github = "https://github.com";
    protected static String stackOverflow = "https://stackoverflow.com";
    protected static String homePage = "http://example.com/";

    protected static final Resume R1 = new Resume(UUID_1, NAME_1);
    protected static final Resume R2 = new Resume(UUID_2, NAME_2);
    protected static final Resume R3 = new Resume(UUID_3, NAME_3);
    protected static final Resume R4 = new Resume(UUID_4, NAME_4);

    protected static void fillTestResume(Resume R) {

            R.setContact(ContactType.PHONE, phone);
            R.setContact(ContactType.MAIL, mail);
            R.setContact(ContactType.MESSENGER, messenger);
            R.setContact(ContactType.LINKEDIN, linkedin);
            R.setContact(ContactType.GITHUB, github);
            R.setContact(ContactType.STACKOVERFLOW, stackOverflow);
            R.setContact(ContactType.HOME_PAGE, homePage);

            R.setSection(SectionType.PERSONAL, new TextSection("Тестовый раздел личных качеств"));
            R.setSection(SectionType.OBJECTIVE, new TextSection("Тестовая желаемая позиция"));
            R.setSection(SectionType.ACHIEVEMENT, new ListSection(ach1));
            R.setSection(SectionType.QUALIFICATIONS, new ListSection(q1));
            R.setSection(SectionType.EXPERIENCE, new CompanySection(c1, c2));
            R.setSection(SectionType.EDUCATION, new CompanySection(e1));
    }


    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }


    @BeforeEach
    public void setUp() {
        storage.clear();
        ResumeTestData.createTestResume(UUID_1, NAME_1);
        fillTestResume(R2);
        fillTestResume(R3);
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
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.get(UUID_1));
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
    public void testGetAllSorted() {
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