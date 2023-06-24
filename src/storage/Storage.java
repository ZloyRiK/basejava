package storage;

import model.Resume;

/**
 * Array based storage for Resumes
 */

public interface Storage {

    public void clear();

    public void save(Resume r);

    public Resume get(String uuid);

    public void update(Resume r);

    public void delete(String uuid);

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll();

    public int size();

}
