package hellojpa;


import javax.persistence.*;
import java.util.Date;

@Entity // 꼭 필요한 어노테이션
//@Table(name="USER") 테이블 이름이 클래스와 다를때 설정
public class Member {

    @Id
    private Long id;

    @Column(name="name") //updateable =false * 반영 x, nullable = false notnull제약조건
    private String userName;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob // 큰 문자열
    private String description;

    @Transient // 메모리 상에서만 쓰고 싶을때
    private int temp;


    public Member() {}




}
