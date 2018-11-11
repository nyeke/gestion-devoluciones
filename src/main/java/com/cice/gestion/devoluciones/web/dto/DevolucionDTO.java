package com.cice.gestion.devoluciones.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DevolucionDTO {

    private Long id;
    private Long idPedido;
    private Long idProducto;
    private Long cantidad;
    private String fechaAlta;
    private String estado;
    private String fechaFin;
}
