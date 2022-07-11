/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.M5A.listaReproduccion.controller;

import com.M5A.listaReproduccion.model.Cancion;
import com.M5A.listaReproduccion.service.CancionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marco
 */
@RestController
@RequestMapping("/api/cancion")
public class CancionController {
     @Autowired
     CancionService cancionService;
     
     @PostMapping("/crear")
    public ResponseEntity<Cancion> Crear(@RequestBody Cancion c) {

        return new ResponseEntity<>(cancionService.Crear(c), HttpStatus.OK);
    }
    
    @GetMapping("/lista")
    public ResponseEntity<List<Cancion>> Listar(){
        
        return new ResponseEntity<>(cancionService.FindByAll(), HttpStatus.OK);
    }
}
