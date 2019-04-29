public class OutputLoadingScreen implements Runnable {
    public boolean isLoading = true;
    private final int SLEEP_TIME = 500;

    public void run() {
        final String LOADING_STRING = "Loading";
        System.out.println("Please Wait :");

        for(int i=0; i<LOADING_STRING.length(); i++) {
            char ch = LOADING_STRING.charAt(i);
            try {
                System.out.print(ch);
                Thread.sleep(SLEEP_TIME);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        while(isLoading) {
            try {
                System.out.print(".");
                Thread.sleep(SLEEP_TIME);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void startThread() {
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

    public static void main(String[] args) {
        OutputLoadingScreen outputLoadingScreen = new OutputLoadingScreen();
        outputLoadingScreen.startThread();
    }
}