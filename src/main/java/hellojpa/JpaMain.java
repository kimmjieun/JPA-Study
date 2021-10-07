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
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.changeTeam(team );
            em.persist(member);

            // 양방향 매핑시 양쪽에 값을 다 넣어주는 게 맞다

            em.flush();
            em.clear();

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
