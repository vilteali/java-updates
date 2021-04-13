package modelo;

public class Persona1 {

	private Integer id;
	private String nombre;
	private Double edad;
	private Double altura;
	private Double peso;

	public Persona1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Persona1(Integer id, String nombre, Double edad, Double altura,
			Double peso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.altura = altura;
		this.peso = peso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getEdad() {
		return edad;
	}

	public void setEdad(Double edad) {
		this.edad = edad;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad
				+ ", altura=" + altura + ", peso=" + peso + "]";
	}

}
