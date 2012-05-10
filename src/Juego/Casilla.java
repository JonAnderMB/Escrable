package Juego;

public class Casilla {
	   
    private byte puntuacion;			
    boolean libre;
    char lcas;		//Guardamos el char de la Ficha en la Casilla para poder visualizarlo.
    
    public Casilla (byte pPuntuacion, boolean pLibre)
    {
        puntuacion=pPuntuacion;
        libre=pLibre;
    }
   
    public int getPuntuacion()
    {
        return puntuacion;
    }
   
    public boolean getLibre()
    {
        return libre;
    }
    
    public boolean setLibre(boolean pLibre)
    {
    	return this.libre= pLibre;
    }
}
