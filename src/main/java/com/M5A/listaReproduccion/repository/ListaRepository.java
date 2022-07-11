/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.M5A.listaReproduccion.repository;

import com.M5A.listaReproduccion.model.Listamusicas;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author marco
 */
public interface ListaRepository extends JpaRepository<Listamusicas, Long> {
    @Query(value = "Select * from listamusicas list where list.nombre = :nombre", nativeQuery = true)
    public Listamusicas BuscarNombre(String nombre);
    
    @Modifying
     @Transactional
    @Query(value = "Delete from listamusicas where nombre = :nombre ", nativeQuery = true)
    public void Eliminar(String nombre);
}
