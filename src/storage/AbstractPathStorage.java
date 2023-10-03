package storage;

import exeption.StorageException;
import model.Resume;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractPathStorage extends AbstractStorage<Path> {
    private final Path directory;

    public AbstractPathStorage(String dir) {
        this.directory = Paths.get(dir);
        Objects.requireNonNull(directory, "Directory can't be null");
        if (!Files.isDirectory(directory)) {
            throw new IllegalArgumentException(dir + " is not a directory");
        }
        if (!Files.isReadable(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + " is not a readable/writable");
        }
    }

    @Override
    protected Path getSearchKey(String uuid) {
        return Path.of(uuid);
    }

    @Override
    protected void doSave(Resume r, Path path) {
        try {
            doWrite(r, new BufferedOutputStream(new FileOutputStream(path.toFile())));
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
            doWrite(r, new BufferedOutputStream(new FileOutputStream(path.toFile())));
        } catch (IOException e) {
            throw new StorageException("IO error", String.valueOf(path.getFileName()), e);
        }
    }

    @Override
    protected Resume doGet(Path path) {
        try {
            return doRead(new FileInputStream(path.toFile()));
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
        for (Path path : notNullDirectoryArray()) {
            list.add(doGet(path));
        }
        return list;
    }

    @Override
    public void clear() {
        try {
            Files.list(directory).forEach(path -> doDelete(directory));
        } catch (IOException e) {
            throw new StorageException("Directory returns null ", null, e);
        }
    }


    @Override
    public int size() {
        return notNullDirectoryArray().length;
    }

    private Path[] notNullDirectoryArray() {
        Path[] dirArray;
        try {
            dirArray = (Path[]) Files.list(directory).toArray();
        } catch (IOException e) {
            throw new StorageException("Can't read directory ", null, e);
        }
        if (dirArray == null) {
            throw new StorageException("Directory returns null ", null);
        }
        return dirArray;
    }

    protected abstract void doWrite(Resume r, OutputStream os) throws IOException;

    protected abstract Resume doRead(InputStream is) throws IOException;
}
