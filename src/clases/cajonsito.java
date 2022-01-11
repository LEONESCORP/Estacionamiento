package clases;

import java.awt.Color; //Libreria para dar color
import java.awt.event.ActionEvent;// Para el llamado de eventos
import java.awt.event.ActionListener;// Para la escucha de eventos
import javax.swing.JButton; // para la creacion de botones


public class cajonsito extends JButton implements ActionListener{

public cajonsito (int posx, int posy, int ancho, int alto){
    super.setBounds(posx, posy, ancho, alto);
    addActionListener(this);
    
    
}
public void cambiarNombre(int x, int y){
    setText( (x+1)+"-"+(y+1));
}

 public void setNombre( int f, int c ){//para setear el nombre
        setText( (f+1) + "" + (c+1) );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setBackground(Color.GREEN);// Aplicación del color verde al boton
        
    }

   
}
