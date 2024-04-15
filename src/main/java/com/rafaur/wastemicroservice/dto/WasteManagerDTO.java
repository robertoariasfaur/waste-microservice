package com.rafaur.wastemicroservice.dto;

import com.rafaur.wastemicroservice.entity.WasteCenterAuthorizationEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class WasteManagerDTO {
    private Long id;

    @NotBlank(message = "Nombre Requerido")
    private String nombre;

    @NotBlank(message = "Nif Requerido")
    private String nif;

    private Boolean isEnabled = Boolean.TRUE;

    private WasteManagerAddressDTO wasteManagerAddressDTO;

    private List<WasteCenterAuthorizationDTO>
            listOfWasteCenterAuthorizationDTOS = new ArrayList<>();

}
