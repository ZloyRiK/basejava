package storage;

import model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage {
    private final Map<String, Resume> storageMap = new HashMap<String, Resume>();

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
        storageMap.put(r.getUuid(), r);
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

//    @Override
//    public Resume[] getAll() {
//        return storageMap.values().toArray(new Resume[0]);
//    }

    @Override
    public List<Resume> doGetAll() {
        return new ArrayList<>(storageMap.values());
    }

    @Override
    public int size() {
        return storageMap.size();
    }
}
