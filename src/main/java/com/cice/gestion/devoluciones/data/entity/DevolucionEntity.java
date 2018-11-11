package com.cice.gestion.devoluciones.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="devolucion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DevolucionEntity {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column
    private Long idPedido;

    @Column
    private Long idProducto;

    @Column
    private Long cantidad;

    @Column
    private String fechaAlta;

    @Column
    private String estado;

    @Column
    private String fechaFin;
}
