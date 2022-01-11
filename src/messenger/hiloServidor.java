
package messenger;

//Importamos nuestras librerias
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

//Nombre de nuestra clase extendida del metodo de hilos Thread
public class hiloServidor extends Thread{
    
    //Declaración de nuestras constantes
    private DataInputStream entrada;
    private DataOutputStream salida;
    private ventanaServidor server;
    private Socket ventanaCliente;
    public static Vector<hiloServidor> usuarioActivo = new Vector();
    private String nombre;
    private ObjectOutputStream salidaObjeto;
    
    
    public hiloServidor(Socket socketcliente, String nombre, ventanaServidor serv)throws Exception{
        this.ventanaCliente = socketcliente;
        this.server = serv;
        this.nombre = nombre;
        usuarioActivo.add(this);
        
        for (int i = 0; i < usuarioActivo.size(); i++) {
            usuarioActivo.get(i).enviosMensajes(nombre + " Se ha conectado. ");
            
        }
    }
    //Arrancamos nuestro metodo run
    public void run(){
        String mensaje= " ";
        while(true){
            try {
                entrada = new DataInputStream(ventanaCliente.getInputStream());
                mensaje = entrada.readUTF();
                
                for (int i = 0; i < usuarioActivo.size(); i++) {
                    usuarioActivo.get(i).enviosMensajes(mensaje);
                    server.mensajeria("Mensaje Enviado");
                }
                
            } catch (Exception e) {
                break;
            }
        }
        usuarioActivo.removeElement(this);
        server.mensajeria("El usuario se ha desconectao: ");
        
        try {
            ventanaCliente.close();
        } catch (Exception e) {
        }
    }
    
    //Delaración de nuestra clase EnviosMensajes
    private void enviosMensajes(String msg) throws Exception{
        salida = new DataOutputStream(ventanaCliente.getOutputStream());
        salida.writeUTF(msg);
        DefaultListModel modelo = new DefaultListModel();
        
        for (int i = 0; i < usuarioActivo.size(); i++) {
            modelo.addElement(usuarioActivo.get(i).nombre);
            
        }
        salidaObjeto = new ObjectOutputStream(ventanaCliente.getOutputStream());
        salidaObjeto.writeObject(modelo);
    }
    
    
}
