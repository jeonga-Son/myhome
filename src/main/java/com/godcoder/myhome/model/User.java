package com.godcoder.myhome.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private Boolean enabled;

    //@ManyToMany 반영되는 방식 지정할 수 있음. **cascade 옵션.
    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))

    //리스트를 이용해 권한과 매핑
    //양방향 매핑
    //Baeldung "Many-To-Many Relationship in JPA" 참고
    private List<Role> roles = new ArrayList<>();
}
