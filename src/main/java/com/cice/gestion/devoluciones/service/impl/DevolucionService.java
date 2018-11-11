package com.cice.gestion.devoluciones.service.impl;

import com.cice.gestion.devoluciones.data.entity.DevolucionEntity;
import com.cice.gestion.devoluciones.data.repository.DevolucionRepository;
import com.cice.gestion.devoluciones.service.IDevolucionService;
import com.cice.gestion.devoluciones.service.converter.DevolucionConverter;
import com.cice.gestion.devoluciones.web.dto.DevolucionDTO;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DevolucionService implements IDevolucionService{

    @Autowired
    private DevolucionRepository devolucionRepository;

    @Autowired
    private DevolucionConverter devolucionConverter;

    @Override
    public List<DevolucionDTO> findAllReturns(){
        List<DevolucionDTO> devolucionDTOList = null;
        devolucionDTOList = devolucionRepository
                .findAll()
                .stream()
                .map(entity -> devolucionConverter.DevolucionEntityToDTO(entity))
                .collect(Collectors.toList());
        return devolucionDTOList;
    }

    @Override
    public Optional<DevolucionDTO> findAllReturnById(Long id){
        Optional<DevolucionDTO> devolucionDTOOptional = Optional.empty();
        Optional<DevolucionEntity> entityOptional = devolucionRepository.findById(id);
        if(entityOptional.isPresent()){
            devolucionDTOOptional = Optional.of(devolucionConverter.DevolucionEntityToDTO(entityOptional.get()));
        }
        return devolucionDTOOptional;
    }

    @Override
    public Long insertReturn(DevolucionDTO devolucionDTO){
        Long idDevolucion = null;
        DevolucionEntity insert = devolucionRepository.save(devolucionConverter.DevolucionDTOToEntity(devolucionDTO));
        idDevolucion = insert.getId();
        return idDevolucion;
    }

    @Override
    public DevolucionDTO updateReturn(DevolucionDTO devolucionDTO){
        DevolucionDTO devolucionUpdate = null;
        Optional<DevolucionEntity> devolucionEntity = devolucionRepository.findById(devolucionDTO.getId());
        if(devolucionEntity.isPresent()){
            devolucionConverter.DTOVsEntity(devolucionDTO, devolucionEntity.get());
            devolucionRepository.save(devolucionEntity.get());
            devolucionUpdate = devolucionConverter.DevolucionEntityToDTO(devolucionEntity.get());
        }
        return devolucionUpdate;
    }

    @Override
    public Long deleteUser(Long id){
        devolucionRepository.deleteById(id);
        return id;
    }
}
