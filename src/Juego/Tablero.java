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
						casillas[i][j]= new Casilla();			//Tira error.
					}
				}
			}
		}

		public static boolean comprobarCordenada(byte x, byte y){return false;}

	
    
    public boolean comprobarJugada(Ficha letras)
    {
    	//Me pasan la palabra a colocar y se contrasta con el diccionario.
    	
    	return false;
    }
   
    public void realizarJugada()
    {    	
    	//If comprobarJugada correcto --> loop ponerFicha()

    	ListaFichas listaFichas;
    	if (this.comprobarJugada()==true)									//Tira error.
    	{
    		for (int a=0; a < listaFichas.utilizarFichas().size; a++)		//Tira error.
    		{
    			ponerFicha(x, y);											//Tira error.
    		}
    	}
    	//Else --> repetir la jugada.
    	else
    	{
    		//Repetir jugada¿?¿?
    	}

    }
    
    //No se que mierda es esto, me lo pasó mikel, echadle un ojo.
    public boolean utilizarFichas(Jugada pJugada)
    {
      	
	Jugada jugada = pJugada;
    	
    	for (int x=1; x<=jugada.getLetras().length; x++)
    	{
    		Ficha fichaaponer = jugada.getLetras(x);
    		ponerFicha(jugada.getI(), jugada.getF());
           	
    		if (jugada.getHV()==true) 
    		{
    			jugada.setI((byte)(jugada.getI()+1));
    		}
    		else
    		{
    			jugada.setF((byte)(jugada.getF()+1));;
            }
    	}
    }
    // Hasta aquí. 	 
     
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