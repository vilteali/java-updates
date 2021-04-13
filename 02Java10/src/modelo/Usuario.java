package modelo;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

public class Usuario {

	private String nombre;

	private String rol;

	private int edad;

	private LocalDate fechaNac;

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", rol=" + rol + ", edad=" + edad + ", fechaNac=" + fechaNac + "]";
	}

	public Usuario(String nombre, String rol, LocalDate fechaNac) {
		super();
		this.nombre = nombre;
		this.rol = rol;
		this.fechaNac = fechaNac;
		LocalDate dateNow = LocalDate.now();
		this.edad = Period.between(fechaNac, dateNow).getYears();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}
