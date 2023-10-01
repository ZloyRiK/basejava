package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CompanySection extends AbstractSection {
    private static final long serialVersionUID = 1L;

    private List <Company> companies = new ArrayList<>();

    public CompanySection(List<Company> companies) {
        Objects.requireNonNull(companies, "List of company can't be null");
        this.companies = companies;
    }

    public CompanySection(Company... companies) {
        Objects.requireNonNull(companies, "List of company can't be null");
        this.companies = Arrays.asList(companies);
    }

    public CompanySection(){
    }

    @Override
    public String toString() {
        return companies.toString();
    }
}
