package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // 설정파일에 설정했던 unit 이름
        // 애플리케이션로딩 시점에 하나만

        EntityManager em = emf.createEntityManager(); //트랜잭션 마다 만들어줘야함 (DB커넥션을 얻어서 쿼리를 날리고 종료하는)

        EntityTransaction tx = em.getTransaction(); // 트랜잭션 생성 * 항상 JPA는 트랜잭션 안에서 동작해야함
        tx.begin();

        try {

            Member findMember1 = em.find(Member.class, 101L);
            Member findMember2 = em.find(Member.class, 101L);
            System.out.println("findMember1 == findMember2 => " + (findMember2 == findMember1));

            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");

            em.persist(member1);
            em.persist(member2);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); // 꼭 사용해야함
        }
        emf.close();

        /*  설정파일의 show_sql - sql 보여주기, format_sql - 이쁘게 정리,
        Hibernate:
         //insert hellojpa.Member  // use_sql_comments - 왜 나온지 확인
         insert
                into
        Member
                (name, id)
        values
                (?, ?)
         */

    }
}