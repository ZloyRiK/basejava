package storage;

import model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> storageMap = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        storageMap.put(r.getUuid(), r);
    }

    @Override
    protected void doDelete(Object searchKey) {
        storageMap.remove(searchKey);
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        storageMap.replace(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storageMap.get(searchKey);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return storageMap.containsKey(searchKey);
    }

    @Override
    public void clear() {
        storageMap.clear();
    }

    @Override
    public Resume[] getAll() {
        Resume[] temp = new Resume[storageMap.size()];
        int index = 0;
        for (Resume r:
             storageMap.values()) {
            temp[index]= r;
            index++;
        }
        return temp;
    }

    @Override
    public int size() {
        return storageMap.size();
    }
}
