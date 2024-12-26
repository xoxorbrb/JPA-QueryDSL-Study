package hellojpa;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // 꼭 필요한 어노테이션
//@Table(name="USER") 테이블 이름이 클래스와 다를때 설정
public class Member {

    @Id //Primary key가 뭔지 JPA에 알려주기 위한 어노테이션
    private Long id;

    //@Column(name = "username") 컬럼이 다를때사용
    private String name;

    public Member() {

    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
