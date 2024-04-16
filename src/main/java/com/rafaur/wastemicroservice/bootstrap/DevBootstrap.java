package com.rafaur.wastemicroservice.bootstrap;

import com.rafaur.wastemicroservice.dto.WasteCenterAuthorizationDTO;
import com.rafaur.wastemicroservice.dto.WasteManagerAddressDTO;
import com.rafaur.wastemicroservice.entity.WasteCenterAuthorizationEntity;
import com.rafaur.wastemicroservice.services.WasteCenterAuthorizationService;
import com.rafaur.wastemicroservice.services.WasteManagerAddressService;
import com.rafaur.wastemicroservice.services.WasteManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

    @Component
    public class DevBootstrap   implements ApplicationListener<ContextRefreshedEvent> {

        @Autowired
        private WasteManagerService service;


        @Autowired
        private WasteManagerAddressService addressService;

        @Autowired
        private WasteCenterAuthorizationService centerAuthorizationService;
        @Override
        public void onApplicationEvent(ContextRefreshedEvent event) {

            //init();
        }

        private void init() {

            try {


                WasteManagerAddressDTO addressDTO = new WasteManagerAddressDTO();
                addressDTO.setDireccion("Cuartel entre 11 y 12 sur Gtmo");
                addressDTO.setIsEnabled(true);

                Long idAdres = addressService.create(addressDTO);
                addressDTO.setId(idAdres);



                WasteCenterAuthorizationDTO authorizationDTO = new WasteCenterAuthorizationDTO();
                authorizationDTO.setAuthorizationNumber("789456");


            }catch (Exception e){

            }

        }

    }