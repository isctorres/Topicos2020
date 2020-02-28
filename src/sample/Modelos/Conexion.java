package sample.Modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String host = "127.0.0.1";
    private static final String user = "topicos20";
    private static final String pwd = "1234";
    private static final String db  = "otso";
    public static Connection con;

    public static void crearConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Estamos abriendo el socket hacia el SGBD
            con = DriverManager.getConnection("jdbc:mysql://"+host+":3306/"+db+"?useSSL=false",user,pwd);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
