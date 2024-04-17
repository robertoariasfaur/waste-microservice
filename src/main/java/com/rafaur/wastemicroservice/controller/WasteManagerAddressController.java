package com.rafaur.wastemicroservice.controller;

import com.rafaur.wastemicroservice.dto.WasteManagerAddressDTO;
import com.rafaur.wastemicroservice.services.WasteManagerAddressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
@AllArgsConstructor
@RefreshScope
public class WasteManagerAddressController {
    @Autowired
    private WasteManagerAddressService service;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<WasteManagerAddressDTO>> getAllWaste() {
        return new ResponseEntity<>(service.findAllAddress(), HttpStatus.OK);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity create(@Valid @RequestBody WasteManagerAddressDTO wasteManagerDto,
                                 @NotNull BindingResult bindingResult) throws Exception {

        if(bindingResult.hasErrors()){
            return new ResponseEntity<>("Datos incorrectos", HttpStatus.CONFLICT);
        }

        Long id = service.create(wasteManagerDto);
        return new ResponseEntity<String>("Waste Manager Address Creado con id " + id,HttpStatus.OK) ;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable("id") @Valid @RequestBody WasteManagerAddressDTO dto,
                                         @NotNull BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>("Datos incorrectos", HttpStatus.CONFLICT);
        }
        service.update(dto);
        return new ResponseEntity<String>("Waste Manager Address Actualizado" ,HttpStatus.OK) ;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id, @NotNull BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>("Datos incorrectos", HttpStatus.CONFLICT);
        }

        WasteManagerAddressDTO dto= service.findById(id);

        return new ResponseEntity<WasteManagerAddressDTO>(dto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteById( @PathVariable(name = "id") Long id) {
        service.deleteById(id);
        return new ResponseEntity<String>("Waste Manager Address Eliminado" ,HttpStatus.OK) ;
    }
}
