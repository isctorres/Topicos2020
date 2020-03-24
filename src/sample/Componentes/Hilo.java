public class Hilo extends Thread{
    @override
    public void run(){

        System.out.println("Inicia Corredor"+getName());
        for (int i = 1; i < 5 ; i++) {
            sleep( (long)( Math.random() * 2000) );
        }
    }
}

// Sonic -> Hilo1
// Rubensin -> Hilo2
// Hulk -> Hilo3
// El prisas -> Hilo4
// Limas -> Hilo5