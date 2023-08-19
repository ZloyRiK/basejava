package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapNameStorage extends AbstractStorage {
    private final Map<String, Resume> storageNameMap = new HashMap<String, Resume>();


    @Override
    protected Object getSearchKey(String name) {
        return name;
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        storageNameMap.put(r.getUuid(), r);
    }

    @Override
    protected void doDelete(Object searchKey) {
        storageNameMap.remove(searchKey);
    }

    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        storageNameMap.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storageNameMap.get(searchKey);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return storageNameMap.containsKey(searchKey);
    }

    @Override
    public void clear() {
        storageNameMap.clear();
    }

//    @Override
//    public Resume[] getAll() {
//        return storageMap.values().toArray(new Resume[0]);
//    }

    @Override
    public List<Resume> getAllSorted() {
        return new ArrayList<>(storageNameMap.values());
    }

    @Override
    public int size() {
        return storageNameMap.size();
    }
}
