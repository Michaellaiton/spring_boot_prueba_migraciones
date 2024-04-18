package com.senaolimpo.olimpoApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
 @Table(name = "Role")
 @NoArgsConstructor
 @AllArgsConstructor
 @Data
public class Role implements Serializable {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id", nullable = false)

    private Long id;
     @Column(name = "name", length = 20)
    private String name;
     @Column(name = "abbreviation", length = 4)
    private String abbreviation;
     @Column(name = "description")
    private String description;
     @Column(name = "state", columnDefinition = "boolean default false")
     private Boolean state;

     @ManyToMany(mappedBy = "listRole", cascade = CascadeType.PERSIST)
     private List<User> listUser;

}
