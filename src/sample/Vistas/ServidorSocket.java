package sample.Vistas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {

    private ServerSocket servidor;
    private Socket cliente;
    private int noClienteConectado = 0;

    public void iniciarServidor(){

        try {
            servidor = new ServerSocket(5000);
            while (true) {
                cliente = servidor.accept();    // Establecemos el canal de comunicacion ( 2 vias 1->entrada / 1->salida)
                noClienteConectado++;
                System.out.println("Llego el cliente: "+noClienteConectado);

                // Mandar mensaje al cliente
                // Recuperamos el flujo de salida desde el servidor hacia el cliente
                PrintStream salida = new PrintStream(cliente.getOutputStream());
                // Enviamos mensaje al cliente conectado
                salida.println("Bienvenido, usted es mi cliente no: "+noClienteConectado);

                // Recuperar el flujo de entrada hacia el servidor
                BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                // Leemos desde el flujo el texto enviado desde el cliente y lo imprimimos
                System.out.println(entrada.readLine());

                cliente.close();
            }
        }catch (Exception e){ e.printStackTrace(); }
    }
}
