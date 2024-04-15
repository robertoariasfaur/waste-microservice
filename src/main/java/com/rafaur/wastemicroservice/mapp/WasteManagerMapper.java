package com.rafaur.wastemicroservice.mapp;

import com.rafaur.wastemicroservice.dto.WasteManagerDTO;
import com.rafaur.wastemicroservice.entity.WasteManagerEntity;
import org.springframework.web.bind.annotation.Mapping;

public interface WasteManagerMapper  {


    public WasteManagerEntity mapOtoI(WasteManagerDTO wasteManagerDTO);





}
