package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class SortedArrayStorage extends AbstractArrayStorage {

//    private static class ResumeComparator implements Comparator<Resume> {
//        @Override
//        public int compare(Resume o1, Resume o2) {
//            return o1.getUuid().compareTo(o2.getUuid());
//        }
//    }

//    private static final Comparator<Resume> RESUME_COMPARATOR = new Comparator<Resume>(){
//        @Override
//        public int compare(Resume o1, Resume o2) {
//            return o1.getUuid().compareTo(o2.getUuid());
//        }
//    };


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
    protected Object getSearchKey(String uuid) {
//        if (uuid==null){
////            System.out.println("Object have null in uuid\n");
//            return -STORAGE_LIMIT-1;
//        } else {
            Resume searchKey = new Resume(uuid);
            return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
//        }
    }
}

