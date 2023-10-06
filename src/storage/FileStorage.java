package storage;

import exeption.StorageException;
import model.Resume;
import storage.strategy.StorageStrategy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileStorage extends AbstractStorage<File> {
    private final File directory;
    protected StorageStrategy strategy;

    public FileStorage(File directory, StorageStrategy strategy) {
        Objects.requireNonNull(directory, "Directory can't be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not a directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not a readable/writable");
        }
        this.directory = directory;
        this.strategy= strategy;
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected void doSave(Resume r, File file) {
        try {
            file.createNewFile();
            strategy.doWrite(r, new BufferedOutputStream(new FileOutputStream(file)));
        } catch (IOException e) {
            throw new StorageException("Can't make new file" + file.getAbsolutePath(), file.getName(), e);
        }
        doUpdate(r, file);
    }


    @Override
    protected void doDelete(File file) {
        try {
            file.delete();
        } catch (StorageException e) {
            throw new StorageException("Error to file delete", file.getName());
        }
    }

    @Override
    protected void doUpdate(Resume r, File file) {
        try {
            strategy.doWrite(r, new BufferedOutputStream(new FileOutputStream(file)));
        } catch (IOException e) {
            throw new StorageException("Update file error", file.getName(), e);
        }
    }

    @Override
    protected Resume doGet(File file) {
        try {
            return strategy.doRead(new FileInputStream(file));
        } catch (IOException e) {
            throw new StorageException("Can't get file", file.getName(), e);
        }
    }


    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected List<Resume> doGetAll() {
        List<Resume> list = new ArrayList<>();
        for (File file : notNullDirectoryArray()) {
            list.add(doGet(file));
        }
        return list;
    }

    @Override
    public void clear() {
        for (File file : notNullDirectoryArray()) {
            doDelete(file);
        }
    }


    @Override
    public int size() {
        return notNullDirectoryArray().length;
    }

    private File[] notNullDirectoryArray() {
        File[] dirArray = directory.listFiles();
        if (dirArray == null) {
            throw new StorageException("Directory returns null", null);
        }
        return dirArray;
    }
}
