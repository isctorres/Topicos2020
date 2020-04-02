package sample.Vistas;

public class RecursoCompartido {

    // Recurso compartido por los hilos
    public int[] arreglo = new int[5];
    public int tope = 0;
    public boolean detenerHilo = false;

    // Este metodo es llamado por el hilo productor
    public synchronized void llenarRecurso(int valor){
        try {

            while( detenerHilo ){
                System.out.println("Se detuvo el hilo PRODUCTOR");
                wait();
                System.out.println("Se reanudo el hilo PRODUCTOR");
            }

            System.out.println("Recurso["+tope+"] = "+valor);
            arreglo[tope] = valor;
            tope++;

            if( tope == arreglo.length ) {
                detenerHilo = true;
                tope--;
                notifyAll();
            }
        }catch (Exception e){e.printStackTrace();}
    }

    // Este metodo es llamado por el hilo consumidor
    public synchronized void vaciarRecurso(){
        try{

            while( detenerHilo == false ){
                System.out.println("Se detuvo el hilo CONSUMIDOR");
                wait();
                System.out.println("Se reanudo el hilo CONSUMIDOR");
            }

            System.out.println("valor = Recurso["+tope+"] : "+ arreglo[tope]);
            tope--;
            if( tope < 0 ){
                tope++;
                detenerHilo = false;
                notifyAll();
            }
        }
        catch (Exception e){e.printStackTrace(); }
    }
}
