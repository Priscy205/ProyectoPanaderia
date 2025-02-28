package Interface;

import Dominio.Panes;

public interface Metodos2 {
	
	//6
	public Panes buscarPorNombre(String nombre);
	//7
	public void buscarPorSabor(String sabor);
	//8
	public float calcularDineroInvertido();
	//9
	public void editarBuscandoNombre(String nombre, Panes pan);
	//10
	public void eliminarBuscandoNombre(String nombre);
	
}
