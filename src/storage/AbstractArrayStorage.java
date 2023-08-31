package storage;

import exeption.StorageException;
import model.Resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */

public abstract class AbstractArrayStorage extends AbstractStorage <Integer>{
    protected static final int STORAGE_LIMIT = 10000;
    protected int size;

    protected final Resume[] storage = new Resume[STORAGE_LIMIT];

    public final void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
//    public final Resume[] getAll() {
//        return Arrays.copyOf(storage, size);
//    }

    @Override
    public List<Resume> doGetAll() {
        return new ArrayList<>(Arrays.asList(storage).subList(0, size()));
    }

    @Override
    protected void doSave(Resume r, Integer searchKey) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            insertResume(r, searchKey);
            size++;
        }
    }

    @Override
    protected void doDelete(Integer searchKey) {
        deleteResume( searchKey);
        size--;
    }

    @Override
    protected void doUpdate(Resume r, Integer searchKey) {
        storage[searchKey] = r;
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        return storage[searchKey];
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey >= 0;
    }

    protected abstract void insertResume(Resume r, int index);

    protected abstract void deleteResume(int index);

}
