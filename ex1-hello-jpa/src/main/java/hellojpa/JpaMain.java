package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // 설정파일에 설정했던 unit 이름

        EntityManager em = emf.createEntityManager();
        //code 작성

        em.close();

        emf.close();
    }
}