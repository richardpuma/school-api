package com.pumapillo.school.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso implements Serializable{
//public class Curso{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "curNombre")
	private String nombre;
	
	@Column(name = "curVacante")
	private int vacante;

	public Curso() {
	}	

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVacante() {
		return vacante;
	}

	public void setVacante(int vacante) {
		this.vacante = vacante;
	}

	@Override
	public String toString() {
		return "Curso [nombre=" + nombre + ", vacante=" + vacante + "]";
	}
	
	
	
	

}
