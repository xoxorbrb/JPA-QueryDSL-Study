package association;

import javax.persistence.*;


@Entity
public class Member {

    @Id @GeneratedValue
    private Long Id;

    @Column(name = "USERNAME")
    private String name;
    private int age;

    @Column(name = "TEAM_ID")
    private Long teamId;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}
