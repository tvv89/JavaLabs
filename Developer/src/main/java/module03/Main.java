package module03;

import module03.entity.Company;
import module03.entity.Skill;
import module03.repository.CompanyRepository;
import module03.repository.SkillRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SkillRepository tmp = new SkillRepository();
        Skill skill01 = new Skill(13,"CPP");

       // tmp.create(skill01);
       // tmp.delete(skill01);
       // List<Skill> res = tmp.read();
       // res.forEach(System.out::println);

    }
}
