/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springoauth2.repository;

import com.mycompany.springoauth2.model.Usuario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author matia
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    
    @Override
    public List<Usuario> findAll();
    
    public Usuario findByNombre(String nombre);
    
}
