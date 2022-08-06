package com.godcoder.myhome.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; //권한이름

    //양방향 매핑
    @ManyToMany(mappedBy = "roles")
    private List<User> user;
}
