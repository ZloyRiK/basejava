package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CompanySection extends AbstractSection {

    private static final Map <Period, TextSection> COMPANY_MAP = new HashMap<>();
    private TextSection body;

    private Period period;

    public static void addCompany(String title, String subTitle, String description, Period period) {
        COMPANY_MAP.put(period, new TextSection(title, subTitle, description));
    }

    public static void addCompany(String title, String subTitle, Period period) {
        COMPANY_MAP.put(period, new TextSection(title, subTitle));
    }

    public CompanySection(){
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Period getPeriod() {
        return period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanySection that = (CompanySection) o;
        return body.equals(that.body) && period.equals(that.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body, period);
    }

    @Override
    public String toString() {
        return period.toString() + body;
    }
}
