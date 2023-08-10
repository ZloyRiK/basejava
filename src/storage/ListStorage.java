package storage;

import model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {
    protected final ArrayList<Resume> storageList = new ArrayList<>();

    @Override
    public void clear() {
        storageList.clear();
        storageList.trimToSize();
    }

    @Override
    public Resume[] getAll() {
        return storageList.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storageList.size();
    }

    @Override
    protected Object getSearchKey(String uuid) {
        for (int i = 0; i < storageList.size(); i++) {
            if (storageList.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        storageList.add(r);
    }

    @Override
    protected void doDelete(Object searchKey) {
        storageList.remove((int)searchKey);
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        storageList.set((int) searchKey, r);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storageList.get((int) searchKey);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return (int)searchKey>=0;
    }
}
