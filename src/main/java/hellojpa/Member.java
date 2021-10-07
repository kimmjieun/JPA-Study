package hellojpa;

import javax.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id; // int 0이 있어서 애매, 대신 integer 좋은 것은 Long

    @Column(name = "USERNAME") // 객체는 username, 컬럼명은 name
    private String username;

    // 주인
    @ManyToOne
//    @JoinColumn(name="TEAM_ID")
    private Team team; // 멤버는 many, 팀은 one

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    // 연관관계 편의 메소드
    public void changeTeam(Team team){
        this.team = team;
        team.getMembers().add(this);
    }

}