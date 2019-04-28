package TeamImplementation.Dora;

import java.util.Scanner;

public class DisplayLayout implements DoraTask {

    public void readDataLayout() {

    }

    public void searchDataLayout() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please Input the Name of Class.Product : ");
        String name = scan.nextLine();

        System.out.println("Class.Product Found for [" + name + "] : " );
    }

    public void deleteDataLayout() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please Input the ID of Class.Product : ");
        int id = scan.nextInt();

        System.out.println("Class.Product Found for [" + id + "] : " );

        System.out.println("Are you sure that you want to delete this record? [Y|y] or [N|n] :");

        System.out.println("Class.Product was removed");
        scan.close();
    }
}
