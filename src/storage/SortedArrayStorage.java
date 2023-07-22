package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class SortedArrayStorage extends AbstractArrayStorage {


    @Override
    public void insertResume(Resume r, int index) {
        int newIndex = -index - 1;
        System.arraycopy(storage, newIndex, storage, newIndex+1, size-newIndex);
        storage[newIndex] = r;
    }

    @Override
    protected void deleteResume(int index) {
        int newIndex = index+1;
        System.arraycopy(storage, newIndex, storage, index, size-newIndex);
    }

    @Override
    protected int findIndex(String uuid) {
//        if (uuid==null){
////            System.out.println("Object have null in uuid\n");
//            return -STORAGE_LIMIT-1;
//        } else {
            Resume searchKey = new Resume(uuid);
            return Arrays.binarySearch(storage, 0, size, searchKey);
//        }
    }
}

