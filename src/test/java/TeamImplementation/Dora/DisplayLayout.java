package TeamImplementation.Dora;

import java.util.Scanner;

public class DisplayLayout implements DoraTask {

    public void readDataLayout() {

    }

    public void searchDataLayout() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please Input the Name of Product : ");
        String name = scan.nextLine();

        System.out.println("Product Found for [" + name + "] : " );
    }

    public void deleteDataLayout() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please Input the ID of Product : ");
        int id = scan.nextInt();

        System.out.println("Product Found for [" + id + "] : " );

        System.out.println("Are you sure that you want to delete this record? [Y|y] or [N|n] :");

        System.out.println("Product was removed");
        scan.close();
    }
}
