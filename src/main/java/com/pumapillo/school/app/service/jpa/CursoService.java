package com.pumapillo.school.app.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.pumapillo.school.app.entity.Curso;
import com.pumapillo.school.app.exception.CursoNotFoundException;
import com.pumapillo.school.app.repository.CursoRepository;
import com.pumapillo.school.app.service.ICursoService;

@Service
public class CursoService implements ICursoService{

	@Autowired
	private CursoRepository repoCurso;
	
	@Override
	public List<Curso> buscarTodos() {
	
		return repoCurso.findAll();
	}

	@Override
	public Curso guardar(Curso curso) {
		return repoCurso.save(curso);
		
	}

	@Override
	public void actualizar(Curso curso) {
		repoCurso.save(curso);
		
	}

	@Override
	public void eliminar(Long idCurso) {
		repoCurso.deleteById(idCurso);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Curso detalle(Long id) {		
		//return repoCurso.getById(id);		
		  Optional<Curso> optional = repoCurso.findById(id); 
		  if(optional.isEmpty()) {
			  throw new CursoNotFoundException("id-"+id);
			  //throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Usuario con id %d no encontrado ", id));
			  //return null;
		  }
		  return optional.get();		 
	}

	

}
