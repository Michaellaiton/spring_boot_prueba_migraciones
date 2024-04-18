package com.senaolimpo.olimpoApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", nullable = false)
    private  Long id;
    @Column(name = "password", length = 25)
    private  String password;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "useres_role",
        joinColumns = @JoinColumn(name = "id_role", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "id_user", nullable = false)
    )
    private List<Role> listRole;


}
