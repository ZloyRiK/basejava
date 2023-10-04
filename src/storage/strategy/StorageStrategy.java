package storage.strategy;

import model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface StorageStrategy {

    public void doWrite(Resume r, OutputStream os) throws IOException;

    public Resume doRead(InputStream is) throws IOException;

}
