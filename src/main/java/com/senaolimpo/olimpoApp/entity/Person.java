package com.senaolimpo.olimpoApp.entity;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "people")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data



public class Person  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "name", length = 50)
    private  String name;
    @Column(name = "lastName", length = 50 )
    private String lastName;
    @Timestamp
    @Column(name = "dateBirth")
    private Date dateBirth;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "documentId", length = 11)
    private int documentId;
    @Column(name = "phone", length = 10)
    private int phone;
    @Column(name = "gender", length = 6)
    private String gender;

    @OneToOne
    @JoinColumn(name = "User_id")
    private User user;

    @OneToMany(mappedBy = "fk_idPerson",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Sale> saleSet;

}
