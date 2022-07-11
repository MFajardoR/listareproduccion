/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.M5A.listaReproduccion.service;

import com.M5A.listaReproduccion.model.Cancion;
import java.util.List;

/**
 *
 * @author marco
 */
public interface CancionService {
    public Cancion Crear (Cancion c);
    
    public List<Cancion> FindByAll();
}
