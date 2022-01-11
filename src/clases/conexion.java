package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conexion {
    // declaramos las privadas para la conexión
    private static Connection con;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String contraseña = "";
    private static final String url = "jdbc:mysql://localhost:3306/final";

    public conexion() {
        con = null;
        //Iniciamos un Try Catch para encapsular los errores al iniciar la conexión
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, contraseña);
            if(con!=null){
                System.out.println("Conexión Exitosa!!!");
            }
            //Mensaje que arrojara en caso de un grave error
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("Error de Conexión" + e);
            
        } 
    }
    //Para lograr la conexión de BD
    public Connection getConnection(){
        return con;
    }
    

    //Para salir de la conexión de BD
    public void desconectar(){
        con = null;
        
        if(con == null){
            System.out.println("Termino de Conexión");
        }
    }

    public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}