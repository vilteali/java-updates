package java15.sealedej;

import java.lang.constant.ClassDesc;

public class Principal {

	public static void main(String[] args) {

		System.out.println("SEALED: " + Shape.class.isSealed());
		System.out.println("PERMITTED SUBCLASSES: " + Shape.class.permittedSubclasses());
		ClassDesc[] lista= Shape.class.permittedSubclasses();
		for (int i = 0; i < lista.length; i++) {
			System.out.println(lista[i]);
		}
		System.out.println("SEALED: " + Circle.class.isSealed());
		System.out.println("HIDDEN: " + Circle.class.isHidden());
	}

}
