package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class SortedArrayStorage extends AbstractArrayStorage {


    @Override
    public void insertResume(Resume r, int index) {
        if (index < 0) {
            index = -index - 1;
        }
        System.arraycopy(storage, index, storage, index + 1, size + 1);
        storage[index] = r;
    }

    @Override
    protected void deleteResume(int index) {
        int newIndex = index+1;
        System.arraycopy(storage, index, storage, newIndex, size);
    }

    @Override
    protected int findIndex(String uuid) {
        if (uuid==null){
//            System.out.println("Object have null in uuid\n");
            return -STORAGE_LIMIT-1;
        } else {
            Resume searchKey = new Resume();
            searchKey.setUuid(uuid);
            return Arrays.binarySearch(storage, 0, size, searchKey);
        }
    }
}

