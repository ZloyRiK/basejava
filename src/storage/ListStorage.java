package storage;

import model.Resume;

public class ListStorage extends AbstractStorage {

    @Override
    public void clear() {
        storageList.clear();
        size = 0;
    }

    @Override
    public Resume[] getAll() {
        return storageList.toArray(new Resume[0]);
    }

    @Override
    protected void insertResume(Resume r, int index) {
        storageList.add(r);
    }

    @Override
    protected void updateResume(Resume r, int index) {
        storageList.set(index, r);
    }

    @Override
    protected void deleteResume(int index) {
        storageList.remove(index);
    }

    @Override
    protected Resume getResume(int index) {
        return storageList.get(index);
    }

    @Override
    protected int findIndex(String uuid) {
        Resume r = new Resume();
        for (int i = 0; i < storageList.size(); i++) {
            if (storageList.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
