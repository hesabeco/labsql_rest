package link.softbond.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	 private final JavaMailSender mailSender;

	 @Autowired
	 public UsuarioController(JavaMailSender mailSender) {
     this.mailSender = mailSender;
	 }
	
	 @RequestMapping("/send_mail/{id_user}")
	    public String enviarCorreoAutenticacion(@PathVariable("id_user") Integer id) {
	        Usuario usuario = usuarioRepository.findById(id).get();   
	       String token = "eyJhbGciOiJIUzUxMiJ9.eyJhdXRob3JpdGllcyI6Ilt7XCJhdXRob3JpdHlcIjpcIlVTVUFSSU9cIn1dIiwic3ViIjoiY3Jhbmdhcml0YUBnbWFpbC5jb20iLCJpYXQiOjE2ODc3OTUwNDMsImV4cCI6MTY4Nzc5Njg0M30.OF3xpIXIUIVeG0vpQQ7D0ck0LAvXLY6mA6Jb1l-2vDgImD6AfOULt17cCycIkd5twnMd_vPoX7rDBrJLGCW6vw\r\n";
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(usuario.getEmail());
	        message.setSubject("Autenticación de usuario");
	        message.setText("Hola " + usuario.getNombre() + ",\n\n"
	                + "Por favor, haz clic en el siguiente enlace para autenticar tu cuenta:\n"
	                + "http://ejemplo.com/autenticar?token=" + token + "\n\n"
	                + "Gracias,\n"
	                + "Equipo de la aplicación");
	        mailSender.send(message);
	        return "Correo de autenticación enviado exitosamente";
	    }
	 
    @PostMapping
	public Usuario registroUsuario(@RequestBody Usuario usuario) {
    	usuario.setEstado("I"); //I -> inactivo
		usuarioRepository.save(usuario);
		return usuario;
	}
    
    @DeleteMapping("/{id}")
	public String deleteUsuariobyId(@PathVariable Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (!usuario.isPresent()) {
			return "El usuario con el id " + id + " no existe";
		}
		usuarioRepository.deleteById(id);
		return "Se ha eliminado exitosamente el usuario con el id: " + id;
	}
}
