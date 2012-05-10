package Juego;

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
		//Se le pasa la jugada y en funcion de ella se compruena si ha ganado o no y se actualiza el tablero
	}
	
	public Jugada hacerJugada(){
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



