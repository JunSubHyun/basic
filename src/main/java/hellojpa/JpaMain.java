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

            //페이징추가
            List<Member> result = em.createQuery("select m from Member as m",Member.class)
                    .setFirstResult(5)                  //추가 하면 limit 를 자동 추가
                    .setMaxResults(8)
                    .getResultList();

            for(Member member : result){
                System.out.println("member.name = " + member.getName());
            }

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();

    }
}
