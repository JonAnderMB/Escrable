package Juego;

import java.util.ArrayList;

public class ListaJugadores
{
	private static ListaJugadores listaJugadores = new ListaJugadores();
	private ArrayList<Jugador> lista = new ArrayList<Jugador>();

    private ListaJugadores(){}
   	
   	public static ListaJugadores getListaJugadores(){
   		return listaJugadores;
   	}

   	public ArrayList<Jugador> getLista(){
   		return lista;
   	}
  
   	public Jugador obtenerJugador(int pIndiceJugador){
		return getLista().get(pIndiceJugador);
	}

	public void anadirJugador(Jugador pJugador){
   		getListaJugadores().getLista().add(pJugador);	
   	}
 
	public byte getTotalJUgadores(){
		return 0;
	}
	
	//public reset
}
