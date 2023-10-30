package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.CompanySection;

import java.io.Reader;
import java.io.Writer;

public class JsonParser {
    private static Gson GSON = new GsonBuilder()
            .registerTypeAdapter(CompanySection.class, new JsonSectionAdapter<>())
            .setPrettyPrinting().create();

    public static <T> T readJson(Reader reader, Class<T> clazz){
        return GSON.fromJson(reader, clazz);
    }

    public static <T> void writeJson(T object, Writer writer){
        GSON.toJson(object, writer);
    }
}
