import model.Resume;

import java.util.*;

public class MainCollections {
    protected static final String UUID_1 = "uuid1";
    protected static final String UUID_2 = "uuid2";
    protected static final String UUID_3 = "uuid3";
    protected static final String UUID_4 = "uuid4";

    protected static final Resume R1 = new Resume(UUID_1);
    protected static final Resume R2 = new Resume(UUID_2);
    protected static final Resume R3 = new Resume(UUID_3);
    protected static final Resume R4 = new Resume(UUID_4);

    public static void main(String[] args) {
        Collection<Resume> collection = new ArrayList<>();
        collection.add(R1);
        collection.add(R2);
        collection.add(R3);


        Iterator<Resume> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Resume r = iterator.next();
            System.out.println(r);
            if (Objects.equals(r.getUuid(), UUID_1)) {
                iterator.remove();
            }
        }
        System.out.println(collection.toString());

        Map<String, Resume> map = new HashMap<>();
        map.put(UUID_1, R1);
        map.put(UUID_2, R2);
        map.put(UUID_3, R3);

        for (Map.Entry<String, Resume> entry : map.entrySet()){
            System.out.println(entry.getValue());
        }
    }
}
