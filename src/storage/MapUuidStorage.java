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
    protected void doSave(Resume r, Object uuid) {
        storageMap.put((String) uuid, r);
    }

    @Override
    protected void doDelete(Object uuid) {
        storageMap.remove((String) uuid);
    }

    @Override
    protected void doUpdate(Resume r, Object uuid) {
        storageMap.put((String) uuid, r);
    }

    @Override
    protected Resume doGet(Object uuid ) {
        return storageMap.get((String) uuid);
    }

    @Override
    protected boolean isExist(Object uuid) {
        return storageMap.containsKey((String) uuid);
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
