/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.M5A.listaReproduccion.service;

import com.M5A.listaReproduccion.model.Listamusicas;
import com.M5A.listaReproduccion.repository.ListaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marco
 */
@Service
public class ListaServiceImpl implements ListaService{
    @Autowired
    ListaRepository listarepository;

    @Override
    public Listamusicas Crear(Listamusicas lst) {
        return listarepository.save(lst);
    }

    @Override
    public List<Listamusicas> FindByAll() {
        return listarepository.findAll();
    }

    @Override
    public Listamusicas BuscarNombre(String nombre) {
        return listarepository.BuscarNombre(nombre);
    }

    @Override
    public void Eliminar(String nombre) {
        listarepository.Eliminar(nombre);
    }

    
    
    
    
}
