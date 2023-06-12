import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    private int baseSize = 10000;
    Resume[] storage = new Resume[baseSize];
    private int totalResume; // first empty index in array and total Resume value

    void clear() {
        for (int i = 0; i < totalResume; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        if (baseSize <= 0) {
            System.out.print("Память для хранения резюме не выделена\n");
        } else if (totalResume == 0) {
            System.out.print("База резюме пуста. Сохраняем первое резюме\n");
            storage[totalResume] = r;
            totalResume++;
        } else if (totalResume == baseSize) {
            System.out.print("База резюме переполнена. Данные не сохранены\n");
        } else {
            storage[totalResume] = r;
            totalResume++;
        }
    }

    Resume get(String uuid) {
        int index = findIndex(uuid);
        if (index < 0) {
            System.out.printf("Объект %s не найден\n", uuid);
            return null;
        } else return storage[index];
    }

    void delete(String uuid) {
        int index = findIndex(uuid);
        if (index > -1) {
            storage[index] = storage[totalResume - 1];
            storage[totalResume - 1] = null;
            totalResume--;
        } else System.out.printf("Объект %s не найден\n", uuid);
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allResume = Arrays.copyOf(storage, totalResume);
        if (totalResume == 0) {
            System.out.print("В базе еще нет резюме\n");
        } else if (allResume[0] == null) {
            System.out.print("Элементы массива не содержат данных\n");
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

    void update(Resume r) {

    }

}
