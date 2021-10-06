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

            //팀 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            //회원 저장
            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);

            // 영속성 컨테스트 말고 아래서 새로 생성된 디비쿼리 보고싶을 때
            em.flush();
            em.clear();

            // 연관관계 적용 전
//            //조회
//            Member findMember = em.find(Member.class, member.getId());
//            //연관관계가 없음
//            Team findTeam = em.find(Team.class, team.getId());

            // 연관관계 적용 후
            Member findMember = em.find(Member.class,member.getId());
            List<Member> members = findMember.getTeam().getMembers();

            for (Member m : members){
                System.out.println("m = "+m.getUsername());
            }

            Team findTeam = findMember.getTeam();
            System.out.println("findTeam = "+findTeam.getName());

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
