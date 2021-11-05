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
            Address address = new Address("city","street","zipcode");

            Member member = new Member();
            member.setUsername("member1");
            member.setAddress(address);
            em.persist(member); // 디비에 값 반영


            Address newAddress = new Address("newCity", address.getStreet(), address.getZipcode());
            member.setAddress(newAddress);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
