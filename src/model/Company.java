package model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Company {
    private List<Period> periods = new LinkedList<>();
    private String name;
    private String website;

    public Company(Period period, String name, String website) {
        Objects.requireNonNull(period, "Period value can't be null");
        Objects.requireNonNull(name, "Company name value can't be null");
        this.periods.add(period);
        this.name = name;
        this.website = website;
    }

    public Company(String name, String website, Period... period) {
        Objects.requireNonNull(period, "Period value can't be null");
        Objects.requireNonNull(name, "Company name value can't be null");
        this.periods = Arrays.asList(period);
        this.name = name;
        this.website = website;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Objects.requireNonNull(name, "Company name value can't be null");
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return periods.equals(company.periods) && name.equals(company.name) && website.equals(company.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(periods, name, website);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Period period : periods) {
            sb.append(website).append("\n");
            sb.append(name).append("\n");
            sb.append(period.toString()).append("\n");
        }
        return sb.toString();
    }
}
