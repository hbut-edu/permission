package cn.edu.hbut.manage.permission.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;

    @Getter @Setter private String name;

    @OneToMany(mappedBy = "user")
    @Getter @Setter private List<Permission> permissions;

}
