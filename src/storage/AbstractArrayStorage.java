package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public abstract class AbstractArrayStorage implements Storage{
    protected final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public int size() {
        return size;
    }

    public void save(Resume r) {
        int index = findIndex(r.getUuid());
        if (size == STORAGE_LIMIT) {
            System.out.print("База резюме переполнена. Данные не сохранены\n");
        } else if (index >= 0) {
            System.out.printf("Резюме с номером %s уже в базе\n", r.getUuid());
        } else {
            insertResume(r, index);
            size++;
        }
    }

    public void update(Resume r) {
        int index = findIndex(r.getUuid());
        if (index > 0) {
            System.out.printf("Резюме %s обновлено\n", r.getUuid());
            storage[index] = r;
        } else {
            System.out.printf("Объект %s не найден\n", r.getUuid());
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index > -1) {
            deleteIndex(index);
            size--;
        } else {
            System.out.printf("Объект %s не найден\n", uuid);
        }
    }


    public Resume get(String uuid) {
        int index = findIndex(uuid);
//        System.out.printf("\nIndex: %d\nTrying to search: %s\n\n", index, uuid);
        if (index < 0) {
            System.out.printf("Объект %s не найден\n", uuid);
            return null;
        } else {
            return storage[index];
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public abstract void insertResume(Resume r, int index);

    protected abstract void deleteIndex(int index);

    protected abstract int findIndex(String uuid);


}
