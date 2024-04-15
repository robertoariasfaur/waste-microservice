package com.rafaur.wastemicroservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WasteManagerAddressDTO implements Serializable {
    @NotBlank(message = "Dirección Requerida")
    private String direccion;
    private Boolean isEnabled = Boolean.TRUE;
    private WasteManagerDTO wasteManagerDTO;

    private Long id;
}
