package model;

import java.util.HashMap;
import java.util.Map;

public class CompanySection extends AbstractSection {

    private static final Map <Period, TextSection> COMPANY_MAP = new HashMap<>();

    public static void addCompany(String title, String subTitle, String description, Period period) {
        COMPANY_MAP.put(period, new TextSection(title, subTitle, description));
    }

    public static void addCompany(String title, String subTitle, Period period) {
        COMPANY_MAP.put(period, new TextSection(title, subTitle));
    }

    public CompanySection(){
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Period, TextSection> entry : COMPANY_MAP.entrySet()) {
            sb.append(entry.getKey().toString()).append(": ").append(entry.getValue().toString()).append("\n");
        }
        return sb.toString();
    }
}
