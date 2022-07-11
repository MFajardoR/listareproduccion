/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.M5A.listaReproduccion.service;

import com.M5A.listaReproduccion.model.Listamusicas;
import java.util.List;

/**
 *
 * @author marco
 */
public interface ListaService {
    
    public Listamusicas Crear (Listamusicas  lst);
    
    public List<Listamusicas> FindByAll();
    
    public Listamusicas BuscarNombre (String nombre);
    
    public void Eliminar(String nombre);
}

