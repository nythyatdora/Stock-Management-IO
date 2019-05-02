public class OutputLoadingScreen implements Runnable {
    private final int SLEEP_TIME = 500;

    public boolean isLoading = true;
    private long loadingTime;

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
        System.out.println("Current Time Loading : " + loadingTime);
    }

    public static void main(String[] args) {
        OutputLoadingScreen outputLoadingScreen = new OutputLoadingScreen();
        outputLoadingScreen.startThread();
    }

    public long getLoadingTime() {
        return loadingTime;
    }

    public void setLoadingTime(long loadingTime) {
        this.loadingTime = loadingTime;
    }
}