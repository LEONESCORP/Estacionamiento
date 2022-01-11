
package clases;

import interfaces.Altas;
/* La creación de la presente clase nos permite encapcular en un hilo el JFrame
denominado Altas, para ser llamado en varias ocasiones sin necesidad de detener 
ningun proceso.
*/
public class hiloAltas extends Thread{

    @Override
    public void run() {
        Altas alto = new Altas();
        alto.setVisible(true);
    }
    public static void main(String[] args) {
        hiloAltas alt = new hiloAltas();
        alt.start();
    }
    
    
}
