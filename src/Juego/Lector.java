package Juego;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class Lector {

	//Atributos
	private String archivoen;
	private String archivosa;
	private ArrayList<String> palabras = new ArrayList<String>();
	
	//Constructor

	public	Lector(String pArchivoen, String pArchivosa){
		this.archivoen=archivoen;
		this.archivosa=archivosa;
		leerArchivo();
	}

	
	private void leerArchivo(){

		File archivoen = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		FileWriter archivosa = null;
		PrintWriter ining = null;
		
		try{
			archivoen = new File(this.archivoen);
			fr = new FileReader(archivoen);
			br = new BufferedReader(fr);
			
			archivosa = new FileWriter(this.archivosa);
			ining = new PrintWriter(archivosa);
			
			String fila;
			while((fila=br.readLine())!=null){
				this.leerLinea(fila);
			}
		 }catch(Exception e){
			e.printStackTrace();
		 }finally{
			try{
					fr.close();
					archivosa.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		 }
 
	}
	
	private void leerLinea(String pLinea){
		ArrayList<String> palabrasDeLinea = new ArrayList<String>();
		
		StringTokenizer tokens=new StringTokenizer(pLinea, " ");
	        while(tokens.hasMoreTokens()){
	            String str=tokens.nextToken();
	            str=escaparPalabra(str);
	            if(this.palabras.indexOf(str)==-1){
	            	this.palabras.add(str);
	            }
	        }
	}
	
	private String escaparPalabra(String pPalabra){
		String line="";
		
		for (int x=0; x < pPalabra.length(); x++){
			char caracter = pPalabra.charAt(x);
			int ascii = (int) caracter;
			if ((((ascii >= 65) && (ascii <= 90)) || ((ascii >= 97) && (ascii <= 122)) || caracter=='ñ' || caracter=='á' || caracter=='é' || caracter=='í'|| caracter=='ó' || caracter=='ú')){
				line += pPalabra.charAt(x);
			}
		}
		
		return line;
	}
	
	public ArrayList<String> getPalabras(){
		return this.palabras;
	}
}
