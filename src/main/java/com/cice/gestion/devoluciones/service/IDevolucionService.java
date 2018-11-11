package com.cice.gestion.devoluciones.service;

import com.cice.gestion.devoluciones.web.dto.DevolucionDTO;

import java.util.List;
import java.util.Optional;

public interface IDevolucionService {

    List<DevolucionDTO> findAllReturns();

    Optional<DevolucionDTO> findAllReturnById(Long id);

    Long insertReturn(DevolucionDTO devolucionDTO);

    DevolucionDTO updateReturn(DevolucionDTO devolucionDTO);

    Long deleteUser(Long id);

}
