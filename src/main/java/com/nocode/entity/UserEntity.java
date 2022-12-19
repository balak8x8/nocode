package com.nocode.entity;
import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "USERS") // sets the name of the table that the model will be mapped to
@Getter // Creates getters for all the variables in the class
@Setter // Creates setters for all the variables in the class
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class UserEntity {
    @Id // Marks the variable as a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USERID") //sets the database column name and sets it to unique
    private String userId;

    @Column(name = "USERAGE") //sets the database column name and sets it to unique
    private Integer userAge;
}