package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {
    @Id
    private Long id;

    @Column(name = "name") // 객체는 username, 컬럼명은 name
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob // 큰 콘텐츠 디비의 TEXT 비슷
    private String description;

    public Member(){

    }
}