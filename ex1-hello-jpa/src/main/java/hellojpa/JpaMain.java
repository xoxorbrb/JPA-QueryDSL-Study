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

            /***
             * 전체 회원 조회
             */
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }
            /*insert
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//
//            em.persist(member);
//            tx.commit();

            //update
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA");

            //select
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());


            //delete
//            em.remove(findMember);

            tx.commit();
             */

            /***
             *  엔티티 생명주기
             */

            //비영속
            Member member = new Member();
            member.setId(101L);
            member.setName("HelloJPA");

            //영속
            System.out.println("=== BEFORE ===");
            em.persist(member);
//            em.detach(member); // 영속성 컨텍스트에서 분리, 준영속 상태
            System.out.println("=== AFTER ===");

            Member findMember = em.find(Member.class, 101L);
            System.out.println("findMember id => " + findMember.getId());
            System.out.println("findMember name => " + findMember.getName());


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