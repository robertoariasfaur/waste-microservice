package com.rafaur.wastemicroservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wasteManagerAddressEntity")
public class WasteManagerAddressEntity extends Waste implements Serializable {

    @Column(name = "Direccion")
    private String direccion;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="wasteManagerEntitys_id")
    private WasteManagerEntity wasteManagerEntity;
}
