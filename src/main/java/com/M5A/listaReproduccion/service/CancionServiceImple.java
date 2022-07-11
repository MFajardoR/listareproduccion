/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.M5A.listaReproduccion.service;

import com.M5A.listaReproduccion.model.Cancion;
import com.M5A.listaReproduccion.repository.CancionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marco
 */
@Service
public class CancionServiceImple implements CancionService {
    @Autowired
    CancionRepository cancionrepository;

    @Override
    public Cancion Crear(Cancion c) {
        return cancionrepository.save(c);
    }

    @Override
    public List<Cancion> FindByAll() {
        return cancionrepository.findAll();
    }
}
