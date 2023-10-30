package model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Initial resume class
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Resume implements Serializable {
    private static final long serialVersionUID = 1L;


    // Unique identifier
    private String uuid;
    private String fullName;
    private final Map<SectionType, AbstractSection> sections = new HashMap<>();
    private final Map<ContactType, String> contacts = new HashMap<>();

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Map<SectionType, AbstractSection> getSections() {
        return sections;
    }

    public Map<ContactType, String> getContacts() {
        return contacts;
    }

    public void setSection(SectionType type, AbstractSection section) {
        sections.put(type, section);
    }

    public void setContact(ContactType type, String value) {
        contacts.put(type, value);
    }

    public Resume() {
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


    @Override
    public String toString() {
        return uuid + '(' + fullName + ')' + "\n" + contacts + '\n' + sections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return uuid.equals(resume.uuid) && fullName.equals(resume.fullName) && sections.equals(resume.sections) && contacts.equals(resume.contacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName, sections, contacts);
    }
}
