/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.M5A.listaReproduccion.repository;

import com.M5A.listaReproduccion.model.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author marco
 */
public interface CancionRepository extends JpaRepository<Cancion, Long> {
    
}
