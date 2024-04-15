package com.rafaur.wastemicroservice.services;

import com.rafaur.wastemicroservice.dto.WasteManagerAddressDTO;
import com.rafaur.wastemicroservice.entity.WasteManagerAddressEntity;
import com.rafaur.wastemicroservice.repository.WasteManagerAdressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class WasteManagerAddressService {
    @Autowired
    private WasteManagerAdressRepository repository;
    @Autowired
    private ModelMapper mapper;


    /**
     *
     * @param addressDTO
     * @return ResponseEntity
     */
    public Long create (WasteManagerAddressDTO addressDTO) throws Exception{

        return repository.save(mapper.map(addressDTO, WasteManagerAddressEntity.class)).getId();
    }

    /**
     *
     * @param dto
     * @return ResponseEntity
     */
    public void update( WasteManagerAddressDTO dto) throws Exception{

        WasteManagerAddressEntity entity = this.repository.findById(dto.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        repository.save(mapper.map(dto,WasteManagerAddressEntity.class));
    }

    /**
     *
     * @param addressId
     * @return ResponseEntity
     */
    public WasteManagerAddressDTO findById(Long addressId) throws Exception{

        Optional<WasteManagerAddressEntity> optional =
                this.repository.findById(addressId);
        if (!optional.isPresent()) {
            throw new org.springframework.http.InvalidMediaTypeException
                    ("Waste not found", HttpStatus.NOT_FOUND.name());
        }

        WasteManagerAddressEntity o= optional.get();
        return mapper.map(o,WasteManagerAddressDTO.class);
    }


    /**
     *
     * @param id
     * @return ResponseEntity
     */
    public void deleteById(Long id) {
        this.repository.deleteById(id);

    }


    /**
     *
     * @return ResponseEntity
     */
    public void deleteAllWaste() {
        this.repository.deleteAll();
    }


    /**
     *
     * @return ResponseEntity
     */
    public List<WasteManagerAddressDTO> findAllAddress() {
        List<WasteManagerAddressDTO> listDto = new LinkedList<>();
        List<WasteManagerAddressEntity> list = this.repository.findAll();

        list.forEach(wasteManagerAddressEntity -> {
            listDto.add(mapper.map(wasteManagerAddressEntity, WasteManagerAddressDTO.class));
        });

        return listDto;
    }

}
