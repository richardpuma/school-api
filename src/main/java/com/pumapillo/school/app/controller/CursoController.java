package com.pumapillo.school.app.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pumapillo.school.app.entity.Curso;
import com.pumapillo.school.app.service.ICursoService;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

	@Autowired
	private ICursoService serviceCurso;

	@GetMapping("/listar")
	public List<Curso> buscarTodos() {
		String hola = "hola";
		return serviceCurso.buscarTodos();
	}

	@GetMapping("/ver/{id}")
	public Curso detalle(@PathVariable Long id) {

		return serviceCurso.detalle(Long.valueOf(id));
	}

	@PostMapping("/nuevo")
	public ResponseEntity<Object> guardarCurso(@RequestBody Curso curso) {
		Curso cursoGuardado = serviceCurso.guardar(curso);
		
		URI builder = ServletUriComponentsBuilder.fromPath("http:localhost:8080/api/curso/ver/"+cursoGuardado.getId()).build().toUri(); 
		
		//URI localtion = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(cursoGuardado.getId()).toUri();
		
		return ResponseEntity.created(builder).build();
		
		//return cursoGuardado;
	}
}
