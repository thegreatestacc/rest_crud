package com.sovliv.rest_crud.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Data

@Entity
@Table(name = "role")
//@Embeddable
public class Role {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String role_name;
}
