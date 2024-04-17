package com.rafaur.wastemicroservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "Waste_Manager_Details")
public class WasteManagerEntity  extends Waste implements Serializable {
    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Nif", nullable = false)
    private String nif;

    @OneToOne(cascade = CascadeType.ALL,  fetch = FetchType.EAGER)// mappedBy = "wasteManagerEntity",
    //@Fetch(FetchMode.JOIN)
    //@JsonBackReference
    @JoinColumn(name = "WasteManagerAddressEntity_id",referencedColumnName = "id",nullable = false)
    private WasteManagerAddressEntity wasteManagerEntity;

//    @OneToMany(mappedBy = "wasteManager", cascade={CascadeType.ALL}, fetch = FetchType.EAGER)
    //@Column(insertable = false , name = "WasteCenterAuthorizationEntity")
    //@OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonBackReference

    @OneToMany(mappedBy = "wasteManager", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WasteCenterAuthorizationEntity>
            listOfWasteCenterAuthorization = new ArrayList<>();



}
