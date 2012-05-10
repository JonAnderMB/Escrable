package Juego;

public class Jugada {
	private byte x;
	private byte y;
	private Ficha[] letras;
	private boolean hV; //true = horizontal false = vertical
	
	public Jugada(byte pI, byte pF, Ficha[] pLetras, boolean pHV){
		this.x=pI;
		this.y=pF;
		this.letras=pLetras;
		this.hV=pHV;
	}
	
	public byte getX(){
		return this.x;
	}
	
	public byte getY(){
		return this.y;
	}
	
	public boolean getHV(){
		return this.hV;
	}
	
	public Ficha[] getletras(){
		return this.letras;
	}
}
