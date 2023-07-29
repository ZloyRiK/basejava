package storage;

import exeption.ExistStorageException;
import exeption.NotExistStorageException;
import exeption.StorageException;
import model.Resume;

import java.util.ArrayList;

public abstract class AbstractStorage implements Storage{

    protected static final int STORAGE_LIMIT = 10000;
    protected int size;

    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected final ArrayList<Resume> storageList = new ArrayList<>();

    public int size() {
        return size;
    }

    @Override
    public final void save(Resume r) {
        int index = findIndex(r.getUuid());
//        System.out.println(index);  // for check index
        if (size >= STORAGE_LIMIT) {
            throw new StorageException(r.getUuid(), "Storage overflow");
        } else if (index >= 0) {
            throw new ExistStorageException(r.getUuid());
//            System.out.printf("Резюме с номером %s уже в базе\n", r.getUuid());
        } else {
            insertResume(r, index);
            size++;
        }
    }
//
    @Override
    public final Resume get(String uuid) {
        int index = findIndex(uuid);
//        System.out.printf("\nIndex: %d\nTrying to search: %s\n\n", index, uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            return getResume(index);
        }
    }
//
    @Override
    public final void update(Resume r) {
        int index = findIndex(r.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(r.getUuid());
        }
        System.out.printf("Резюме %s обновлено\n", r.getUuid());
        updateResume(r, index);
    }
//
    @Override
    public final void delete(String uuid) {
        int index = findIndex(uuid);
        if (index > -1) {
            deleteResume(index);
            size--;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }


    protected abstract void insertResume(Resume r, int index);

    protected abstract void updateResume(Resume r, int index);

    protected abstract void deleteResume(int index);

    protected abstract Resume getResume(int index);

//    protected abstract List<Resume> getAllResumes();

    protected abstract int findIndex(String uuid);
}
