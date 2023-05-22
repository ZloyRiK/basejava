/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int totalResume; // first empty index in array and total Resume value

    void clear() {
        for (int i = 0; i < totalResume; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        storage[totalResume] = r;
        totalResume++;
    }

    Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index == -1) {
            return null;
        } else return storage[index];
    }

    void delete(String uuid) {
        int delIndex = findIndex(uuid);
        if (delIndex != -1) {
            storage[delIndex] = null;

            while (delIndex != totalResume) {
                storage[delIndex] = storage[delIndex + 1];
                delIndex++;
            }
            totalResume--;
        } else System.out.printf("Resume with %s is not found\n", uuid);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allResume = new Resume[totalResume];
        for (int i = 0; i < totalResume; i++) {
            allResume[i] = storage[i];
        }
        return allResume;
    }

    int size() {
        return totalResume;
    }

    private int findIndex(String uuid) {
        for (int i = 0; i < totalResume; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
