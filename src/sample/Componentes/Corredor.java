package sample.Componentes;

import javafx.scene.control.ProgressBar;

public class Corredor extends Thread{

    private ProgressBar pgbPista;
    public Corredor(ProgressBar pgbPista){
        this.pgbPista = pgbPista;
    }

    @Override
    public void run() {
        super.run();
        double avance = 0;
        while( avance < 1 ){
            avance += Math.random() / 10; // .25 / 10
            this.pgbPista.setProgress(avance);
            try{
                sleep((long)(Math.random() * 2000));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
