package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage <Resume>{
    private final Map<String, Resume> storageNameMap = new HashMap<>();


    @Override
    protected Resume getSearchKey(String uuid) {
        return storageNameMap.get(uuid);
    }

    @Override
    protected void doSave(Resume r, Resume resume) {
        storageNameMap.put(r.getUuid(), r);
    }

    @Override
    protected void doDelete(Resume resume) {
        storageNameMap.remove(resume.getUuid());
    }

    @Override
    protected void doUpdate(Resume r, Resume resume) {
        storageNameMap.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Resume resume) {
        return resume;
    }

    @Override
    protected boolean isExist(Resume resume) {
        return resume != null;
    }

    @Override
    public void clear() {
        storageNameMap.clear();
    }


    @Override
    public List<Resume> doGetAll() {
        return new ArrayList<>(storageNameMap.values());
    }

    @Override
    public int size() {
        return storageNameMap.size();
    }
}
