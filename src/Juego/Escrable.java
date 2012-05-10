package Juego;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
//http://download.eclipse.org/tools/gef/updates/releases
public class Escrable {
	
	public static void main(String[] args) {
		//#######################################################
		//Inicializacion del juego
		//#######################################################
		byte iD=0;								//Total de jugadores, servira para indicar el id de cada jugador
		boolean juegoGanado=false;				//Bariable que indica si el juego ha finalizado
		int turno=0;							//Bariable que indica a que jugador le toca el turno, se usara para acceder al una posicion del array de jugadores
		Scanner sc = new Scanner(System.in);	//Se genera una clase de lector

		System.out.println("Bienbenido al Escrabel de Lyf"); //Mensaje de bienbenida
		
		do{															//Do while que hace que mientras el numero total de jugadores sea 0 pregunte cuantos jugadores hay que quieran jugar
			System.out.println("Inserte el numero de jugadores");	//Mensaje aclaratorio
			iD=Gestor.leerNumeroDeJugadores();								//Llama a la funcion que debuelbe el numero de jugadores, optamos hacerlo de esta manera para que el codigo sea mas bisible
		}while(iD==0);												//Condicion del while
		
		Gestor.crearJugadores(iD);									//Llama a la funcion crear jugadores, se le pasa el total de jugadores que quieren jugar
		turno =  new Double(Math.random() * iD).intValue();	//Se realiza un random para indicar a quien le toca jugar primero
		//TODO fijarse en los posibles balores para indice 0 y errores de que no de el random todos los posibles jugadores
		
		//#######################################################
		//Empieza el juego
		//#######################################################
		while(!juegoGanado){
			Jugador jugador =  ListaJugadores.getListaJugadores().obtenerJugador(turno);	//Se obtiene el jugador en base al turno
			boolean accionOk=false;//Se indica que no se ha realizado ninguna accion
			
			do{
				int opcion=Gestor.leerOpcion();//Se le la opcion que desea realizar el jugador
				
				switch (opcion) {						//Se hace una accion en funcion de la opcion
					
					case 1:								//Caso 1-Pasar
						jugador.pasar();					//Se llama a la funcion pasar, y se le pasa el jugador por parametro, los parametros en java son pro referencia asi que no hay que liarse con devolberlo despues
						accionOk=true;					//Se indica que una accion se realizo y que luego podra cambiar de turno
						break;							//Se sale de la primera opcion
					
					case 2:														//Caso 2-Jugar
						boolean quererJugada=false;							//Indica 
						Jugada jugada;
						do{
							jugada=jugador.hacerJugada();
							System.out.println("Quieres hacer la jugada");
						}while(!quererJugada);
						
						
						if(jugador.jugar(jugada)){juegoGanado=true;} 			//Comprueba que haya ganado y se sale del bucle
						accionOk=true;											//Indice que se ha realizado una accion
						break;
						
					case 3:														//Caso 3-Cambiar mano
						if(!jugador.cambiarMano()){								//Cambiar la mano del jugador
							System.out.println("No puedes cambiar de mano");	//Mensaje aclaratorio
							accionOk=false;										//Se indica que no se ha realizado la accion
						}else{					
							System.out.println("Cambiaste de mano");			//Mensaje aclaratorio
							accionOk=true;										//Se indica que se realizo una accion
						}						
						break;
						
					default:				//En el caso de que la opcion obtenida no este entre las elegidas
						accionOk=false;		//Se indica que no se ha realizado una accion
						break;
				}
			}while(accionOk); 
		
			turno++;				//Se pasa el turno
			if(turno>iD){			//En el caso de que el turno no sea para ningun id acutal baja al id 0
				turno=0;
			}
			
		}
	}
	
	
	
	
	
}
