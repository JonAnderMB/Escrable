package Juego;

import java.util.ArrayList;

import javax.swing.JFileChooser;

public class Diccionario {
	
	private static Diccionario diccionario = new Diccionario();
	private ArrayList<String> palabras = new ArrayList<String>();
	
	private Diccionario(){
		
		System.out.println("Inserte el numero de jugadores");
		JFileChooser hh = new JFileChooser();
		hh.showOpenDialog(hh);
		String openRoute = hh.getSelectedFile().getAbsolutePath().toString();
		hh.showSaveDialog(hh);
		String saveRoute = hh.getSelectedFile().getAbsolutePath().toString();
		
		this.reset(openRoute, saveRoute);
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
    
    public void reset(String pOpenRoute, String pSaveRoute){
		Lector lec = new Lector(pOpenRoute,pSaveRoute);
		this.setPalabras(lec.getPalabras());
    }
	
}
