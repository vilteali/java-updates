package curso.streams;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import modelo.Cliente;
import modelo.Factura;

public class Statis {
	
	public static void main(String[] args) {
		
		Cliente c1 = new Cliente(1, "C1", "D1", "T1");
		Cliente c2 = new Cliente(2, "C2", "D2", "T2");
		Cliente c3 = new Cliente(3, "C3", "D3", "T3");
		
		List<Factura> facturas = new LinkedList<>();
		Factura f1 = new Factura(1, "FAC-1", c1, 100D);
		Factura f2 = new Factura(2, "FAC-2", c2, 200D);
		Factura f3 = new Factura(3, "FAC-3", c3, 300D);
		facturas.add(f1);
		facturas.add(f2);
		facturas.add(f3);
		facturas.add(new Factura(4, "FAC-4", c1, 125D));
		facturas.add(new Factura(5, "FAC-5", c2, 200D));
		facturas.add(new Factura(6, "FAC-6", c3, 275D));
		facturas.add(new Factura(7, "FAC-7", c1, 150D));
		facturas.add(new Factura(8, "FAC-8", c2, 200D));
		facturas.add(new Factura(9, "FAC-9", c3, 250D));
		
		List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);

		IntSummaryStatistics movida = numeros.stream().collect(Collectors.summarizingInt(num -> num));
		DoubleSummaryStatistics movida2 = facturas.stream()
				.collect(Collectors.summarizingDouble(fra -> fra.getTotal()));
		System.out.println(movida);
		System.out.println(movida2);

	}

}
