package storage;

import exeption.ExistStorageException;
import exeption.NotExistStorageException;
import model.Resume;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SearchKey> implements Storage {
    //    protected  final Logger log = Logger.getLogger(getClass().getName()); // for extend logging
    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());
    protected static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid).thenComparing(Resume::getFullName);

    @Override
    public final void save(Resume r) {
        SearchKey searchKey = getNotExistSearchKey(r.getUuid());
        doSave(r, searchKey);
    }

    @Override
    public final Resume get(String uuid) {
        SearchKey searchKey = getExistSearchKey(uuid);
        return doGet(searchKey);
    }

    @Override
    public final void update(Resume r) {
        LOG.info("update " + r);
        SearchKey searchKey = getExistSearchKey(r.getUuid());
        System.out.printf("Resume %s updated\n", r.getUuid());
        doUpdate(r, searchKey);
    }


    @Override
    public final void delete(String uuid) {
        LOG.info("delete " + uuid);
        SearchKey searchKey = getExistSearchKey(uuid);
        doDelete(searchKey);
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = doGetAll();
        list.sort(RESUME_COMPARATOR);
        return list;
    }


    private SearchKey getExistSearchKey(String uuid) {
        SearchKey searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            LOG.warning("Resume not exist. Must be exist");
            throw new NotExistStorageException(uuid);
        } else {
            return searchKey;
        }
    }

    private SearchKey getNotExistSearchKey(String uuid) {
        SearchKey searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            LOG.warning("Resume" + uuid + "already exist.");
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    protected abstract SearchKey getSearchKey(String uuid);

    protected abstract void doSave(Resume r, SearchKey searchKey);

    protected abstract void doDelete(SearchKey searchKey);

    protected abstract void doUpdate(Resume r, SearchKey searchKey);

    protected abstract Resume doGet(SearchKey searchKey);

    protected abstract boolean isExist(SearchKey searchKey);

    protected abstract List<Resume> doGetAll();
}
