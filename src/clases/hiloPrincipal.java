
package clases;

import interfaces.Principal;
/* La creación de la presente clase nos permite encapcular en un hilo el JFrame
denominado Principal, para ser llamado en varias ocasiones sin necesidad de detener 
ningun proceso.
*/
public class hiloPrincipal extends Thread{
    
    @Override
    public void run() {
        Principal princi = new Principal();
        princi.setVisible(true);
    }
    
    public static void main(String[] args) {
        
        hiloPrincipal hp = new hiloPrincipal();
        hp.start();//Aquí se le da inicio al hilo principal
        
    }

    
}
