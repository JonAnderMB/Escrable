// Poner valores de casillas (puntuacion)
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
	              casillas[i][j]=new Casilla(null,false);
	           }
	        }
	    }
	}
	
	public static boolean comprobarCordenada(byte x, byte y){return false;}
    
    public static boolean comprobarJugada(Jugada jugada)
    {
    	//jugada pasa coords.
    	//NECESITO ARRAY DE FICHAS A USAR EN LA JUGADA.
    	
    	return false;
    }
   
    public boolean realizarJugada()
    {
    	return false;
    	//Se realiza lajugada
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
    
    
	 public int puntuacionJugada(Jugada jugada)
	    {
			int punt=0;
			for (int x=1; x<=jugada.getLetras().length; x++)
			{
				punt=punt+jugada.letras[x].getPuntos();
			}
			return punt;
	    }
	
    public void resetearTablero()
    {
    	//setTablero() = new Tablero();
    	tablero = new Tablero();
    }
    
   
}