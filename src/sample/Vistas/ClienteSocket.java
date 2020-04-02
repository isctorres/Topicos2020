package sample.Vistas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ClienteSocket {

    private InetAddress direccionServidor;
    private Socket cliente;
    private byte[] ip = new byte[]{(byte)192,(byte)168,(byte)0,(byte)1};       // Direccion del servidor

    public void conectarCliente(){
        try{
            direccionServidor = InetAddress.getByAddress(ip);
            cliente = new Socket(direccionServidor,5000);
        }catch (Exception e){ e.printStackTrace(); }
    }
}
