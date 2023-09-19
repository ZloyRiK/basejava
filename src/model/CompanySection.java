package model;

import java.util.ArrayList;
import java.util.List;

public class CompanySection extends AbstractSection {


    private List <Company> companies = new ArrayList<>();

    public CompanySection(List<Company> companies) {
        this.companies = companies;
    }

    public CompanySection(){
    }

    @Override
    public String toString() {
        return companies.toString();
    }
}
