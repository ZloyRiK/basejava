package storage;

import model.Resume;

public class ListStorage extends AbstractStorage{

    @Override
    public void clear() {
        storageList.clear();
    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
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
        return null;
    }

    @Override
    protected int findIndex(String uuid) {
        Resume r = new Resume();
        return storageList.indexOf(r);
    }


}
