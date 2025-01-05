package hellojpa;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity // 꼭 필요한 어노테이션
//@Table(name="USER") 테이블 이름이 클래스와 다를때 설정
@SequenceGenerator(name ="MEMBER_SEQ_GENERATOR",
sequenceName = "MEMBER_SEQ",
initialValue = 1, allocationSize = 50)
public class Member {

    @Id //직접할당
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR") // IDENTITY 기본 키 생성을 데이터베이스에 위임
    /*
     *  IDENTITY일 경우 값을 직접 insert 해야 기본키를 알 수 있기 때문에
     *  commit에서 insert쿼리가 날라가는 게 아니라 persist 시 insert 쿼리가 날라가게 되어있음
     *
     *  SEQUENCE일 경우 commit 시에 날라가도록 되어있음 -> 대신 persist 시 call next value for member_seq 호출
     *  이렇게 되면 계속 네트워크로 디비와 애플리케이션을 왔다갔다해야함 -> 성능 상 문제가 있음
     *
     *  ->> allocation이 50인 이유
     *      -> 디비에 50개를 올려놓고, 메모리에서 1씩 쓰는거임
     *         이러면 51번째가 됐을 때 다시 50개를 더 올려서 100개를 올려놓는거임
     *         미리 올려놓고 쓰기
     *      10000개나 이런 식으로 하면 성능적으로 좋긴 하지만 (10000번에 한번 호출되니까)
     *      대신 웹서버를 내리거나 이럴경우 그 빈숫자들은 그대로 없어지고 10001번째부터 다시시작한다. (1 ~ 70개까지 쓰다가 다시 키면 10001 부터 시작한다는거임)
     * */
    private Long id;

    private String name;

    public Member() {}

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
