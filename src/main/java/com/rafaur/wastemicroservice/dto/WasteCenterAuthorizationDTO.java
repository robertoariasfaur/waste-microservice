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
public class WasteCenterAuthorizationDTO implements Serializable {
    Long id;

    @NotBlank(message = "Número de autorizacion requerido")
    private String authorizationNumber;

    private WasteManagerDTO wasteManagerDTO;
}
