package Juego;

public class Casilla {
	   
    private byte puntuacion;			
    private boolean libre;
    private byte i;
    private byte j;
   
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
    
    public byte getI()
    {
    	return i;
    }
    
    public byte getJ()
    {
    	return j;
    }
}