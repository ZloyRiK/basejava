package storage.strategy;

import model.Resume;
import util.JsonParser;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class JsonStrategy implements StorageStrategy {


    public JsonStrategy() {
    }


    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
        try (Writer w = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
            JsonParser.writeJson(r, w);
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try(Reader r = new InputStreamReader(is, StandardCharsets.UTF_8)){
            return JsonParser.readJson(r, Resume.class);
        }
    }
}
