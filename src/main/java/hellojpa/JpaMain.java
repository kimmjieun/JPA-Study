package hellojpa;

import javax.persistence.*;

public class JpaMain {

    public static void main  (String[] args){
        // 웹서버당 하나만 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // 고객 요청따라 생겼다가 없앴다가 함 , 쓰레드간 공유 x
        EntityManager em = emf.createEntityManager();

        // jpa의 모든 변경은 트랜잭션안에서 해야한다
        EntityTransaction tx = em.getTransaction();
        tx.begin();


        // 트랜잭션을 트라이 캐치 구문에 넣는다
        try {
            // 멤버를 저장해볼것
            // 애플리케이션 로딩 시점에 하나만 만들어놔야해
            // 한 일관적인 단위를 할 떄마다 엔티티 매니저를 만들어야한다

            // 추가
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);

//            // 조회
//            Member findMember = em.find(Member.class,1L);
//            System.out.println("findMember = "+ findMember.getId()) ;

            // 삭제
//            Member findMember = em.find(Member.class,1L);
//            em.remove(findMember);

            // 수정
//            Member findMember = em.find(Member.class,2L);
//            findMember.setName("HelloJPA");
            // 그 후에 저장안해도 됨 왜? 트랜잭션 커밋전에 변경사항 확인하고 업데이트 쿼리 날려주고 커밋하기 때문



            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
