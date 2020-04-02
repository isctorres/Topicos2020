package sample.Componentes;

import sample.Vistas.RecursoCompartido;

public class ProductorThread extends Thread{

    RecursoCompartido objRec;
    public ProductorThread(RecursoCompartido objRec){
        this.objRec = objRec;
    }

    @Override
    public void run() {
        super.run();
        System.out.println("Inicia Hilo Productor");
        for (int i = 1; i <= 50 ; i++) {
            objRec.llenarRecurso(i);
        }
        System.out.println("Termina Hilo Productor");
    }
}
