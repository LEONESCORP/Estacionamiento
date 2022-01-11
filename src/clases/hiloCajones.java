
package clases;

import interfaces.Cajones;

public class hiloCajones extends Thread{

/* La creación de la presente clase nos permite encapcular en un hilo el JFrame
denominado Cajones, para ser llamado en varias ocasiones sin necesidad de detener 
ningun proceso.
*/
    
    @Override
    public void run() {
        Cajones cajon = new Cajones();
        cajon.setVisible(true);
    }
    public static void main(String[] args) {
        hiloCajones hcaj = new hiloCajones();
        hcaj.start();//Aqui se le da inicio al hilo Cajones
    }
}
