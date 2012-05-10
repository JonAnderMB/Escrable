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
					case 2:								//Caso 2-Jugar
						boolean quereJugada=false;
						Jugada jugada;
						do{
							jugada=hacerJugada();
							System.out.println("Quieres hacer la jugada");
						}while(quererJugada);
						
						
						if(jugador.hacerJugada(jugada)){juegoGanado=true;} 				//Comprueba que haya ganado y se sale del bucle
						accionOk=true;													//Indice que se ha realizado una accion
						break;
						
					case 3://Cambiar mano
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
	
	/*oK*/private static int leerOpcion(){							//La funcion se realiza para que el codigo se bisual
		Scanner sc = new Scanner(System.in);		//Se crea un lector
		System.out.println("Elige la opcion");		//Mensaje aclarativo
		System.out.println("1-Pasar");				//Mensaje aclarativo
		System.out.println("2-Jugar");				//Mensaje aclarativo
		System.out.println("3-Cambiar mano");		//Mensaje aclarativo
		
		return sc.nextInt();						//Se obtiene la opcion
	}
	
	/*oK*/private static byte leerCordenada(String msg){				//La funcion se realiza dado que esta parte del codigo es redundante y solo cambia el mensaje
		Scanner sc = new Scanner(System.in);							//Se crea un lector
		byte coordenada;												//Se crea la variable coordenada
		
		do{																//While para que la coordenada este en el rango correcto
			System.out.println("Introduce la cordenada x de 0 a 14");	//Se imprime mensaje aclaratorio
			coordenada = (byte) sc.nextInt();							//Se obtiene la coordenada del usuario
		}while(coordenada<0 && coordenada>15);							//Condicion del while que la cordenada este entre 0 y 14 incluidos
		
		return coordenada;												//Se retorna la coordenada
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
	
	/*oK*/private static void imprimirFichas(Jugador pJugador){		//Se imprimen las fichas del jugador
		System.out.println("Estas son las fichas de las que dispone");	//Mensaje aclaratorio
		System.out.println("Mano: ");									//Mensaje aclaratorio
		pJugador.getListaFichas().imprimirMano();						//Se llama la funcion que imprime el valor de las fichas de la mano
	}
	
	/*oK*/private static void pasar(Jugador pJugador){				//Funcion para realizar el acto de pasar
		int totalFichas = pJugador.getListaFichas().getTotalFichas();	//Obtiene el total de fichas del saco
		if(totalFichas==0){												//En el caso de que no tenga fichas en el saco imprime un mensaje en caso de que tenga alguna ficha en el saco imprime otro mensaje diferente
			System.out.println("Has pasado");
		}else{
			System.out.println("Has pasado, aun te quedaban" + totalFichas + " fichas quizas podrias haber cambiado de mano");//TODO comprobar el total de las fichas
		}
	}
	
	private static Jugada hacerJugada(Jugador pJugador){
		Jugada jugada;
		do{														//Bucle mientras la jugada no se pueda hacer
			byte x, y;
			boolean coordenadaOk=false;
			Ficha[] fichasDeJugada = seleccionaFichas(pJugador);
			do{													//Mientras la coodenada no este libre falla
				x=leerCordenada("Introduce la cordenada X");	//Se obtienen las coordenada x
				y=leerCordenada("Introduce la cordenada y");	//Se obtiene la coordenada y
				if(Tablero.comprobarCordenada(x, y)){			//Comprueba que la coordenada este libre
					coordenadaOk=true;
				}else{
					System.out.println("La cordenada ya esta ocupada elige otra");
				}
			}while(!coordenadaOk);
			boolean hV=leerHorizontalidad();						//Se indica la horizontalidad de las fichas
			jugada = new Jugada(x,y,fichasDeJugada,hV);				//Se crea la jugada
		}while(!Tablero.comprobarJugada(jugada));
		
		return jugada;
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
		
	private static void crearJugadores(byte pJugadores){
		
		ArrayList<Jugador> jugadores= new ArrayList<Jugador>();
		int i;
		for( i = 0; i <= pJugadores ; i++){
			String nombre;
			do{
				System.out.println("Elige el nombre ");
				nombre = leerNombreDeJugador();
			}while(nombre.equals(""));
			
			Jugador h = new Jugador(nombre,i+1);
			
			jugadores.add(h);
		}; 
	}
	
	private static byte leerNumeroDeJugadores(){
		byte numeroDeJugadores;
		try {
			numeroDeJugadores = (byte) System.in.read();
		} catch (IOException e) {
			numeroDeJugadores = 0;
		}
		return numeroDeJugadores;
	}
	
	private static String leerNombreDeJugador(){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (isr);
		
		String nombre;
		try {
			nombre = br.readLine();
		} catch (IOException e) {
			nombre = "";
		}
		
		return nombre;
	}
	
}
