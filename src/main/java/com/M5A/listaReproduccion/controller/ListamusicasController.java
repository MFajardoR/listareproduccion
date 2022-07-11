/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.M5A.listaReproduccion.controller;

import com.M5A.listaReproduccion.model.Listamusicas;
import com.M5A.listaReproduccion.service.ListaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marco
 */
@RestController
@RequestMapping("/api/listamusica")
public class ListamusicasController {

    @Autowired
    ListaService listaService;

    @PostMapping("/crear")
    public ResponseEntity<Listamusicas> Crear(@RequestBody Listamusicas lst) {
        //String listamusicas = new Listamusicas().getNombre();

        if (lst.getNombre() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else if (lst.getNombre().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(listaService.Crear(lst), HttpStatus.CREATED);
        }
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Listamusicas>> Listar() {

        return new ResponseEntity<>(listaService.FindByAll(), HttpStatus.OK);
    }

    @GetMapping("/buscarNombre/{nombre}")
    public ResponseEntity<Listamusicas> BuscarNombre(@PathVariable String nombre) {

        List<Listamusicas> lis = listaService.FindByAll();
        for (Listamusicas li : lis) {
            String name = li.getNombre();
            if (name.equals(nombre)) {
                return new ResponseEntity<>(listaService.BuscarNombre(nombre), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/actualizar/{nombre}")
    public ResponseEntity<Listamusicas> Actualizar(@PathVariable String nombre, @RequestBody Listamusicas lst) {
        Listamusicas list = Buscarlist(nombre);

        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else if (list.getNombre().equals(lst.getNombre())) {
            list.setIdlistamusicas(list.getIdlistamusicas());
            list.setNombre(list.getNombre());
            list.setDescripcion(lst.getDescripcion());
            return new ResponseEntity<>(listaService.Crear(list), HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

    }

    @DeleteMapping("/eliminar/{nombre}")
    public ResponseEntity<Listamusicas> Eliminar(@PathVariable String nombre) {
        Listamusicas list = Buscarlist(nombre);

        if (list == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
        listaService.Eliminar(nombre);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        
    }

    public Listamusicas Buscarlist(String nombre) {
        return listaService.BuscarNombre(nombre);
    }
}
