package storage;

import model.Resume;

import java.util.List;

/**
 * Array based storage for Resumes
 */

public interface Storage {

    void clear();

    void save(Resume r);

    Resume get(String uuid);

    void update(Resume r);

    void delete(String uuid);

    List<Resume> getAllSorted();

    int size();

}
