package curso.interfaces.uno;

public interface Interfaz {

	public static final int DATO = 20;
	
	public abstract void metodo();
	
	//M�todos default
	default void saludar(){
		System.out.println("hola"); //Anatema!
	}
	
	/////////////////////////////////////////////
	
	//M�todos est�ticos
	//Siempre con su implementacion
	public static void metodoEstatico(){
		System.out.println("Método estático");
	}	
	
}