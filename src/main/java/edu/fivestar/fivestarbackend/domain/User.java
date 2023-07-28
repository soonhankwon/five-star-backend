package edu.fivestar.fivestarbackend.domain;

import edu.fivestar.fivestarbackend.dto.UserSignupReqDto;
import edu.fivestar.fivestarbackend.util.BaseTimeEntity;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@ToString
@Table(name = "`user`")
public class User extends BaseTimeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String name;

    private String password;

    //TODO N+1
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> post;

    public User(UserSignupReqDto dto) {
        this.email = dto.getEmail();
        this.name = dto.getName();
        this.password = dto.getPassword();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return this.password;
    }
}