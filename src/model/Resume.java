package model;

import java.util.Comparator;
import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    private final String uuid;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private String fullName;

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public Resume(String uuid) {
        this.uuid = uuid;
    }

    public Resume() {
        this.uuid = UUID.randomUUID().toString();
        this.fullName = "Employee";
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
//        System.out.printf("\n----------------\n%s\n--------------\n", o);
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return uuid.equals(resume.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public String toString() {
        return uuid;
    }

    public static class ResumeUuidComparator implements Comparator<Resume> {
        @Override
        public int compare(Resume o1, Resume o2) {
            return o1.getUuid().compareTo(o2.getUuid());
        }
    }

    public static class ResumeFullNameComparator implements Comparator<Resume> {
        @Override
        public int compare(Resume o1, Resume o2) {
            if (o2.getFullName()==null){
                return 0;
            }
            return o1.getFullName().compareTo(o2.getFullName());
        }
    }

}
