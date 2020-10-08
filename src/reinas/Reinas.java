package reinas;

import java.applet.Applet;
import java.awt.*;


class Reinas {
     
   // atributos
   private int fila;
   private int columna;
   private Reinas vecina;

   // constructor
   Reinas (int c, Reinas v) {
      fila = 1;   // empieza a buscar una solución desde la primera fila
      columna = c; // la columna que se le ha asignado a esta reina
      vecina = v;   // referencia a la reina de la izquierda
   }

   public boolean buscaSolución() {
      // si está bien colocada (nadie la puede atacar) ya es una solución:
      if ( vecina == null || !vecina.puedeAtacar(fila, columna) ) return true;
      
      // si no, intenta avanzar a una posición donde no la puedan atacar:
      if ( avanzar() ) return true;   
      
      return false; // no se ha encontrado una solución
   }

   public boolean avanzar() {   
      if ( fila < 8 ) {   // avanzar una posición y mira si hay solución
         fila++;
         return buscaSolución();
      }

      // si no puede avanzar, intenta que lo hagan las vecinas:
      if ( vecina != null  && !vecina.avanzar() )      return false;
      //if ( vecina == null  || !vecina.avanzar() )      return false;

      // habiendo avanzado la vecina,
      // vuelve a la primera fila para encontrar una nueva solución:
      fila = 1;   
      return buscaSolución();   
   }

   private boolean puedeAtacar(int testfila, int testcolumna) {
      int diferenciaColumnas = testcolumna - columna;
      if (   (fila == testfila) ||                  // en la misma fila
            (fila + diferenciaColumnas == testfila) ||   // o en una diagonal
            (fila - diferenciaColumnas == testfila))
         return true;
      
      if (vecina != null)      // mira si es atacable por las demás reinas de la izda.
         return vecina.puedeAtacar(testfila, testcolumna);
      
      return false;           // la posición no es atacable
   }
   
   void print() {
      // primero lista las vecinas
      if ( vecina!=null )   vecina.print();
      // y luego su propia posición
      System.out.println("columna "+columna+ " fila "+fila);
   }
  
} // fin de class Reina

