package storage;

import exeption.ExistStorageException;
import exeption.NotExistStorageException;
import model.Resume;

import java.util.ArrayList;

public abstract class AbstractStorage implements Storage {

    protected final ArrayList<Resume> storageList = new ArrayList<>();


    @Override
    public final void save(Resume r) {
        Object searchKey = getNotExistSearchKey(r.getUuid());
        doSave(r, searchKey);
    }

    @Override
    public final Resume get(String uuid) {
        Object searchKey = getExistSearchKey(uuid);
        return doGet(searchKey);
    }

    @Override
    public final void update(Resume r) {
        Object searchKey = getExistSearchKey(r.getUuid());
        System.out.printf("Резюме %s обновлено\n", r.getUuid());
        doUpdate(r, searchKey);
    }


    @Override
    public final void delete(String uuid) {
        Object searchKey = getExistSearchKey(uuid);
        doDelete(searchKey);
    }

    private Object getExistSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);

        } else return searchKey;
    }

    private Object getNotExistSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    protected abstract int getSearchKey(String uuid); // to AbstractArrayStorage

    protected abstract void doSave(Resume r, Object searchKey);

    protected abstract void doDelete(Object searchKey);

    protected abstract void doUpdate(Resume r, Object searchKey);

    protected abstract Resume doGet(Object searchKey);

    protected abstract boolean isExist(Object searchKey);
}
