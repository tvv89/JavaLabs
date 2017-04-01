package module03;

import module03.entity.Company;
import module03.repository.CompanyRepo;

public class Main {

    public static void main(String[] args) {
        CompanyRepo tmp = new CompanyRepo();
        Company com01 = new Company(5,"TVV");

            tmp.create(com01);
            tmp.read();

    }
}
