package com.rafaur.wastemicroservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wasteManagerEntity")
public class WasteManagerEntity  extends Waste implements Serializable {
    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Nif", nullable = false)
    private String nif;

    @OneToOne(mappedBy = "wasteManagerEntity",  fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JsonBackReference
    @JoinColumn(name = "wasteManagerEntity", nullable = false)
    private WasteManagerAddressEntity wasteManagerEntity;

    @OneToMany(mappedBy = "wasteManagerEntity", cascade={CascadeType.ALL},
            fetch = FetchType.EAGER)
    @Column(insertable = false , name = "wasteCenterAuthorizationEntity")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private List<WasteCenterAuthorizationEntity>
            listOfWasteCenterAuthorization = new ArrayList<>();



}
