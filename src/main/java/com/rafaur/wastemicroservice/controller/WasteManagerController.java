package com.rafaur.wastemicroservice.controller;

import com.rafaur.wastemicroservice.dto.WasteManagerDTO;
import com.rafaur.wastemicroservice.services.WasteManagerService;
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
@RequestMapping("/api/wastes")
@AllArgsConstructor
@RefreshScope
public class WasteManagerController {

    @Autowired
    private WasteManagerService service;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<WasteManagerDTO>> getAllWaste() {
        return new ResponseEntity<List<WasteManagerDTO>>(service.findAllWaste(), HttpStatus.OK);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> create(@Valid @RequestBody WasteManagerDTO wasteManagerDto,
                                         @NotNull BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>("Datos incorrectos", HttpStatus.CONFLICT);
        }
        Long id = service.create(wasteManagerDto);
        return new ResponseEntity<String>("Waste Manager Creado con id " + id,HttpStatus.OK) ;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable("id") @RequestBody @Valid  WasteManagerDTO dto,
                                         @NotNull BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>("Datos incorrectos", HttpStatus.CONFLICT);
        }
        service.update(dto);
        return new ResponseEntity<String>("Waste Manager Actualizado" ,HttpStatus.OK) ;
    }

    @GetMapping("/waste/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id, @NotNull BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>("Datos incorrectos", HttpStatus.CONFLICT);
        }

        WasteManagerDTO dto= service.findById(id);

        return new ResponseEntity<WasteManagerDTO>(dto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteById( @PathVariable(name = "id") Long id) {
         service.deleteById(id);
        return new ResponseEntity<String>("Waste Manager Eliminado" ,HttpStatus.OK) ;
    }

}
