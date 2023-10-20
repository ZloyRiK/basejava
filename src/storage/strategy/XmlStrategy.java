package storage.strategy;

import model.*;
import util.XmlParser;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class XmlStrategy implements StorageStrategy {
    private XmlParser xmlParser;

    public XmlStrategy() {
        xmlParser = new XmlParser(Resume.class, TextSection.class, ListSection.class, Period.class, CompanySection.class, Company.class);
    }


    @Override
    public void doWrite(Resume r, OutputStream os) throws IOException {
        try (Writer w = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
            xmlParser.marshal(r, w);
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try(Reader r = new InputStreamReader(is, StandardCharsets.UTF_8)){
            return xmlParser.unmarshall(r);
        }
    }
}
