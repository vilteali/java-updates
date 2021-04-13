package curso.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import modelo.Cliente;
import modelo.Factura;
import modelo.FacturaDTO;
import modelo.Persona1;

public class PruebasStreams {

	private static int n;

	public static void main(String[] args) {

		Cliente c1 = new Cliente(1, "C1", "D1", "T1");
		Cliente c2 = new Cliente(2, "C2", "D2", "T2");
		Cliente c3 = new Cliente(3, "C3", "D3", "T3");

		List<Factura> facturas = new LinkedList<>();
		Factura f1 = new Factura(1, "FAC-1", c1, 100D);
		Factura f2 = new Factura(2, "FAC-2", c2, 500D);
		Factura f3 = new Factura(3, "FAC-3", c3, 300D);
		facturas.add(f1);
		facturas.add(f2);
		facturas.add(f3);
		facturas.add(new Factura(4, "FAC-4", c1, 125D));
		facturas.add(new Factura(5, "FAC-5", c2, 200D));
		facturas.add(new Factura(6, "FAC-6", c3, 275D));
		facturas.add(new Factura(7, "FAC-7", c1, 150D));
		facturas.add(new Factura(8, "FAC-8", c2, 200D));
		facturas.add(new Factura(9, "FAC-9", c3, 150D));

		// Recorriendo una coleccion
		System.out.println("====================================================");
		for (int a = 0; a < facturas.size(); a++) {
			// System.out.println(facturas.get(a));
		}

		// Java 5: forEach, que utiliza un iterador
		for (Factura f : facturas) {
			// System.out.println(f);
		}

		// Java 8: nuevo m�todo en la interfaz collection para recorrer colecciones:
		facturas.forEach(f -> System.out.println("---" + f));

		///////////
		// STREAMS//
		///////////

		System.out.println("====================================================");

		Stream<Factura> s1 = facturas.stream();
		long n = s1.count();
		System.out.println("N:" + n);

		// Los streams solo pueden recorrerse una vez:
		//long n2 = s1.count();

		//
		// forEach. Recibe un consumer
		//
		// System.out.println("====================================================");
		//facturas.stream().forEach(f -> System.out.println(f));

		//
		// Filter. recibe un predicate
		//
		System.out.println("====================================================");
		facturas.stream().filter(f -> f.getTotal() < 200).forEach(f -> System.out.println(f));

		// Concatenando filtros

		System.out.println("==========================CONCATENANDO==========================");
		int id = 3;
		facturas.stream().filter(f -> f.getCliente().getId() == id).filter(f -> f.getTotal() < 200)
				.forEach(f -> System.out.println(f));

		// cada objeto que sale del stream recorre toda la cadena antes
		// de que salga el siguiente

		// int id = 3;
		System.out.println("=======================================");
		facturas.stream().filter(fra -> {
			System.out.println("1:" + fra);
			return fra.getTotal() > 130;
		}).filter(fra -> {
			System.out.println("2:" + fra);
			return fra.getCliente().getId() == id;
		}).forEach(fra -> System.out.println("3:" + fra));

		//
		// Iterator: devuelve un iterador
		// Lo utilizamos para controlar nosotros el flujo de objetos que salen del
		// stream

		System.out.println("=======================================");

		Iterator<Factura> it = facturas.stream().filter(fra -> {
			System.out.println("1:" + fra);
			return fra.getTotal() > 130;
		}).iterator();

		// Cada vez que invoquemos 'it.next()' un nuevo elemento saldr� del stream
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		//
		// allMatch:combrueba si todos los elementos cumplen un predicado
		// anyMatch:comprueba si alg�n elemento cumple un predicado
		//

		System.out.println("=====================ALLMATCH // ANYMATCH==================");
		boolean ok1 = facturas.stream().allMatch(fra -> fra.getTotal() > 0);
		System.out.println("Todas las facturas >0:" + ok1);

		boolean ok2 = facturas.stream().anyMatch(fra -> fra.getTotal() > 223200);
		System.out.println("Alguna de las facturas >223200:" + ok2);

		//
		// M�ximo/m�nimo con un comparador
		//

		Comparator<Factura> cf1 = new Comparator<Factura>() {
			public int compare(Factura f1, Factura f2) {
				return f1.getTotal().intValue() - f2.getTotal().intValue();
			}
		};

		// Con una lambda
		// Lo mismo con una expresi�n Lambda
		System.out.println("---- USO COMPARATOR ----");
		Comparator<Factura> cf2 = (fra1, fra2) -> fra1.getTotal().intValue() - fra2.getTotal().intValue();

		// MAX
		Optional<Factura> fMax = facturas.stream().max(cf1);
		if (fMax.isPresent()) {
			System.out.println("Factura maxima:" + fMax.get());
		}

		// MIN
		Optional<Factura> fMin = facturas.stream().min(cf2);
		if (fMin.isPresent()) {
			System.out.println("FMin:" + fMin.get());
		}

		//
		// Distinct
		//

		System.out.println("=======================================");
		List<Factura> facturas2 = new ArrayList<>();
		facturas2.add(f1);
		facturas2.add(f2);
		facturas2.add(f3);
		facturas2.add(f1);
		facturas2.add(f2);
		facturas2.add(f3);

		facturas2.stream().distinct().forEach(fra -> System.out.println(fra));

		//
		// Skip: Se salta cierto numero de elementos del stream
		//

		System.out.println("=======================================");
		facturas.stream().skip(3).forEach(fra -> System.out.println(fra));

		//
		// Map: Para obtener un stream de objetos distintos de los originales
		//

		System.out.println("===================USO DE MAP====================");

		facturas.stream().map(fra -> fra.getCliente()).distinct().forEach(c -> System.out.println(c));

		// idem:
		Stream<Cliente> streamClientes = facturas.stream().map(fra -> fra.getCliente());
		streamClientes.distinct().forEach(conguito -> System.out.println(conguito));

		System.out.println("=======================================");
		List<String> palabras = new ArrayList<String>() {
			{
				this.add("uno");
				this.add("dos");
				this.add("tres");
				this.add("cuatro");
				this.add("cinco");
			}
		};

		// Usando map podemos tambien modificar objetos. No es obligatorio que map
		// devuelva un stream de tipo distinto
		palabras.stream().map(str -> new Factura(str)).forEach(fac -> System.out.println(fac.getCodigo()));

		System.out.println("=======================================");
		facturas.stream().map(fra -> new FacturaDTO(fra.getCodigo(), fra.getCliente().getNombre(), fra.getTotal()))
				.forEach(fDTO -> System.out.println(fDTO));

		//
		// collect: para agregar el resultado
		//
		System.out.println("=======================================");

		// Necesitamos los dtos del ejemplo anterior en una lista
		// Sin colectores:

		List<FacturaDTO> facturasDTO = new ArrayList<>();
		facturas.stream().map(fra -> new FacturaDTO(fra.getCodigo(), fra.getCliente().getNombre(), fra.getTotal()))
				.forEach(fDTO -> facturasDTO.add(fDTO));

		// Mejor con collectors

		List<FacturaDTO> facturasDTO2 = facturas.stream()
				.map(fra -> new FacturaDTO(fra.getCodigo(), fra.getCliente().getNombre(), fra.getTotal()))
				.collect(Collectors.toList());
		System.out.println(facturasDTO2);

		System.out.println("=======================================");
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);

		List<Integer> pares = numeros.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());

		List<Integer> impares = numeros.stream().filter(num -> num % 2 != 0).collect(Collectors.toList());

		pares.forEach(num -> System.out.print(num + ", "));
		System.out.println();
		impares.forEach(num -> System.out.print(num + ", "));
		System.out.println();

		// Obteniendo un mapa.
		// El colector a mapa recibe dos funciones.

		System.out.println("=======================================");

		Map<Integer, Factura> mapa = facturas.stream().collect(Collectors.toMap(f -> f.getId(), f -> f));
		

		// Hasta java 7
		Set<Integer> claves = mapa.keySet();
		for (Integer k : claves) {
			// System.out.println(mapa.get(k)); }
		}

		// En java 8 tenemos el metodo forEach en mapas
		mapa.forEach((k, v) -> System.out.println(k + ":" + v));

		// Agregando con sumatorio y media

		System.out.println("==================STATISTICS=====================");

		Double media = facturas.stream().collect(Collectors.averagingDouble(fra -> fra.getTotal()));
		System.out.println("Media de las facturas:" + media);

		Double media2 = numeros.stream().collect(Collectors.averagingInt(num -> num));
		System.out.println("Media de los n�meros:" + media2);

		IntSummaryStatistics movida = numeros.stream().collect(Collectors.summarizingInt(num -> num));
		DoubleSummaryStatistics movida2 = facturas.stream()
				.collect(Collectors.summarizingDouble(fra -> fra.getTotal()));
		System.out.println("==================MOVIDA=====================");
		System.out.println(movida);
		System.out.println("==================MOVIDA 2=====================");
		System.out.println(movida2);

		//
		// Join (agregacion): obtenemos un string a partir del stream

		String txt = numeros.stream().map(num -> num.toString()).collect(Collectors.joining(", ", "Numeros: ", "."));
		System.out.println(txt);

		// // 'group by' (agregaci�n)
		System.out.println("=======================================");

		// Agrupando facturas por el cliente
		Map<Cliente, List<Factura>> rs = facturas.stream().collect(Collectors.groupingBy(fra -> fra.getCliente()));
		rs.forEach((k, v) -> System.out.println(k.getId() + ":" + v));

		// Agrupando facturas por el id del cliente
		Map<Integer, List<Factura>> rs2 = facturas.stream()
				.collect(Collectors.groupingBy(fra -> fra.getCliente().getId()));
		rs2.forEach((k, v) -> System.out.println(k + ":" + v));

		//
		// Flat map
		//

		System.out.println("=======================================");
		c1.getFacturas().add(new Factura("FAC-100"));
		c1.getFacturas().add(new Factura("FAC-101"));
		c2.getFacturas().add(new Factura("FAC-102"));
		c2.getFacturas().add(new Factura("FAC-103"));
		c2.getFacturas().add(new Factura("FAC-104"));
		c3.getFacturas().add(new Factura("FAC-105"));
		c3.getFacturas().add(new Factura("FAC-106"));
		c3.getFacturas().add(new Factura("FAC-107"));
		c3.getFacturas().add(new Factura("FAC-108"));
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);

		// Sin flat map
		List<Factura> facturitas = new ArrayList<>();
		clientes.stream().map(c -> c.getFacturas()).forEach(lista -> lista.forEach(f -> facturitas.add(f)));
		System.out.println(facturitas);

		// Mejor con flat map:
		List<Factura> facturitas2 = clientes.stream().flatMap(c -> c.getFacturas().stream())
				.collect(Collectors.toList());
		System.out.println(facturitas2);

		//
		// Reduce
		//

		System.out.println("=======================================");
		List<Persona1> personas = new ArrayList<>();
		personas.add(new Persona1(1, "P1", 10d, 1d, 40d));
		personas.add(new Persona1(2, "P2", 20d, 1.2, 50d));
		personas.add(new Persona1(3, "P3", 30d, 1.4, 60d));
		personas.add(new Persona1(4, "P4", 40d, 1.6, 70d));
		personas.add(new Persona1(5, "P5", 50d, 1.8, 80d));
		personas.add(new Persona1(6, "P6", 60d, 2d, 90d));

		int num = 0;

		AtomicInteger contador = new AtomicInteger(1);
		Optional<Persona1> pMedia = personas.stream().reduce((p1, p2) -> {
			p1.setId(0);
			p1.setNombre("Persona media");

			double totEdad = p1.getEdad() * contador.intValue() + p2.getEdad();
			double totAltura = p1.getAltura() * contador.intValue() + p2.getAltura();
			double totPeso = p1.getPeso() * contador.intValue() + p2.getPeso();
			contador.incrementAndGet();
			p1.setEdad(totEdad / contador.intValue());
			p1.setAltura(totAltura / contador.intValue());
			p1.setPeso(totPeso / contador.intValue());

			return p1;

		});

		System.out.println("----- PERSONA MEDIA -----");
		if (pMedia.isPresent())
			System.out.println(pMedia.get());

		Optional<Factura> optF3 = facturas.stream().reduce((fra1, fra2) -> {
			System.out.println(fra1.getId() + "," + fra2.getId());
			if (fra1.getTotal() > fra2.getTotal()) {
				return fra1;
			}
			return fra2;
		});
		System.out.println("------ FACTURA DE MAYOR IMPORTE ------");
		System.out.println(optF3.get()); // La factura con mayor importe //
		// El //
		// resultado es el mismo que si hubieramos usado 'max'

		// // Multi hilo //

		System.out.println("======================================");
		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		System.out.println("-----PARALIZAR:");
		System.out.println(commonPool.getParallelism()); // 3

		Arrays.asList("a1", "a2", "b1", "c2", "c1").parallelStream().filter(s -> true).map(s -> s.toUpperCase())
				.forEach(s -> System.out.format(s + " "));

		System.out.println("================EJEMPLO MULTIHILO - HILOS NOMBRADOS================");
		Arrays.asList("a1", "a2", "b1", "c2", "c1", "a1", "a1", "c1", "a1", "a1").parallelStream().filter(s -> {
			System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
			return s.equals("a1");
		}).map(s -> {
			System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
			return s.toUpperCase();
		}).forEach(s -> System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName()));

		// Metodos colocados al comienzo del stream
		// ...@

		// Metodos 'en el medio'
		// filter : stream
		// distinct : stream
		// skip : stream

		// Metodos colocados al final del stream
		// count : long
		// forEach : void
		// iterator : Iterator
		// allMatch : boolean
		// anyMatch : boolean
		// max : Optional<T>
		// min : Optional<T>
		// map : un nuevo stream
		// collect : depende del collector
		// fatMap : obtiene un stream a partir de una coleccion
		// reduce : obtiene un objeto de la colecci�n incial

	}

}

//Ejemplo de un comparador
class ComparadorFacturas implements Comparator<Factura> {

	@Override
	public int compare(Factura f1, Factura f2) {
		return f1.getTotal().intValue() - f2.getTotal().intValue();
	}

}
