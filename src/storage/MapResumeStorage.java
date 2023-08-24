package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage {
    private final Map<String, Resume> storageNameMap = new HashMap<String, Resume>();


    @Override
    protected Object getSearchKey(String uuid) {
        return storageNameMap.get(uuid);
    }

    @Override
    protected void doSave(Resume r, Object resume) {
        storageNameMap.put((String) resume, r);
    }

    @Override
    protected void doDelete(Object resume) {
        storageNameMap.remove((String) resume);
    }

    @Override
    protected void doUpdate(Resume r, Object resume) {
        storageNameMap.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Object resume) {
        return storageNameMap.get(resume);
    }

    @Override
    protected boolean isExist(Object resume) {
        return resume != null;
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
    public List<Resume> doGetAll() {
        return new ArrayList<>(storageNameMap.values());
    }

    @Override
    public int size() {
        return storageNameMap.size();
    }
}
