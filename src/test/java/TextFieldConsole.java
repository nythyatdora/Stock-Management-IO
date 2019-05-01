import java.util.Scanner;

public class TextFieldConsole {

    public static int readIntegerType(String placeholder) {
        int i;
        Scanner scan = new Scanner(System.in);
        System.out.print(placeholder);
        try {
            i = Integer.parseInt(scan.nextLine().split(" ")[0]);
        } catch (RuntimeException e) {
            i = -1;
        }

        return i;
    }

    public static double readDoubleType(String placeholder) {
        Double d;
        Scanner scan = new Scanner(System.in);
        System.out.print(placeholder);

        try {
            d = Double.parseDouble(scan.nextLine().split(" ")[0]);
        } catch (RuntimeException e) {
            d = 0D;
        }

        return d;
    }

    public static char readCharType(String placeholder) {
        char c;
        Scanner scan = new Scanner(System.in);
        System.out.print(placeholder);

        try {
            c = scan.nextLine().split(" ")[0].charAt(0);
        } catch (RuntimeException e) {
            c = '\0';
        }


        return c;
    }

    public static String readStringType(String placeholder) {
        String str;
        Scanner scan = new Scanner(System.in);
        System.out.print(placeholder);
        try {
            str = scan.nextLine().split(" ")[0];
        }
        catch (RuntimeException e) {
            str = "\0";
        }

        return str;
    }

    public static void main(String[] args) {
//        char c;
//        c = TextFieldConsole.readCharType("Input char : ");
//        System.out.println("c : " + c);

//        int i;
//        i = TextFieldConsole.readIntegerType("Input i : ");
//        System.out.println("i : " + i);

        String s;
        s = TextFieldConsole.readStringType("Input s : ");
        System.out.println("s : " + s);

//        double d;
//        d = TextFieldConsole.readDoubleType("Input d : ");
//        System.out.println("d : " + d);
    }
}
