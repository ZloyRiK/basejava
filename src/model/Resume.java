package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import static model.CompanySection.addCompany;

/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    private final String uuid;
    private String fullName;

    private final Map <SectionType, AbstractSection> sections = new HashMap<>();
    private final Map <ContactType, String> contacts = new HashMap<>();

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "Uuid can't be null");
        Objects.requireNonNull(fullName, "FullName can't be null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public Resume(String fullName) {
        this.fullName = fullName;
        this.uuid = UUID.randomUUID().toString();
    }

    public String getUuid() {
        return uuid;
    }

    public AbstractSection getSection(SectionType type){
        return sections.get(type);
    }

    public String getContact(ContactType type){
        return contacts.get(type);
    }

    public void setSection(SectionType type, AbstractSection section){
        sections.put(type, section);
    }

    public void setContact(ContactType type, String value){
        contacts.put(type, value);
    }

    public void addExperience(String title, String subTitle, String description, Period period) {
        addCompany(title, subTitle, description, period);
    }

    public void addEducation(String title, String subTitle, Period period) {
        addCompany(title, subTitle, period);
    }

    @Override
    public String toString() {
        return uuid + '(' + fullName + ')' + "\n" + contacts + '\n' + sections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        if (!uuid.equals(resume.uuid)) return false;
        return fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName);
    }
}
