package com.cice.gestion.devoluciones.web.rest;


import com.cice.gestion.devoluciones.service.IDevolucionService;
import com.cice.gestion.devoluciones.web.dto.DevolucionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/devoluciones")
public class DevolucionResource {

    @Autowired
    private IDevolucionService devolucionService;

    /*  Muestra todas las Devoluciones */
    @RequestMapping(method = RequestMethod.GET)
    public List<DevolucionDTO> findAllReturns() {
        List<DevolucionDTO> listDevolucion = null;
        listDevolucion = devolucionService.findAllReturns();
        return listDevolucion;
    }

    /* Muestra una devolucion por id */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public DevolucionDTO findAllReturnById(@PathVariable(name = "id") Long id) {
        DevolucionDTO devolucionDTO = null;
        Optional<DevolucionDTO> devolucion = devolucionService.findAllReturnById(id);
        if(devolucion.isPresent()){
            devolucionDTO = devolucion.get();
        }
        return devolucionDTO;
    }

    /* Inserta una devolucion */
    @RequestMapping(method = RequestMethod.POST)
    public Long insertReturn(@RequestBody DevolucionDTO devolucionDTO){
        Long idDevolucion = null;
        devolucionService.insertReturn(devolucionDTO);
        return idDevolucion;
    }

    /* Actualiza la devolucion  */
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public DevolucionDTO updateReturn(@PathVariable(name="id") Long id, @RequestBody DevolucionDTO devolucionDTO) throws Exception {
        DevolucionDTO devolucion = null;
        if(id == devolucionDTO.getId()){
            devolucion = devolucionService.updateReturn(devolucionDTO);
        } else{
            throw new Exception();
        }
        return devolucion;
    }

    /* Elimina devolucion */
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public Long deleteUser(@PathVariable(name = "id") Long id){
        Long idDevolucion = null;
        idDevolucion = devolucionService.deleteUser(id);
        return idDevolucion;
    }

}
