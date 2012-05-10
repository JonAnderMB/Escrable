package Juego;

import java.util.Random;
import java.util.Vector;
import java.util.Iterator;

public class ListaFichas {
   private Ficha sacodefichas[] = {new Ficha('a',1),new Ficha('a',1),new Ficha('a',1),new Ficha('a',1),new Ficha('a',1),new Ficha('a',1),
           new Ficha('a',1),new Ficha('a',1),new Ficha('a',1),new Ficha('a',1),new Ficha('a',1),new Ficha('a',1),
           new Ficha('b',3),new Ficha('b',3),new Ficha('c',3),new Ficha('c',3),new Ficha('c',3),new Ficha('c',3),
           new Ficha('c',3),new Ficha('d',2),new Ficha('d',2),new Ficha('d',2),new Ficha('d',2),new Ficha('d',2),
           new Ficha('e',1),new Ficha('e',1),new Ficha('e',1),new Ficha('e',1),new Ficha('e',1),new Ficha('e',1),
           new Ficha('e',1),new Ficha('e',1),new Ficha('e',1),new Ficha('e',1),new Ficha('e',1),new Ficha('e',1),
           new Ficha('f',4),new Ficha('g',2),new Ficha('g',2),new Ficha('h',4),new Ficha('h',4),new Ficha('i',1),
           new Ficha('i',1),new Ficha('i',1),new Ficha('i',1),new Ficha('i',1),new Ficha('i',1),new Ficha('j',8),
           new Ficha('l',1),new Ficha('l',1),new Ficha('l',1),new Ficha('l',1),new Ficha('l',1),new Ficha('m',3),
           new Ficha('m',3),new Ficha('n',1),new Ficha('n',1),new Ficha('n',1),new Ficha('n',1),new Ficha('n',1),
           new Ficha('ñ',8),new Ficha('o',1),new Ficha('o',1),new Ficha('o',1),new Ficha('o',1),new Ficha('o',1),
           new Ficha('o',1),new Ficha('o',1),new Ficha('o',1),new Ficha('o',1),new Ficha('p',3),new Ficha('p',3),
           new Ficha('q',5),new Ficha('r',1),new Ficha('r',1),new Ficha('r',1),new Ficha('r',1),new Ficha('r',1),
           new Ficha('r',1),new Ficha('r',1),new Ficha('s',1),new Ficha('s',1),new Ficha('s',1),new Ficha('s',1),
           new Ficha('s',1),new Ficha('s',1),new Ficha('t',1),new Ficha('t',1),new Ficha('t',1),new Ficha('t',1),
           new Ficha('u',1),new Ficha('u',1),new Ficha('u',1),new Ficha('u',1),new Ficha('u',1),new Ficha('v',4),
           new Ficha('x',8),new Ficha('y',4),new Ficha('z',10)};
   
   private Ficha[] mano = new Ficha[7];
   

    private int random () {
       int numerito = 0;
       Random randomGenerator = new Random();
       for (int idx = 1; idx <=this.sacodefichas.length; ++idx){
         numerito = randomGenerator.nextInt(100);
       }
       return numerito;
    }//ano[i]mano[i]mano[i]
  
    //FICHAS
    		
    public ListaFichas(){
        
        int totalFichasMano = 7-this.getMano().length; 
        while(totalFichasMano!=0){
            this.getMano()[this.getMano().length-1]=repartirFichas(); //Qué mierda hace esto?
            totalFichasMano++;
        }
     }
    		
    private Ficha[] repartirFichas(){
       while (this.getMano().length != 7){
           darFicha(mano);
       }
        return mano;
    }
    
    public Ficha[] darFicha(Ficha[] mano){
       Ficha ficha;
        ficha = (sacodefichas[random()]);
        borrarFichaDelSaco(ficha);
        mano[mano.length+1] = ficha;
       return mano;
    }
   
    public Ficha obtenerFicha(char letra){
        boolean enc = false;
        int x = 1;
        Ficha fichaaux = null;
        while (enc == false){
            fichaaux = mano[x];
            if (fichaaux.getLetra() == letra){
                enc = true;
            }
            x = x+1;
        }
        return fichaaux;
    }

    public void borrarFichaDelSaco(Ficha pFicha){
        Ficha ficha = pFicha;
        int indice = encontrarFicha(ficha);
        sacodefichas.remove(sacodefichas[indice]);
        //No puedo eliminar una Ficha de un array de fichas? WTF?
    }
   
    public int obtenerFichas(){
    	return 1;
    }
    
    public int encontrarFicha (Ficha ficha){
        int x = 1;
        boolean enc = false;
        while (enc == false){
            if (ficha==sacodefichas[x]){
                enc = true;
            }
            x = x+1;
        }
        return x;
    }

    public boolean estaLaFichaEnLaMano(char pLetra){
    	//Recrorrer la mano
    }
   
   public boolean utilizarFichas(Jugada jugada){
       boolean sinfichas = false;
      
       byte xi = Jugada.getXi();
       byte xf = Jugada.getXf();
       byte yi = Jugada.getYi();
       byte yf = Jugada.getYf();
      
       for (x=letras.size(); x<=1; x--){
           Ficha fichaaponer = letras[x]
           Tablero.casilla[xi, yi] = fichaaponer;
           if (hV == true) {
               xi = xi+1;
               else{
                   yi = yi+1;
               }
           }
       }
      
       if (sacodefichas.length == 0 && mano.length == 0){
           sinfichas=true;
       }
       return sinfichas;
   }

   //MANO
   
   public void cambiarMano(){
       while (mano.length!=0){
           Ficha fichaadevolver= (Ficha) mano[1];
           sacodefichas[sacodefichas.length+1]=(fichaadevolver);
           delete mano[1]; //Borrateeeeeeee
       }
       repartirFichas();
   }
   
   public boolean actualizarMano(){
       Ficha fichaactualizar =    Tablero[xi,yi];
       return false;
   }


    public void imprimirMano(){
        for (byte i = 0; i <= mano.length; i++){
            this.getMano(i).imprimirLetra();
        }
    }

    //GETERS
    
	public int getTotalFichasDeSaco(){
	    return sacodefichas.length;
	}
	
	public int getTotalFichasDeMano(){
		return mano.length;
	}
	
	public int getTotalFichas(){
	    return sacodefichas.length+mano.length;
	}
	
	private Ficha[] getSacodefichas() {
	    return sacodefichas;
	}
	
	public Ficha[] getMano() {
	    return mano;
	}
	
	public Ficha getMano(byte ind) {
	    return mano[ind];
	}

}