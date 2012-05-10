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
			iD=leerNumeroDeJugadores();								//Llama a la funcion que debuelbe el numero de jugadores, optamos hacerlo de esta manera para que el codigo sea mas bisible
		}while(iD==0);												//Condicion del while
		
		crearJugadores(iD);									//Llama a la funcion crear jugadores, se le pasa el total de jugadores que quieren jugar
		turno =  new Double(Math.random() * iD).intValue();	//Se realiza un random para indicar a quien le toca jugar primero
		//TODO fijarse en los posibles balores para indice 0 y errores de que no de el random todos los posibles jugadores
		
		//#######################################################
		//Empieza el juego
		//#######################################################
		while(!juegoGanado){
			Jugador jugador =  ListaJugadores.getListaJugadores().obtenerJugador(turno);	//Se obtiene el jugador en base al turno
			boolean accionOk=false;//Se indica que no se ha realizado ninguna accion
			
			do{
				int opcion=leerOpcion();//Se le la opcion que desea realizar el jugador
				
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
						
						
						if(jugador.jugar(jugada)){juegoGanado=true;} 		//Comprueba que haya ganado y se sale del bucle
						accionOk=true;											//Indice que se ha realizado una accion
						break;
						
					case 3://Caso 3-Cambiar mano
						jugador.cambiarMano();
						System.out.println("Cambiaste de mano");
						accionOk=true;
						break;

					default:
						accionOk=false;
						break;
				}
			}while(accionOk); 
		
			turno++;
			if(turno>iD){
				turno=1;
			}
			
		}
	}
	//TODO Gestor de mensajes clase
	/*oK*/private static int leerOpcion(){							//La funcion se realiza para que el codigo se bisual
		Scanner sc = new Scanner(System.in);		//Se crea un lector
		System.out.println("Elige la opcion");		//Mensaje aclarativo
		System.out.println("1-Pasar");				//Mensaje aclarativo
		System.out.println("2-Jugar");				//Mensaje aclarativo
		System.out.println("3-Cambiar mano");		//Mensaje aclarativo
		
		return sc.nextInt();						//Se obtiene la opcion
	}
			
	/*ok*/private static void crearJugadores(byte pTotalJugadores){
		
		for( int i = 0; i < pTotalJugadores ; i++){							//Un for para crear el total de jugadores
			String nombre;										
			do{																//Mientras el nombre sea bacio
				System.out.println("Elige el nombre ");						//Mensaje aclaratorio
				nombre = leerNombreDeJugador();								//Leer el nombre de jugador
			}while(nombre.equals("") || nombre.trim().equals(""));
			
			Jugador jugador = new Jugador(nombre,i);						//Se crea un jugador
			
			ListaJugadores.getListaJugadores().anadirJugador(jugador);		//Se añade a la lista de jugadores
		}; 
	}
	
	//TODO quiza tray catch probar
	/*REV*/private static byte leerNumeroDeJugadores(){
		Scanner sc = new Scanner(System.in);			//Se crea el lector
		return (byte) sc.nextInt();					//Se obtiene el numero de jugadores y se retorna
	}
	
	/*REV*/private static String leerNombreDeJugador(){
		Scanner sc = new Scanner(System.in);			//Se crea el lector
		return sc.next();								//Se obtiene el nombre y se retorna
		
		
	}
	
}
