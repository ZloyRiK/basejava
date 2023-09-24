package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Company {
    private List<Period> periods = new LinkedList<>();
    private String companyName;
    private String website;

    public Company(Period period, String companyName, String website) {
        Objects.requireNonNull(period, "Period value can't be null");
        Objects.requireNonNull(companyName, "Company name value can't be null");
        this.periods.add(period);
        this.companyName = companyName;
        this.website = website;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        Objects.requireNonNull(companyName, "Company name value can't be null");
        this.companyName = companyName;
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
        return periods.equals(company.periods) && companyName.equals(company.companyName) && website.equals(company.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(periods, companyName, website);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Period period : periods) {
            sb.append(website).append("\n");
            sb.append(companyName).append("\n");
            sb.append(period.toString()).append("\n");
        }
        return sb.toString();
    }
}
