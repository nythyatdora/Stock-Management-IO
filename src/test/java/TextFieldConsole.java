import java.util.Scanner;

public class TextFieldConsole {

    public static char readCharType(String placeholder) {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine().split(" ")[0].charAt(0);
    }

    public static int readIntegerType(String placeholder) {
        Scanner scan = new Scanner(System.in);
        return Integer.parseInt(scan.nextLine().split(" ")[0]);
    }

    public static String readStringType(String placeholder) {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine().split(" ")[0];
    }
}
