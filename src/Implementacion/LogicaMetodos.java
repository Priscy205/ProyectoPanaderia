package Implementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Dominio.Panes;
import Interface.Metodos;
import Interface.Metodos2;

public class LogicaMetodos implements Metodos, Metodos2{
	
	Scanner lectura = null;
	
	private List<Panes> lista = new ArrayList<Panes>();
	
	//Validar --- que el nombre del pan no se repita, guardamos
	@Override
	public void guardar(Panes pan) {
		// TODO Auto-generated method stub
		
		//1--Recorrer los registros de la lista
		//2--Para despues comparar cada registro
		//3--Bandera
		
		boolean bandera = false;
		for (Panes p: lista) {
			if(p.getNombre().equals(pan.getNombre())) {
				//ese pan ya existe
				System.out.println("Ese nombre de pan ya existe no se puede guardar");
				bandera = true;
				break;
			}
		}
		if(bandera ==false) {
			lista.add(pan);
			System.out.println("Se guardo con exito");
		}
	}

	@Override
	public List<Panes> mostrar() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Panes buscarXindice(int indice) {
		// TODO Auto-generated method stub
		return lista.get(indice);
	}
	
	//---Excepcion de errores
	@Override
	public void editar(int indice, Panes pan) {
		// TODO Auto-generated method stub
		lista.set(indice, pan);
	}
	
	//---Excepcion de errores
	@Override
	public void eliminar(int indice) {
		// TODO Auto-generated method stub
		lista.remove(indice);
	}

	@Override
	public Panes buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		for(int i=0; i<lista.size();i++) {
			Panes pan =lista.get(i);
			if(pan.getNombre().equals(nombre)) {
				System.out.println("Se encontro: "+pan);
				return pan;
			}
		}
		System.out.println("No existe registro de pan con este nombre ");
		return null;
	}

	@Override
	public void buscarPorSabor(String sabor) {
		// TODO Auto-generated method stub
		boolean bandera1 = false;
			for(int i=0; i<lista.size();i++) {
				Panes pan =lista.get(i);
				if(pan.getSabor().equals(sabor)) {
					System.out.println("Se encontro el registro: "+pan);
					bandera1 = true;
				}
			}
			if (bandera1 == false) 
				System.out.println("No existe registro de pan con este sabor");
	}

	@Override
	public float calcularDineroInvertido() {
		// TODO Auto-generated method stub
		float total = 0;
		for(Panes p: lista) {
			total += p.getPrecio()*p.getExistencia();
		}
		return total;
	}

	@Override
	public void editarBuscandoNombre(String nombre, Panes pan) {
		// TODO Auto-generated method stub
		for(int i=0; i<lista.size();i++) {
			if(lista.get(i).getNombre().equals(nombre)) {
			lista.set(i, pan);
			break;
			}
		}
	}

	@Override
	public void eliminarBuscandoNombre(String nombre) {
		// TODO Auto-generated method stub
		boolean bandera3 = false;
		for(int i=0; i<lista.size(); i++) {
			if(nombre.equals(lista.get(i).getNombre())) {
				lista.remove(i);
				bandera3 = true;
				break;
			}
		}
		if(bandera3 == false)
			System.out.println("No existe pan con el nombre que deseas eliminar");
	}

	

}
