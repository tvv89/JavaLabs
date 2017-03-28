package module03.entity;

import javax.persistence.*;

@Entity
public class Skill {
    private int skillId;
    private String skillName;

    @Id
    @Column(name = "skill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    @Basic
    @Column(name = "skill_name")
    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Skill skills = (Skill) o;

        if (skillId != skills.skillId) return false;
        if (skillName != null ? !skillName.equals(skills.skillName) : skills.skillName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = skillId;
        result = 31 * result + (skillName != null ? skillName.hashCode() : 0);
        return result;
    }
}
