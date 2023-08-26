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
        storageNameMap.put(r.getUuid(), r);
    }

    @Override
    protected void doDelete(Object resume) {
        storageNameMap.remove(((Resume) resume).getUuid());
    }

    @Override
    protected void doUpdate(Resume r, Object resume) {
        storageNameMap.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Object resume) {
        return (Resume) resume;
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
