package storage;

import model.Resume;

public class ListStorage extends AbstractStorage {

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
    protected int getSearchKey(String uuid) {
        Resume r = new Resume();
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
        if ((int)searchKey>=0) {
            return true;
        }
        return false;
    }
}
