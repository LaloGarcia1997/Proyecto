package reinas;

import java.applet.Applet;
import java.awt.*;


class Reinas {
   private int fila;
   private int columna;
   private Reinas vecina;
   Reinas (int c, Reinas v) {
      fila = 1;  
      columna = c; 
      vecina = v; 
   }

   public boolean buscaSolución() {
      if ( vecina == null || !vecina.puedeAtacar(fila, columna) ) 
          return true;
      if ( avanzar() ) 
          return true;   
      return false; 
   }

   public boolean avanzar() {   
      if ( fila < 8 ) {  
         fila++;
         return buscaSolución();
      }
      if ( vecina != null  && !vecina.avanzar() )     
          return false;
      fila = 1;   
      return buscaSolución();   
   }

   private boolean puedeAtacar(int testfila, int testcolumna) {
      int diferenciaColumnas = testcolumna - columna;
      if (   (fila == testfila) || (fila + diferenciaColumnas == testfila) || (fila - diferenciaColumnas == testfila))
         return true;      
      if (vecina != null)      
         return vecina.puedeAtacar(testfila, testcolumna);
      
      return false;         
   }
   
   void print() {
      if ( vecina!=null )  
          vecina.print();
      System.out.println("columna "+columna+ " fila "+fila);
   }
  
}

