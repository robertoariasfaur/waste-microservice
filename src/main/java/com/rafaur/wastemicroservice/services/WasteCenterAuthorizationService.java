package com.rafaur.wastemicroservice.services;

import com.rafaur.wastemicroservice.dto.WasteCenterAuthorizationDTO;
import com.rafaur.wastemicroservice.entity.WasteCenterAuthorizationEntity;
import com.rafaur.wastemicroservice.repository.WasteCenterAuthorizationRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class WasteCenterAuthorizationService {
    @Autowired
    private WasteCenterAuthorizationRepository repository;
    @Autowired
    private ModelMapper mapper;

    /**
     *
     * @return List<WasteCenterAuthorizationDTO>
     */
    public List<WasteCenterAuthorizationDTO> findAll() {

        List<WasteCenterAuthorizationDTO> list = new LinkedList<>();
        List<WasteCenterAuthorizationEntity> lisEnt =  repository.findAll();
        lisEnt.forEach(entitys->{
            list.add(mapper.map(entitys,WasteCenterAuthorizationDTO.class));
        });

        return list;
    }

    /**
     *
     * @param id
     * @return WasteCenterAuthorizationDTO
     */
    public WasteCenterAuthorizationDTO findById(Long id) {
        return mapper.map(this.findByIdL(id), WasteCenterAuthorizationDTO.class);
    }

    private WasteCenterAuthorizationEntity findByIdL(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    /**
     *
     * @param dTO
     * @return Long Id del waste creado
     */
    public Long create (WasteCenterAuthorizationDTO dTO) throws Exception{
        return repository.save(mapper.map(dTO, WasteCenterAuthorizationEntity.class)).getId();
    }

    /**
     *
     * @param dTO
     */

    public void update( WasteCenterAuthorizationDTO dto) throws Exception{

        WasteCenterAuthorizationEntity entity = this.repository.findById(dto.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        repository.save(mapper.map(dto,WasteCenterAuthorizationEntity.class));
    }


    /**
     *
     * @param id
     */
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    /**
     *
     */
    public void deleteAllWaste() {
        this.repository.deleteAll();
    }


    /**
     *
     * @return List<WasteCenterAuthorizationDTO>
     */
    public List<WasteCenterAuthorizationDTO> findAllAuthorization() {

        List<WasteCenterAuthorizationDTO> listDto = new LinkedList<>();
        List<WasteCenterAuthorizationEntity> list = this.repository.findAll();

        list.forEach(wasteCenterAuthorization -> {
            listDto.add(mapper.map(wasteCenterAuthorization, WasteCenterAuthorizationDTO.class));
        });
        return listDto;
    }


}
