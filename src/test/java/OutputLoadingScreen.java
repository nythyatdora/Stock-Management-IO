public class OutputLoadingScreen implements Runnable {
    private final String OUTPUT_STRING = "Please Wait, Loading.......";

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