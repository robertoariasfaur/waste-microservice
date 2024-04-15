package com.rafaur.wastemicroservice.services;

import com.rafaur.wastemicroservice.dto.WasteManagerDTO;
import com.rafaur.wastemicroservice.entity.WasteCenterAuthorizationEntity;
import com.rafaur.wastemicroservice.entity.WasteManagerAddressEntity;
import com.rafaur.wastemicroservice.entity.WasteManagerEntity;
import com.rafaur.wastemicroservice.repository.WasteCenterAuthorizationRepository;
import com.rafaur.wastemicroservice.repository.WasteManagerAdressRepository;
import com.rafaur.wastemicroservice.repository.WasteManagerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@AllArgsConstructor
public class WasteManagerService {
    @Autowired
    private WasteManagerRepository wasteManagerRepository;
    @Autowired
    private WasteManagerAdressRepository wasteManagerAdressRepository;

    @Autowired
    private WasteCenterAuthorizationRepository centerAuthorizationRepository;
    @Autowired
    private ModelMapper mapper;


    public Long create (WasteManagerDTO wasteManagerDto) throws Exception{

        WasteManagerEntity entity = mapper.map(wasteManagerDto, WasteManagerEntity.class);

        wasteManagerDto.getListOfWasteCenterAuthorizationDTOS().forEach(
                entityVisual->{
                    WasteCenterAuthorizationEntity aut = mapper.map(entityVisual, WasteCenterAuthorizationEntity.class);
                    centerAuthorizationRepository.save(aut);
                }
        );


        WasteManagerAddressEntity address =
                mapper.map(wasteManagerDto.getWasteManagerAddressDTO(), WasteManagerAddressEntity.class);

        wasteManagerAdressRepository.save(address);

        return wasteManagerRepository.save(entity).getId();
    }

    public void update( WasteManagerDTO dto) throws Exception{

        WasteManagerEntity entity= this.wasteManagerRepository.findById(dto.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        entity = mapper.map(dto,WasteManagerEntity.class);

        wasteManagerRepository.save(entity);
    }
    public WasteManagerDTO findById(Long Id) throws Exception{

        Optional<WasteManagerEntity> optional =
                this.wasteManagerRepository.findById(Id);

        if (!optional.isPresent()) {
            throw new org.springframework.http.InvalidMediaTypeException
                    ("Waste not found", HttpStatus.NOT_FOUND.name());
        }
        WasteManagerEntity o= optional.get();
        WasteManagerDTO wasteManagerDTO = mapper.map(o,WasteManagerDTO.class);

        return wasteManagerDTO;
    }

    public void deleteById(Long id) {
        this.wasteManagerRepository.deleteById(id);
    }

    public void deleteAllWaste() {
        this.wasteManagerRepository.deleteAll();
    }

    /**
     *
     * @return WasteManagerEntity
     */
    public List<WasteManagerDTO> findAllWaste() {
        List<WasteManagerDTO> listDto = new LinkedList<>();
        List<WasteManagerEntity> list = this.wasteManagerRepository.findAll();

        list.forEach(entity -> {
            listDto.add(mapper.map(entity, WasteManagerDTO.class));
        });

        return listDto;
    }

}
