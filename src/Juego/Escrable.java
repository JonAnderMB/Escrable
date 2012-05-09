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
		byte iD=0;
		boolean juegoGanado=false;
		int turno=0;
		System.out.println("Bienbenido al Escrabel de Lyf");
		
		do{	
			System.out.println("Inserte el numero de jugadores");
			iD=leerNumeroDeJugadores();
		}while(iD==0);
		
		crearJugadores(iD);
		
		//Empieza El juego
		turno =  new Double(Math.random() * iD).intValue();
		
		while(!juegoGanado){
			Jugador jugador =  ListaJugadores.getListaJugadores().obtenerJugador(turno);	 
			System.out.println("Elige la opcion");
			Scanner sc = new Scanner(System.in);
			int opcion = sc.nextInt();
			boolean accionOk=false;
			do{
				switch (opcion) {
					case 1://Pasar
						int totalFichas = jugador.getListaFichas().getTotalFichas();
						if(totalFichas==0){
							System.out.println("Has pasado");
						}else{
							System.out.println("Has pasado, aun te quedaban" + totalFichas + " fichas quizas podrias haber cambiado de mano");//TODO comprobar el total de las fichas
						}
						accionOk=true;
						break;
					case 2://Jugar
						int xi, yi, xf, yf;
						sc = new Scanner(System.in);
						System.out.println("Estas son las fichas de las que dispone");
						System.out.println("Inserte las posicion X de inicio");
						xi = sc.nextInt();
						System.out.println("Inserte las posicion Y de inicio");
						yi = sc.nextInt();
						System.out.println("Inserte las posicion X de final");
						xf = sc.nextInt();
						System.out.println("Inserte las posicion Y de final");
						yf = sc.nextInt();
						System.out.println("Mano: ");	
						jugador.getListaFichas().imprimirMano();	
						Ficha[] fichasDeJugada = seleccionaFichas(jugador);
						boolean hV;
						byte x=-1;
						byte y=-1;
						do{
							
							do{
								System.out.println("Introduce la cordenada x");
								x= leerCordenada();
							}while(x!=-1);
							
							do{
								System.out.println("Introduce la cordenada y");
								y= leerCordenada();
							}while(y!=-1);
			
							Tablero.comprobarCordenada(x, y);
						
							System.out.println("Inserte 1 para horizontal, en cualquier otro caso sera vertical");
							
							try {
								if(System.in.read()==1){
									hV=true;
								}else{
									hV=false;
								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}while(jugador.hacerJugada(x, y, fichasDeJugada,hV));
						//Comprobar si ha ganado
						break;
					case 3://Cambiar mano
						jugador.cambiarMano();
						System.out.println("cambiar mano");
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
	
	private static byte leerCordenada(){
		int cordenada=-1;
		try {
			cordenada = (byte) System.in.read();
			
			
		} catch (IOException e) {
			cordenada = 0;
		}
		return cordenada;
	}
	
	private static Ficha[] seleccionaFichas(Jugador jugador){
		Ficha[] fichasSeleccionadas = null;
		char caracter='0';
		int i=0;
		System.out.println("Inserte '1' para dejar de seleccionar fichas");
		System.out.println("Inserte la ficha");	
		
		do{
			try {
				caracter = (char) System.in.read();
				if(jugador.getListaFichas().estaLaFichaEnLaMano(caracter)){
					fichasSeleccionadas[i]=jugador.getListaFichas().obtenerFicha(caracter);
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
