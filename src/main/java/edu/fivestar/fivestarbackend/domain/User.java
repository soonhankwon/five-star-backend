package edu.fivestar.fivestarbackend.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "`user`")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
