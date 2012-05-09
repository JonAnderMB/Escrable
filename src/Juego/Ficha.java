package Juego;

import java.util.ArrayList;

public class Ficha {
	private char letra;
	private int puntos;
	
	public Ficha (char pLetra,int pPuntos){
		this.letra=pLetra;
		this.puntos=pPuntos;
	}
	
	public char getLetra(){
		return this.letra;
	}
	
	public int getPuntos(){
		return this.puntos;
	}
	
	public void imprimirLetra(){
		System.out.print(this.getLetra());
	}
	
}