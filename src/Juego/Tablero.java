package Juego;
public class Tablero {
	
		private static Tablero tablero = new Tablero();
		private Casilla[][] casillas;

		private Tablero(){
			casillas = new Casilla[14][14];
			{ //Hacemos el tablero de 15x15
				for (int i=0; i < 14; i++)
				{
					for (int j=0; j < 14; j++)
					{
						casillas[i][j]= new Casilla;			//Tira error.
					}
				}
			}
		}

		public static boolean comprobarCordenada(byte x, byte y){return false;}

	
    
	private boolean comprobarJugada(Jugada jugada){

		String palabra = jugada.letras.toString();
		boolean palabraencontrada = false;

			for(int x=1; x>=diccionario.length; x++){
				for(int y=1; y>=diccionario.palabra.length;y++){
					if (palabra == diccionario[x].palabra){
						palabraencontrada = true;
					}
				}
			}
		return palabraencontrada; 
	}

	private Jugada realizarJugada (Jugada jugada) {

		if (comprobarJugada(jugada) == true){
			puntuacionJugada(jugada);
			for (int x=1; x>=jugada.letras.length; x++){
				casillas[jugada.Xi][Jugada.Yi] = false;
				casillas[jugada.Xi][jugada.Yi].lcas = jugada.letras[x].getLetra();

				if jugada.hV == true) {
					jugada.xI++;
				}
				else{
					jugada.yI++;
				} 
			}
		
		}
	}

     
	private boolean ponerFicha(int x, int y) 
	{
		if (casillas[x][y].getLibre()==false)
		{
			return casillas[x][y].libre=casillas[x][y].setLibre(true);
		}
		else
		{
			return false;
		}
    }
    
    public void resetearTablero()
    {
    	//setTablero() = new Tablero();
    	tablero = new Tablero();
    }
    
    public int puntuacionJugada(Jugada jugada)
    {
		int punt=0;
		for (int x=1; x<=jugada.getLetras().length; x++)
		{
			punt=punt+jugada.letras[x].getPuntos();
		}
		return punt;
    }
}