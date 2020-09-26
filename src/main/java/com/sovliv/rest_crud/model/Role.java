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
public class Role {

    @Id
    private Long role_id;

    private String role_name;
}
