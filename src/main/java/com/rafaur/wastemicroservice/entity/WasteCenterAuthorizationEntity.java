package com.rafaur.wastemicroservice.entity;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wasteCenterAuthorizationEntity")
public class WasteCenterAuthorizationEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    @Basic(fetch = FetchType.EAGER)
    private Long id;

    @Column(name = "Authorization")
    private String authorizationNumber;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @NotFound(action = NotFoundAction.EXCEPTION)
    @JoinColumn(name = "WasteManagerEntity_Id",
            nullable = false, referencedColumnName = "Id")
    @NotFound(action = NotFoundAction.IGNORE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private WasteManagerEntity wasteManagerEntity;
}
