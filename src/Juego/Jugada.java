package Juego;

public class Jugada {
	private byte i;
	private byte f;
	private Ficha[] letras;
	private boolean hV; //true = horizontal false = vertical
	
	public Jugada(byte pI, byte pF, Ficha[] pLetras, boolean pHV){
		this.i=pI;
		this.f=pF;
		this.letras=pLetras;
		this.hV=pHV;
	}
	
	public byte getI(){
		return this.i;
	}
	
	public byte getF(){
		return this.f;
	}
	
	public Ficha[] getLetras(){
		return this.letras;
	}
}
