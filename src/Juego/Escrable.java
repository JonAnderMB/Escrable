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
						pasar(jugador);					//Se llama a la funcion pasar, y se le pasa el jugador por parametro, los parametros en java son pro referencia asi que no hay que liarse con devolberlo despues
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
	
	
	
	/*oK*/private static boolean leerHorizontalidad(){				//La funcion se realiza para que el codigo se bisual
		Scanner sc = new Scanner(System.in);								//Se crea un lector
		boolean hV;															//Se crea la variable que dice que es horizontal o vertical
		
		System.out.println("Inserte 1 para horizontal y 2 para vertical");	//Mensaje aclaratorio
		
			if(sc.nextInt()==1){											//If para establecer el valor de la variable hV
				hV=true;
			}else{
				hV=false;
			}
			
			return hV;														//Se retorna hV
		
	}
	//TODO Pasar a la clase jugador
	/*REV*/private static void imprimirFichas(Jugador pJugador){		//Se imprimen las fichas del jugador
		System.out.println("Estas son las fichas de las que dispone");	//Mensaje aclaratorio
		System.out.println("Mano: ");									//Mensaje aclaratorio
		pJugador.getListaFichas().imprimirMano();						//Se llama la funcion que imprime el valor de las fichas de la mano
	}
	//TODO pasar a la aclase jugasor
	/*REV*/private static void pasar(Jugador pJugador){				//Funcion para realizar el acto de pasar
		int totalFichas = pJugador.getListaFichas().getTotalFichas();	//Obtiene el total de fichas del saco
		if(totalFichas==0){												//En el caso de que no tenga fichas en el saco imprime un mensaje en caso de que tenga alguna ficha en el saco imprime otro mensaje diferente
			System.out.println("Has pasado");
		}else{
			System.out.println("Has pasado, aun te quedaban" + totalFichas + " fichas quizas podrias haber cambiado de mano");//TODO comprobar el total de las fichas
		}
	}
	
	
	
	private static Ficha[] seleccionaFichas(Jugador pJugador){
		Ficha[] fichasSeleccionadas = null;
		char caracter='0';
		int i=0;
		imprimirFichas(pJugador);		//Imprime las fichas que tiene el jugador en la mano
		System.out.println("Inserte '1' para dejar de seleccionar fichas");
		System.out.println("Inserte la ficha");	
		
		do{
			try {
				caracter = (char) System.in.read();
				if(pJugador.getListaFichas().estaLaFichaEnLaMano(caracter)){
					fichasSeleccionadas[i]=pJugador.getListaFichas().obtenerFicha(caracter);
					i++;
				}else{
					System.out.println("Esa fichas no la puedes usar");
				}
			}catch (IOException e){
				e.printStackTrace();
			}
		}while(caracter!='1');
		
		return fichasSeleccionadas;
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
