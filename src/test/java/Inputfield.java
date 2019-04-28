import java.util.Scanner;

public class Inputfield implements InputType {

    public char readCharType(String placeholder) {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine().split(" ")[0].charAt(0);
    }

    public int readIntegerType(String placeholder) {
        Scanner scan = new Scanner(System.in);
        return Integer.parseInt(scan.nextLine().split(" ")[0]);
    }

    public String readStringType(String placeholder) {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine().split(" ")[0];
    }
}
