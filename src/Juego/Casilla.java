package Juego;

public class Casilla {
	   
    private byte puntuacion;			
    boolean libre;
   
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