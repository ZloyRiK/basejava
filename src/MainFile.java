import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class MainFile {
    private static void printFiles(String path){
        File dir = new File (path);
        File[] files;
        if(dir.isDirectory()){
            files = dir.listFiles();
            for (int i = 0; i < Objects.requireNonNull(files).length; i++) {
                if (files[i].isDirectory()){
                    try {
                        System.out.println("Directory: " + files[i].getName());
                        printFiles(files[i].getCanonicalPath());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("\t"+files[i].getName());
                }
            }
        }
    }
    public static void main(String[] args) {
//        File filePath = new File("../gitignore");
//        try {
//            System.out.println(filePath.getCanonicalFile());
//        } catch (IOException e) {
//            throw new RuntimeException("Error", e);
//        }
//        File dir = new File("./src/");
//        String[] list = dir.list();
//        if (list != null) {
//            for (String name : dir.list()) {
//                System.out.println(name);
//            }
//        }
//
//        try (FileInputStream fis  = new FileInputStream(filePath)){
//            System.out.println(fis.read());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        printFiles("./src/");
    }

}
