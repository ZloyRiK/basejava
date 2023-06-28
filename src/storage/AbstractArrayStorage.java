package storage;

import exeption.ExistStorageExeption;
import exeption.NotExistStorageExeption;
import exeption.StorageExeption;
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

    public final void save(Resume r) {
        int index = findIndex(r.getUuid());
        if (size == STORAGE_LIMIT) {
            throw new StorageExeption(r.getUuid(), "Storage overflow");
        } else if (index >= 0) {
            throw new ExistStorageExeption(r.getUuid());
//            System.out.printf("Резюме с номером %s уже в базе\n", r.getUuid());
        } else {
            insertResume(r, index);
            size++;
        }
    }

    public final void update(Resume r) {
        int index = findIndex(r.getUuid());
        if (index > 0) {
            System.out.printf("Резюме %s обновлено\n", r.getUuid());
            storage[index] = r;
        }
        else if (index<-STORAGE_LIMIT){
            throw new StorageExeption(r.getUuid(), "Resume not exist. Uuid is null");
        }
        throw new NotExistStorageExeption(r.getUuid());
    }

    public final void clear() {
        Arrays.fill(storage, 0, size, null);
    }

    public final void delete(String uuid) {
        int index = findIndex(uuid);
        if (index > -1) {
            deleteResume(index);
            size--;
        } else {
            throw new NotExistStorageExeption(uuid);
        }
    }


    public final Resume get(String uuid) {
        int index = findIndex(uuid);
//        System.out.printf("\nIndex: %d\nTrying to search: %s\n\n", index, uuid);
        if (index < 0) {
            throw new NotExistStorageExeption(uuid);
        } else {
            return storage[index];
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public final Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public abstract void insertResume(Resume r, int index);

    protected abstract void deleteResume(int index);

    protected abstract int findIndex(String uuid);


}
