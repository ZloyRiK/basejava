package storage;

import exeption.StorageException;
import model.Resume;
import storage.strategy.StorageStrategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public abstract class AbstractPathStorage extends AbstractStorage<Path> {
    private final Path directory;
    protected StorageStrategy strategy;

    public AbstractPathStorage(String dir, StorageStrategy strategy) {
        this.directory = Paths.get(dir);
        Objects.requireNonNull(directory, "Directory can't be null");
        if (!Files.isDirectory(directory)) {
            throw new IllegalArgumentException(dir + " is not a directory");
        }
        if (!Files.isReadable(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + " is not a readable/writable");
        }
        this.strategy = strategy;
    }

    @Override
    protected Path getSearchKey(String uuid) {
        return directory.resolve(uuid);
    }

    @Override
    protected void doSave(Resume r, Path path) {
        try {
            strategy.doWrite(r, new BufferedOutputStream(new FileOutputStream(path.toFile())));
        } catch (IOException e) {
            throw new StorageException("Can't make new path" + path, String.valueOf(path.getFileName()), e);
        }
        doUpdate(r, path);
    }


    @Override
    protected void doDelete(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new StorageException("Error to path delete", String.valueOf(path.getFileName()));
        }
    }

    @Override
    protected void doUpdate(Resume r, Path path) {
        try {
           strategy.doWrite(r, new BufferedOutputStream(new FileOutputStream(path.toFile())));
        } catch (IOException e) {
            throw new StorageException("IO error", String.valueOf(path.getFileName()), e);
        }
    }

    @Override
    protected Resume doGet(Path path) {
        try {
            return strategy.doRead(new FileInputStream(path.toFile()));
        } catch (IOException e) {
            throw new StorageException("IO error", String.valueOf(path.getFileName()), e);
        }
    }


    @Override
    protected boolean isExist(Path path) {
        return Files.exists(path);
    }

    @Override
    protected List<Resume> doGetAll() {
        List<Resume> list = new ArrayList<>();
        for (Path path : notNullDirectoryList()) {
            list.add(doGet(path));
        }
        return list;
    }

    @Override
    public void clear() {
        try {
            Files.list(directory).forEach(path -> doDelete(path));
        } catch (IOException e) {
            throw new StorageException("Directory returns null ", null, e);
        }
    }


    @Override
    public int size() {
        return notNullDirectoryList().size();
    }

    private List<Path> notNullDirectoryList() {
        Path[] dirArray;
        try (Stream<Path> pathStream = Files.list(directory)) {
            return pathStream.toList();
        } catch (IOException e) {
            throw new StorageException("Can't read directory ", null, e);
        }
    }

    protected abstract void doWrite(Resume r, OutputStream os) throws IOException;

    protected abstract Resume doRead(InputStream is) throws IOException;
}
