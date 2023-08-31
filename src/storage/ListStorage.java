package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage <Integer>{
    protected final ArrayList<Resume> storageList = new ArrayList<>();

    @Override
    public void clear() {
        storageList.clear();
        storageList.trimToSize();
    }

//    @Override
//    public Resume[] getAll() {
//        return storageList.toArray(new Resume[0]);
//    }

    @Override
    public List<Resume> doGetAll() {
        return storageList;
    }

    @Override
    public int size() {
        return storageList.size();
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < storageList.size(); i++) {
            if (storageList.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void doSave(Resume r, Integer searchKey) {
        storageList.add(r);
    }

    @Override
    protected void doDelete(Integer searchKey) {
        storageList.remove(searchKey.intValue());
    }

    @Override
    protected void doUpdate(Resume r, Integer searchKey) {
        storageList.set(searchKey, r);
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        return storageList.get(searchKey);
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey>=0;
    }
}
