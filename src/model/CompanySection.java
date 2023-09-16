package model;

import java.util.Map;

import static model.Resume.EDUCATION_MAP;
import static model.Resume.EXPERIENCE_MAP;

public class CompanySection extends AbstractSection {

    
    public static void addExperience(String title, String subTitle, String description, Period period) {
        EXPERIENCE_MAP.put(period, new TextSection(title, subTitle, description));
    }

    public static void addEducation(String title, String subTitle, Period period) {
        EDUCATION_MAP.put(period, new TextSection(title, subTitle));
    }

    public CompanySection(){
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Period, TextSection> entry : EXPERIENCE_MAP.entrySet()) {
            sb.append(entry.getKey().toString()).append(": ").append(entry.getValue().toString()).append("\n");
        }
        return sb.toString();
    }
}
