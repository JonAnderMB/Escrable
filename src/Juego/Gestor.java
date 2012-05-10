package Juego;

import java.util.Scanner;

public class Gestor {

	/*oK*/private static Gestor INSTANCE = new Gestor();
	
	/*oK*/private Gestor(){}
	
	/*oK*/public static int leerOpcion(){								//La funcion se realiza para que el codigo se bisual
		Scanner sc = new Scanner(System.in);							//Se crea un lector

		System.out.println("Elige la opcion");							//Mensaje aclarativo
		System.out.println("1-Pasar");									//Mensaje aclarativo
		System.out.println("2-Jugar");									//Mensaje aclarativo
		System.out.println("3-Cambiar mano");							//Mensaje aclarativo
		
		return sc.nextInt();											//Se obtiene la opcion
	}
	
	/*oK*/public static byte leerCordenada(String msg){				//La funcion se realiza dado que esta parte del codigo es redundante y solo cambia el mensaje
		Scanner sc = new Scanner(System.in);							//Se crea un lector
		byte coordenada;												//Se crea la variable coordenada
		
		do{																//While para que la coordenada este en el rango correcto
			System.out.println("Introduce la cordenada x de 0 a 14");	//Se imprime mensaje aclaratorio
			coordenada = (byte) sc.nextInt();							//Se obtiene la coordenada del usuario
		}while(coordenada<0 && coordenada>15);							//Condicion del while que la cordenada este entre 0 y 14 incluidos
		
		return coordenada;												//Se retorna la coordenada
	}
	
	/*oK*/public static boolean leerHorizontalidad(){						//La funcion se realiza para que el codigo se bisual
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
	
	/*ok*/public static void crearJugadores(byte pTotalJugadores){
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
		/*REV*/public static byte leerNumeroDeJugadores(){
			Scanner sc = new Scanner(System.in);			//Se crea el lector
			return (byte) sc.nextInt();					//Se obtiene el numero de jugadores y se retorna
		}
		
		/*REV*/private static String leerNombreDeJugador(){
			Scanner sc = new Scanner(System.in);			//Se crea el lector
			return sc.next();								//Se obtiene el nombre y se retorna
			
			
		}
	
	/*oK*/public static Gestor getInstance(){
		return INSTANCE;
	}

}
