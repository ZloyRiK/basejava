package storage;

import model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage<String> {
    private final Map<String, Resume> storageMap = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doSave(Resume r, String uuid) {
        storageMap.put(uuid, r);
    }

    @Override
    protected void doDelete(String uuid) {
        storageMap.remove(uuid);
    }

    @Override
    protected void doUpdate(Resume r, String uuid) {
        storageMap.put(uuid, r);
    }

    @Override
    protected Resume doGet(String uuid ) {
        return storageMap.get(uuid);
    }

    @Override
    protected boolean isExist(String uuid) {
        return storageMap.containsKey(uuid);
    }

    @Override
    public void clear() {
        storageMap.clear();
    }

    @Override
    public List<Resume> doGetAll() {
        return new ArrayList<>(storageMap.values());
    }

    @Override
    public int size() {
        return storageMap.size();
    }
}
