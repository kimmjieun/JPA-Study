package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main  (String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();

            member.setUsername("hello");
            member.setAddress(new Address("city","street","zipcode"));
            member.setPeriod(new Period());

            em.persist(member); // 디비에 값 반영



            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
