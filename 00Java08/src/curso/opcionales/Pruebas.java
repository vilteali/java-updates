package curso.opcionales;

import java.util.Optional;

import modelo.Direccion;
import modelo.Director;
import modelo.Pelicula;
import negocio.GestorPeliculas;

public class Pruebas {

	public static void main(String[] args) {
		
		GestorPeliculas gp = new GestorPeliculas();
		
		Pelicula p1 = gp.buscar(3);
		System.out.println(p1.getTitulo());
		Pelicula p2 = gp.buscar(20000);
		//System.out.println(p2.getTitulo());
		
		//Con optional mínimo avisamos al que invoca el método de que puede recibir un null
		Optional<Pelicula> p3 = gp.buscarOptional(3);
		if(p3.isPresent()){
			System.out.println(p3.get().getTitulo());
		}
		
		Optional<Pelicula> p4 = gp.buscarOptional(3);
		if(p4.isPresent()){
			System.out.println(p4.get().getDirector().get().getNombre());
		}

		//Aun teniendo un optional podemos hacerlo fallar:
		//Pelicula p4bis = gp.buscarOptional(20000).get();
		//System.out.println(p4bis.getTitulo());
		
		//
		Optional<Pelicula> pOp = gp.buscarOptional(1);
		if( pOp.isPresent() ){
			Optional<Director> dOp = pOp.get().getDirector();
			if( dOp.isPresent() ){
				Optional<Direccion> dirOp = dOp.get().getDireccion();
				if(dirOp.isPresent()){
					System.out.println(dirOp.get().getCiudad());
				}
			}
		}
		
		//ifPresent
		pOp.ifPresent( p -> System.out.println(p.getTitulo()) );
		gp.buscarOptional(11).ifPresent( p -> System.out.println("HOLA " + p.getTitulo()) );
		
		//flatMap y map
		Optional<String> ciudadOp = pOp.
			flatMap( p -> p.getDirector() ).
				flatMap( d -> d.getDireccion() ).
					map( dir -> dir.getCiudad() );
		
		if( ciudadOp.isPresent() ){
			System.out.println(ciudadOp.get());
		}
		
		//OrElse
		String ciudad = pOp.
			flatMap( p -> p.getDirector() ).
				flatMap( d -> d.getDireccion() ).
					map( dir -> dir.getCiudad() ).
						orElse("No hay");
		System.out.println(ciudad);
		
		//OrElse
		String ciudad2 = pOp.
			flatMap( p -> p.getDirector() ).
				flatMap( d -> d.getDireccion() ).
					map( dir -> dir.getCiudad() ).
						filter( c -> c.equals("Santa Pola" )).
							orElse("No es Santa Pola");
		System.out.println(ciudad2);
		
	}
	
}
