import model.Resume;
import storage.ListStorage;
import storage.Storage;

public class MainCollections {
    protected static final String UUID_1 = "uuid1";
    protected static final String UUID_2 = "uuid2";
    protected static final String UUID_3 = "uuid3";
    protected static final String UUID_4 = "uuid4";

    protected static final Resume R1 = new Resume(UUID_1);
    protected static final Resume R2 = new Resume(UUID_2);
    protected static final Resume R3 = new Resume(UUID_3);
    protected static final Resume R4 = new Resume(UUID_4);
    static final Storage LIST_STORAGE = new ListStorage();

    public static void main(String[] args) {


        LIST_STORAGE.save(R1);
        LIST_STORAGE.save(R2);
        LIST_STORAGE.save(R3);

        System.out.println(LIST_STORAGE.get(UUID_1));

        System.out.println("\nGet r1: " + LIST_STORAGE.get(R1.getUuid()));
        System.out.println("Size: " + LIST_STORAGE.size());

//        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        System.out.print("\nResume update: ");
        LIST_STORAGE.update(R1);

        printAll();
        LIST_STORAGE.delete(R1.getUuid());
        printAll();
        LIST_STORAGE.clear();
        printAll();


        System.out.println("Size: " + LIST_STORAGE.size());

//        Iterator<Resume> iterator = LIST_STORAGE.iterator();
//        while (iterator.hasNext()) {
//            Resume r = iterator.next();
//            System.out.println(r);
//            if (Objects.equals(r.getUuid(), UUID_1)) {
//                iterator.remove();
//            }
//        }
//        System.out.println(LIST_STORAGE.toString());

//        Map<String, Resume> map = new HashMap<>();
//        map.put(UUID_1, R1);
//        map.put(UUID_2, R2);
//        map.put(UUID_3, R3);
//
//        for (Map.Entry<String, Resume> entry : map.entrySet()){
//            System.out.println(entry.getValue());
//        }
    }
    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : LIST_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
