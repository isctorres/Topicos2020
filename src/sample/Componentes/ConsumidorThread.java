package sample.Componentes;

import sample.Vistas.RecursoCompartido;

public class ConsumidorThread extends Thread{

    RecursoCompartido objRec;
    public ConsumidorThread(RecursoCompartido objRec){
        this.objRec = objRec;
    }

    @Override
    public void run() {
        super.run();
        System.out.println("Inicia Hilo Consumidor");
        for (int i = 1; i <= 50 ; i++) {
            objRec.vaciarRecurso();
        }
        System.out.println("Termina Hilo Consumidor");
    }
}
