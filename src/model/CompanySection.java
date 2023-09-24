package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CompanySection extends AbstractSection {


    private List <Company> companies = new ArrayList<>();

    public CompanySection(List<Company> companies) {
        Objects.requireNonNull(companies, "List of company can't be null");
        this.companies = companies;
    }

    public CompanySection(){
    }

    @Override
    public String toString() {
        return companies.toString();
    }
}
