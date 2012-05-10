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
    
    public void ponerFicha()
    {
    	//Falta que pasen fichas de jugada y sus coord para comprobar
    	//cada casilla a usar y en caso de libre poner ficha (Casilla.libre=False)
    	//y una vez hecho esto pasar siguiente ficha a colocar, sino realizar de 
    	//nuevo la jugada.
    	
    	  if (casillas[i][j].libre()==true)
    	  {
    		  casillas[i][j].setLibre(False);
    	  }
    	  else
    	  {
    		  System.out.println("Casilla ocupada");
    	  }
    		  
    }
    
    public void resetearTablero()
    {
    	//setTablero() = new Tablero();
    	tablero = new Tablero();
    }
    
   
}