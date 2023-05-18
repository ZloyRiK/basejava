/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int endPoint = 0; // first empty index in array

    void clear() {
        for (int i = 0; i < endPoint; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        storage[endPoint] = r;
        endPoint++;
    }

    Resume get(String uuid) {
        int temp = findIndex(uuid);
        if (temp == -1) {
            Resume r = new Resume();
            r.uuid = "Not this time";
            return r;
        } else return storage[temp];
    }

    void delete(String uuid) {
        int delIndex = findIndex(uuid);
        storage[delIndex] = null;

        while (delIndex != endPoint) {
            storage[delIndex] = storage[delIndex + 1];
            delIndex++;
        }
        endPoint--;
    }

    private int findIndex(String uuid) {
        int index = 0;
        for (int i = 0; i < endPoint; i++) {
            if (storage[i].uuid.equals(uuid)) {
                index = i;
                break;
            } else index = -1;
        }
        return index;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] result = new Resume[endPoint];
        for (int i = 0; i < endPoint; i++) {
            result[i] = storage[i];
        }
        return result;
    }

    int size() {
        return endPoint;
    }
}
