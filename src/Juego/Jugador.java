package Juego;

import java.io.IOException;

public class Jugador {

	private String nombre;
	private int puntuacion;
	private int iD;
	private ListaFichas fichas;
	
	public Jugador(String pNombre, int pID){
		this.nombre=pNombre;
		this.puntuacion=0;
		this.iD=pID;
		this.fichas=new ListaFichas();
	}

	public String getNombre(){
		return this.nombre;
	}
	
	public int getIdJugador(){ // hace falta o no
		return this.iD;
	}
	
	public int getPuntuacion(){
		return this.puntuacion;
	}

	public void setPuntuacion(int pPuntuacion){
		if(pPuntuacion!=-1){
			this.puntuacion += pPuntuacion;
		}
	}
	
	public boolean jugar(Jugada pJugada){
		return false;
		//Se le pasa la jugada y en funcion de ella se compruena si ha ganado o no y se actualiza el tablero
	}
	
	
	
	public Jugada hacerJugada(){
		Jugada jugada;
		do{																//Bucle mientras la jugada no se pueda hacer
			byte x, y;
			boolean coordenadaOk=false;
			Ficha[] fichasDeJugada = seleccionaFichas();
			do{															//Mientras la coodenada no este libre falla
				x=Gestor.leerCordenada("Introduce la cordenada X");	//Se obtienen las coordenada x
				y=Gestor.leerCordenada("Introduce la cordenada y");	//Se obtiene la coordenada y
				if(Tablero.comprobarCordenada(x, y)){					//Comprueba que la coordenada este libre
					coordenadaOk=true;
				}else{
					System.out.println("La cordenada ya esta ocupada elige otra");
				}
			}while(!coordenadaOk);
			boolean hV=Gestor.leerHorizontalidad();						//Se indica la horizontalidad de las fichas
			jugada = new Jugada(x,y,fichasDeJugada,hV);						//Se crea la jugada
		}while(!Tablero.comprobarJugada(jugada));
		
		return jugada;
	}
	
	//TODO en caso de que haya una clase visual que hacer con estas clases de imprimir
	/*rev*/private void imprimirFichas(){								//Se imprimen las fichas del jugador
		System.out.println("Estas son las fichas de las que dispone");	//Mensaje aclaratorio
		System.out.println("Mano: ");									//Mensaje aclaratorio
		getListaFichas().imprimirMano();								//Se llama la funcion que imprime el valor de las fichas de la mano
	}
	
	/*rev*/public void pasar(){								//Funcion para realizar el acto de pasar
		int totalFichas = getListaFichas().getTotalFichas();	//Obtiene el total de fichas del saco
		if(totalFichas==0){										//En el caso de que no tenga fichas en el saco imprime un mensaje en caso de que tenga alguna ficha en el saco imprime otro mensaje diferente
			System.out.println("Has pasado");
		}else{
			System.out.println("Has pasado, aun te quedaban" + totalFichas + " fichas quizas podrias haber cambiado de mano");//TODO comprobar el total de las fichas
		}
	}
	
	private Ficha[] seleccionaFichas(){
		Ficha[] fichasSeleccionadas = null;
		char caracter='0';
		int i=0;
		imprimirFichas();		//Imprime las fichas que tiene el jugador en la mano
		System.out.println("Inserte '1' para dejar de seleccionar fichas");
		System.out.println("Inserte la ficha");	
		
		do{
			try {
				caracter = (char) System.in.read();
				if(this.getListaFichas().estaLaFichaEnLaMano(caracter)){
					fichasSeleccionadas[i]=this.getListaFichas().obtenerFicha(caracter);
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
	
	public boolean actualizarMano(Jugada pJugada){
		this.getListaFichas().utilizarFichas(pJugada);
		
		if(this.getListaFichas().getTotalFichas()==0){
			return true;
		}else{
			return false;
		}
		
	}
	
	public boolean cambiarMano(){
		if(this.getListaFichas().getTotalFichas()!=0){
			this.getListaFichas().cambiarMano();
			return true;
		}else{
			return false;
		}
	}
	
	public ListaFichas getListaFichas(){
		return this.fichas;
		
	}
}



