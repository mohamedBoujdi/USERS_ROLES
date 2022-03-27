package me.med.enset_JPA.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "USERS")
public class User {
    @Id
    private String userid;
    @Column(unique = true,length = 20)
    private  String userName;
    private  String password;
    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
    private Collection<Role> roles= new ArrayList();

}
