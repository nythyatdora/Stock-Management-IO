package Pagination;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Thread_Calculate_Time_Processing {
    //Calculate Time of Process
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        methodCalculateTime();
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println(duration);
    }

    private static void methodCalculateTime() {
        List<String> list = new ArrayList<String>();
        list.add("Hello");
        for (int i = 0; i <= 10000000; i++) {
            System.out.println(list);
        }
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();

        }
    }
}
