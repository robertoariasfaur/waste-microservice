package com.rafaur.wastemicroservice.entity;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wasteCenterAuthorization")
public class WasteCenterAuthorizationEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    @Basic(fetch = FetchType.EAGER)
    private Long id;

    @Column(name = "Authorization")
    private String authorizationNumber;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "wasteManagerEntity_id",
//            nullable = false) //, referencedColumnName = "id"
    //@NotFound(action = NotFoundAction.IGNORE)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    //@ToString.Exclude
    //@EqualsAndHashCode.Exclude

    @ManyToOne()
    @JoinColumn(name = "WASTE_MANAGER_ENTITY_ID")
    private WasteManagerEntity wasteManager;
}
