package reinas;

import com.sun.prism.Graphics;
import java.applet.Applet;

public class asd extends Applet {
   private Reinas últimaReina;

   public void init() {
      últimaReina = null;
      for (int i = 1; i <= 8; i++) {
         últimaReina = new Reinas(i, últimaReina);
         últimaReina.buscaSolución();
      }
   }
   
   public static void main(String[] args) { 
      int cuenta = 0;
      Reinas ultimaReina = null;
      
      for (int i = 1; i <= 8; i++) {
         ultimaReina = new Reinas(i, ultimaReina);
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