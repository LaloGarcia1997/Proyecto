package reinas;

import com.sun.prism.Graphics;
import java.applet.Applet;

public class asd extends Applet {
   private Reinas últimaReina;

   public void init() {
      últimaReina = null;
      for (int i = 1; i <= 8; i++) {
         // crea una reina
         últimaReina = new Reinas(i, últimaReina);
         // e intenta colocarla sin que nadie le ataque
         últimaReina.buscaSolución();
      }
   }

   public boolean mouseDown(java.awt.Event evt, int x, int y) {
      últimaReina.avanzar();  // busca otra solución
      repaint();
      return true;
   }
   
   public static void main(String[] args) { // hace lo mismo que el applet
      int cuenta = 0; // cuenta de todas las posibles soluciones
      Reinas ultimaReina = null;
      
      for (int i = 1; i <= 8; i++) {
         // crea una reina
         ultimaReina = new Reinas(i, ultimaReina);
         // e intenta colocarla sin que nadie le ataque
         if ( !ultimaReina.buscaSolución() )
               System.out.println("No hay solución");
      }   
         
      System.out.println("Soluciones al problema de las 8 reinas");
      do {
         System.out.println("\nSolución " + ++cuenta + " ==============" );
         ultimaReina.print();
      }
      while ( ultimaReina.avanzar() );   }
}