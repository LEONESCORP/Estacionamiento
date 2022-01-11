
package messenger;

//Importamo nuestras librerias 
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.DefaultListModel;

//Creamos uestra clase principal extendida de hilo Thread
public class hiloCliente extends Thread{
    private Socket SocketCliente;
    private DataInputStream entrada;
    private ventanaCliente cliente;
    private ObjectInputStream entradaObjeto;
    
    
    public hiloCliente (Socket SocketCliente, ventanaCliente cliente){
        this.SocketCliente = SocketCliente;
        this.cliente = cliente;
    }
    
    //Arrancamos nuestro run 
    public void run(){
        
        while(true){
            try {
                entrada = new DataInputStream(SocketCliente.getInputStream());
                cliente.mensajeria(entrada.readUTF());
                
                entradaObjeto = new ObjectInputStream(SocketCliente.getInputStream());
                cliente.actualizarLista((DefaultListModel) entradaObjeto.readObject());
            } catch (ClassNotFoundException ex) {
                
            } catch(IOException ex){
                Logger.getLogger(hiloCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
       
    }

}
