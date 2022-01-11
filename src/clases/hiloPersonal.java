
package clases;

import interfaces.Personal;

public class hiloPersonal extends Thread{
/* La creación de la presente clase nos permite encapcular en un hilo el JFrame
denominado Personal, para ser llamado en varias ocasiones sin necesidad de detener 
ningun proceso.
*/
    @Override
    public void run() {
        Personal person = new Personal();
        person.setVisible(true);
    }
    
    public static void main(String[] args) {
        hiloPersonal hper = new hiloPersonal();
        hper.start();// Aqui se le da iniicio al hilo Personal
    }
    
    
}
