package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@Entity(name = "USER") // 테이블과 매핑이 가능함 가급적 기본값
public class Member {

    @Id
    private Long id;

    //@Column(name = "username") // 컬럼명 매핑 가능함
    private String name;

    private int age;
    public Member(){
    }

    public Member(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
