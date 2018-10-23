/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springoauth2.controller;

import com.mycompany.springoauth2.model.Usuario;
import com.mycompany.springoauth2.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author matia
 */
@RestController
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private PasswordEncoder userPasswordEncoder;
    
    /**
     * Ruta asegurada con acceso 'read'
     * 
     * @return 
     */
    @PreAuthorize("#oauth2.hasScope('read')")
    @GetMapping("usuario")
    public List<Usuario> index() {
        return this.usuarioRepository.findAll();
    }
    
    /**
     * Ruta no asegurada
     * 
     * @param usuario
     * @return 
     */
    @PreAuthorize("true")
    @PostMapping("usuario")
    public Long store(@RequestBody Usuario usuario) {
        // Encriptar contraseña
        usuario.setContrasena( this.userPasswordEncoder.encode(usuario.getContrasena()) );
        
        // Guardar usuario
        return this.usuarioRepository.save(usuario).getId();
    }
    
}
