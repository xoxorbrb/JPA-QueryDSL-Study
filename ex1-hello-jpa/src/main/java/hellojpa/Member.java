package hellojpa;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity // 꼭 필요한 어노테이션
//@Table(name="USER") 테이블 이름이 클래스와 다를때 설정
public class Member {

    @Id
    private Long id;

    @Column(name="name") //updateable =false * 반영 x, nullable = false notnull제약조건
    private String userName;

    private Integer age;

    @Enumerated(EnumType.STRING) // 기본값은 ORDINAL -> 이거는 enum의 순서를 가져옴 , STRING -> 이거는 ENUM 값을 가져옴 보통 순서를 사용하지 않음 ㄴ
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate testLocalDate; // date 형식으로 생성
    private LocalDateTime testLocalDateTiem;  // timestamp 형식으로 생성
    //@Temporal 어노테이션이 굳이 필요가 없음

    @Lob  // 매핑하는 필드 타입이 문자면 CLOB 매핑, 나머지는 BLOB 으로 매핑됨
    private String description;

    @Transient // 메모리 상에서만 쓰고 싶을때
    private int temp;


    public Member() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
