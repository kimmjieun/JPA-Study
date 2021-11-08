package hellojpa;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main  (String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setUsername("member1");
            member.setAddress(new Address("homecity","street","zipcode"));
            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new AddressEntity("old1", "street1", "zipcode1"));
            member.getAddressHistory().add(new AddressEntity("old2", " street2", "zipcode2"));

            em.persist(member); // 디비에 값 반영

            em.flush();
            em.clear();

            System.out.println("=======START=======");
            Member findMember = em.find(Member.class, member.getId());// 멤버만 가져온다 , 컬렉션은 지연로딩이다

//            List<Address> addressHistory = findMember.getAddressHistory();
//            for (Address address : addressHistory){
//                System.out.println("address = "+ address.getCity());
//            }
//
//            Set<String> favoritFoods = findMember.getFavoriteFoods();
//            for( String favoriteFood : favoritFoods){
//                System.out.println("favoriteFood = " + favoriteFood);
//            }

            // 값 타입 컬렉션 수정

            // 치킨 -> 한식
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");


            // 주소 변경
//            findMember.getAddressHistory().remove(new Address("old1", "street1", "zipcode1"));
//            findMember.getAddressHistory().add(new Address("new1", "street1", "zipcode1"));




            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
