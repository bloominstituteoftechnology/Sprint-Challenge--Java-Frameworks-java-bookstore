package com.lambdaschool.usermodel.models;



import javax.persistence.*;

@Entity
@Table(name="SECTION")
public class Section extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;
}
