package sample.Componentes;

public class Hilo extends Thread{

    public Hilo(String nomHilo) {
        setName(nomHilo);
    }

    @Override
    public void run() {
        super.run();

        System.out.println("Inicia Corredor"+getName());
        for (int i = 1; i < 5 ; i++) {
            try {
                sleep((long) (Math.random() * 5000));
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("Corredor "+getName()+" termino el km "+i);
        }
        System.out.println("Corredor " + getName() + " llego a la meta");
    }
}
