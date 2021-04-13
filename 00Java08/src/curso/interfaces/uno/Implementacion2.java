package curso.interfaces.uno;

public class Implementacion2 implements Interfaz {

	@Override
	public void metodo() {
		System.out.println("Implementacion2:metodo");
	}
		
	public void saludar(){
		//Para invocar con super el c�digo de un metodo default que 
		//estamos sobreescribiendo debemos utilizar el nombre de la interfaz.
		Interfaz.super.saludar();
		System.out.println("HOLA");
	}

}

