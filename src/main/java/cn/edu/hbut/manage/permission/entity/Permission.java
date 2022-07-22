package cn.edu.hbut.manage.permission.entity;

import cn.edu.hbut.manage.permission.enumtype.PermissionType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    @Getter @Setter private User user;

    @OneToOne
    @JoinColumn(name = "department_id")
    @Getter @Setter private Department department;

    @Enumerated(value = EnumType.ORDINAL)
    @Getter @Setter private PermissionType permissionType;

}
