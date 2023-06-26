package link.softbond.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import link.softbond.entities.Usuario;
import link.softbond.repositorios.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;
    @PostMapping
	public Usuario registroUsuario(@RequestBody Usuario usuario) {
    	usuario.setEstado("I"); //I -> inactivo
		usuarioRepository.save(usuario);
		return usuario;
	}
}
