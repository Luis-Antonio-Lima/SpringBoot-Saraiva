package br.com.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.domain.Usuario;
import br.com.projeto.repository.UsuarioRepository;
//import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository ur;
	
	@PostMapping("/cadastrar")
	public String cadastrar(@RequestBody Usuario us) {
		ur.save(us);
		return "Usuário Cadastrado";
	}
	
	@GetMapping("/listar")
	public List<Usuario> listar() {
		return ur.findAll();
	}
	
	@GetMapping("/consultar/{id}")
	public Optional<Usuario> consultar(@PathVariable Integer id) {
		return ur.findById(id);
	}
	
	@GetMapping("/consultarusuario/{nomeusuario}")
	public Optional<Usuario> consultarusuario(@PathVariable String nomeusuario) {
		return ur.findByNomeusuario(nomeusuario);
	}
	
	
}
