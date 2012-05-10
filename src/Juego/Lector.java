package Juego;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;

public class Lector {

	//Atributos
	private String archivoEn;										//Indica la ruta donde esta el diccionario
	private ArrayList<String> palabras = new ArrayList<String>();	//El diccionario
	
	//Constructor

	public	Lector(){
		setArchivoEn();	//Se establece la ubicacion del diccionario
		leerArchivo();	//Leer el archivo y obtiene las palabras
	}
	
	private void leerArchivo(){

		File archivoen = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try{
			archivoen = new File(this.archivoEn);
			fr = new FileReader(archivoen);
			br = new BufferedReader(fr);
			String fila;
			while((fila=br.readLine())!=null){
				this.leerLinea(fila);
			}
		 }catch(Exception e){
			e.printStackTrace();
		 }finally{
			try{
					fr.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		 }
 
	}
	
	private void leerLinea(String pLinea){
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
	
	public void setArchivoEn(){
		JFileChooser hh = new JFileChooser();
		hh.showSaveDialog(hh);
		this.archivoEn = hh.getSelectedFile().getAbsolutePath().toString();
	}
	
	public String getArchivoEn(){
		return this.archivoEn;
	}
	
}
