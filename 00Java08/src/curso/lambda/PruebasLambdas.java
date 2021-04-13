package curso.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PruebasLambdas {

	public static void main(String[] args) {

		//
		// Interfaces funcionales
		//

		// Con clase interna anonima
		InterfaceDeUnMetodo idum = new InterfaceDeUnMetodo() {

			@Override
			public void metodo() {
				System.out.println("IDUM");
			}
		};

		// Expresion lambda
		InterfaceDeUnMetodo idum2 = () -> System.out.println("IDUM2");

		idum.metodo();
		idum2.metodo();

		// Con clase interna anonima
		InterfaceDeUnParametro idup = new InterfaceDeUnParametro() {

			@Override
			public void metodo(String param) {
				System.out.println(param);
			}
		};

		// Expresion lambda
		InterfaceDeUnParametro idup2 = lacasito -> System.out.println(lacasito);

		idup.metodo("texto1");
		idup2.metodo("texto2");
		
		// Clase interna an�nima
		InterfaceReturn ir = new InterfaceReturn() {

			@Override
			public String metodo() {
				return "Resultado";
			}
		};

		// Expresion lambda
		InterfaceReturn ir2 = () -> "Resultado 2";

		System.out.println(ir.metodo());
		System.out.println(ir2.metodo());
		
		//
		InterfaceDosParametros idp = new InterfaceDosParametros() {

			@Override
			public void metodo(Integer p1, Integer p2) {
				System.out.println(p1 * p2);
			}
		};

		InterfaceDosParametros idp2 = (p1, p2) -> System.out.println(p1 + p2);

		idp.metodo(10, 20);
		idp2.metodo(10, 20);
		
		//
		// Interfaces funcionales en el api de Java8
		//
		System.out.println("===========================================");
		// consumer: public void accept(T t)
		Consumer<String> c = txt -> System.out.println("Consumer:" + txt);
		c.accept("Descanso!");

		// predicate: public boolean test(T t)
		Predicate<String> filtro = txt -> txt.length() > 10;

		boolean rs1 = filtro.test("HOLA");
		boolean rs2 = filtro.test("HOLA RADIOLA");
		System.out.println(rs1 + "," + rs2);

		// function
		// public Tipo1 apply(Tipo2 t)
		Function<String, String> transformacion = txt -> txt.toUpperCase();
		String txt = transformacion.apply("abcdefg");
		System.out.println(txt);

		// supplier
		// public T get()
		Supplier<Double> suplier = () -> {
			System.out.println("Hola caracola");
			return Math.random();
		};
		Double n = suplier.get();
		System.out.println(n);

	}

}

//Interfaces funcionales: que solo tienen un m�todo
interface InterfaceDeUnMetodo {
	public void metodo();
}

interface InterfaceDeUnParametro {
	public void metodo(String param);
}

interface InterfaceReturn {
	public String metodo();
}

interface InterfaceDosParametros {
	public void metodo(Integer p1, Integer p2);
}
