package com.pumapillo.school.app.service;

import java.util.List;

import com.pumapillo.school.app.entity.Curso;

public interface ICursoService {

	public List<Curso> buscarTodos();
	public Curso detalle(Long id);
	public Curso guardar(Curso curso);
	public void actualizar(Curso curso);
	public void eliminar(Long idCurso);
}
