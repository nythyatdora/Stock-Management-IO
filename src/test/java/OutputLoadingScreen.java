package TeamImplementation.Monita;

import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;

public class OutputLoadingScreen implements Runnable {
    private final String OUTPUT_STRING = "Please Wait, Loading.......";
    private final long Start_Time= currentTimeMillis();



    public void run() {

        for (int i = 0; i< OUTPUT_STRING.length(); i++) {
            char ch = OUTPUT_STRING.charAt(i);
            try {
                System.out.print(ch);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void startThread() {

        OutputLoadingScreen outputLoadingOnScreen = new OutputLoadingScreen();
        Thread thread = new Thread(outputLoadingOnScreen);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("Current Time Loading : ");
    }

}