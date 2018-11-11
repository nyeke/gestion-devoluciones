package com.cice.gestion.devoluciones.service.converter;

import com.cice.gestion.devoluciones.data.entity.DevolucionEntity;
import com.cice.gestion.devoluciones.web.dto.DevolucionDTO;
import org.springframework.stereotype.Component;

@Component
public class DevolucionConverter {

    public DevolucionDTO DevolucionEntityToDTO(DevolucionEntity devolucionEntity){
        DevolucionDTO devolucionDTO = null;

        devolucionDTO = new DevolucionDTO(
                devolucionEntity.getId(),
                devolucionEntity.getIdPedido(),
                devolucionEntity.getIdProducto(),
                devolucionEntity.getCantidad(),
                devolucionEntity.getFechaAlta(),
                devolucionEntity.getEstado(),
                devolucionEntity.getFechaFin()
        );

        return devolucionDTO;
    }


    public DevolucionEntity DevolucionDTOToEntity(DevolucionDTO devolucionDTO){
        DevolucionEntity devolucionEntity = null;

        devolucionEntity = new DevolucionEntity(
                devolucionDTO.getId(),
                devolucionDTO.getIdPedido(),
                devolucionDTO.getIdProducto(),
                devolucionDTO.getCantidad(),
                devolucionDTO.getFechaAlta(),
                devolucionDTO.getEstado(),
                devolucionDTO.getFechaFin()
        );

        return devolucionEntity;
    }

    public void DTOVsEntity(DevolucionDTO devolucionDTO, DevolucionEntity devolucionEntity){
        if(devolucionDTO.getIdPedido() == null && !devolucionDTO.getIdPedido().equals(devolucionEntity.getIdPedido())){
            devolucionEntity.setIdPedido(devolucionDTO.getIdPedido());
        }
        if(devolucionDTO.getIdProducto() == null && !devolucionDTO.getIdProducto().equals(devolucionEntity.getIdProducto())){
            devolucionEntity.setIdProducto(devolucionDTO.getIdProducto());
        }
        if(devolucionDTO.getCantidad() == null && !devolucionDTO.getCantidad().equals(devolucionEntity.getCantidad())){
            devolucionEntity.setCantidad(devolucionDTO.getCantidad());
        }
        if(devolucionDTO.getFechaAlta() == null && !devolucionDTO.getFechaAlta().equals(devolucionEntity.getFechaAlta())){
            devolucionEntity.setFechaAlta(devolucionDTO.getFechaAlta());
        }
        if(devolucionDTO.getEstado() == null && !devolucionDTO.getEstado().equals(devolucionEntity.getEstado())){
            devolucionEntity.setEstado(devolucionDTO.getEstado());
        }
        if(devolucionDTO.getFechaFin() == null && !devolucionDTO.getFechaFin().equals(devolucionEntity.getFechaFin())){
            devolucionEntity.setFechaFin(devolucionDTO.getFechaFin());
        }
    }

}
