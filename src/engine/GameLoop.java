package engine;

public class GameLoop {

    private static boolean running = false;

    public static void iniciar() {

        Thread thread = new Thread() {

            public void run() {
                while (running) {

                }
            }

        };
        thread.setName("GameLoop");
        thread.start();
    }

}
