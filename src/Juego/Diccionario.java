package Juego;

import java.util.ArrayList;

public class Diccionario {
	
	private static Diccionario diccionario = new Diccionario();
	private ArrayList<String> palabras = new ArrayList<String>();
	
	private Diccionario(){
		this.reset();
	}
	
	public boolean buscarPalabra(String pPalabra){
		if(this.palabras.indexOf(pPalabra)==-1){return false;}else{return true;}
	}

    public static Diccionario getDiccionario() {
        return diccionario;
    }
    
    private void setPalabras(ArrayList<String> pPalabras){
    	this.palabras = pPalabras;
    }
    
    public void reset(){
		Lector lec = new Lector();
		this.setPalabras(lec.getPalabras());
    }
	
}
