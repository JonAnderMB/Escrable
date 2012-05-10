package Juego;

import java.util.Scanner;

public class Mensajes {

	/*oK*/private static Mensajes INSTANCE = new Mensajes();
	
	/*oK*/private Mensajes(){}
	
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
	
	/*oK*/public static Mensajes getInstance(){
		return INSTANCE;
	}

}
