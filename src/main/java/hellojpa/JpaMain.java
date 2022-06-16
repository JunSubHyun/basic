package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String args[]) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

//        Member member = new Member();
//        member.setId(2L);
//        member.setName("HelloB");
//
//        em.persist(member);
//
//        tx.commit();
//
//        em.close();
//
//        emf.close();
        //리팩 토링 (정석 코드)
        
        try {
            //저장
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("HelloB");   
//            em.persist(member);X

            //찾기
//            Member findMember = em.find(Member.class,1L);

            //수정
//            Member findMember = em.find(Member.class,1L);
//            findMember.setName("HelloJPA");                 //JPA가 트랜젝션을 커밋하는 시점에서 체크해서 업데이트

            //쿼리 조회
//            List<Member> result = em.createQuery("select m from Member as m",Member.class)
//                    .getResultList();

//            //페이징추가
//            List<Member> result = em.createQuery("select m from Member as m",Member.class)
//                    .setFirstResult(5)                  //추가 하면 limit 를 자동 추가
//                    .setMaxResults(8)
//                    .getResultList();
//
//            for(Member member : result){
//                System.out.println("member.name = " + member.getName());
//            }
            
//            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
//
//            //영속
//            System.out.println("===BEFORE===");
//            em.persist(member);
//            System.out.println("===AFTER===");
//
//            Member findMember = em.find(Member.class, 101L);
//
//            System.out.println("findMember = " + findMember.getId());
//            System.out.println("findMember = " + findMember.getName());

//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);
//
//            //1차 캐시에서 가져오기 때문에 같은 값이 나옴
//            // result = true
//            System.out.println("result = "+(findMember1 == findMember2) );

//              //영속
//              Member member1 = new Member(150L, "A");
//              Member member2 = new Member(160L, "B");
//
//              em.persist(member1);
//              em.persist(member2);
//
//              System.out.println("============================");
            
            //수정
//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZZ");
            
            //플러시발생
//            Member member = new Member(200L,"member200");
//            em.persist(member);    // 영속성 컨텍스트 저장소에 담기고
//
//            em.flush();   //플러시 발생생
            
            //준영속
//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAA");   // 영속 상태
//
//            //em.clear();  -> 영속성 초기화
//
//            em.detach(member);  //영속에서 분리 -> 준영속 상태
//
//            System.out.println("====================");

            //엔티티 매핑 실습
            Member member = new Member();
            member.setUsername("C");

            em.persist(member);

            //커밋을 하는 시점에 데이터베이스로 전송(쿼리 실행)
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();

    }
}
