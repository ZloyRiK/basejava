import model.Resume;
import model.SectionType;
import model.TextSection;

public class TestResumeData {
    public static void main(String[] args) {
        Resume resume = new Resume("Name");

        resume.setSection(SectionType.PERSONAL, new TextSection("Test text"));
    }
}
